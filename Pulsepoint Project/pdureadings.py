#Created by Saumik Abedin & Preston Connors @ Pulsepoint 8/12/2022
from re import X
from tkinter import Y
import paramiko
import socket
import ipaddress
import csv
import requests
from urllib.parse import urljoin

print("Start of script")

def get_dctrack_data():
    search = {'columns': [
                          {
                           'name': 'cmbLocation',
                           'filter': {'eq': 'MA2 > CAGE 15A'}
                          },
                          {
                           'name': 'tiClass',
                           'filter': {'eq': 'Device'}
                          },
                          {
                           'name': 'cmbStatus',
                           'filter': {'eq': 'Installed'}
                          },
                         ],
                "selectedColumns":[
                    {"name":"tiName"},
                    {"name":"cmbLocation"},
                    {"name":"cmbCabinet"},
                    {"name":"cmbUPosition"},
                    {"name":"cmbMake"},
                    {"name":"cmbModel"}
                ]
             }
    url = urljoin('https://dctrack.pulsepoint.com', ('/api/v2/quicksearch/items?pageNumber=0&pageSize=0'))
    r = requests.post(url, auth=('api', 'mae*d6Ma'), json=search)
    r.raise_for_status()
    if r.json()['searchResults']['items']:
        return r.json()['searchResults']['items']
    else:
        return None
#get_dctrack_data is for pulling and storing dctrack details about the servers in a hostname dictionary

def get_power(host):
    command = "get system.Power.Max.LastWeek"   
    username = "root"
    password = #this password is set equal to the SSH password needed to access the servers
    client = paramiko.client.SSHClient()
    client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    client.connect(host, username=username, password=password)
    stdin, stdout, stderr = client.exec_command("get system.Power.Max.LastWeek")
    output = stdout.read().decode()
    client.close()
    return output
#get_power(host) takes host as a parameter, connects to servers and request power info using Paramiko module 
#Change this so that the user enters the username and password

hostname = get_dctrack_data()
#hostname is the dictionary that stores the specified details 

x=1
#x is the value of the progress in the beginning
for host in hostname: #iterating through hostname and recording
    y = len(hostname) #y is the max number of servers being called
    try:    
        ip_address = socket.gethostbyname(host['tiName'])
    except:
        ip_address = None
        pass
        #Using the socket module we are able to use the hostname to return ip addresses and we catch the error for servers with no ip address

    if ip_address is not None:

        host['ip_idrac'] = ipaddress.ip_address(ip_address) + 65536
        host['ip_base'] = ipaddress.ip_address(ip_address)
        parts = get_power(str(host['ip_idrac'])).split()
        #print(parts), used for seeing which part we are capturing 
        host['power'] = parts[0] 
        host['power measurement'] = parts[1]
     #Using the ip address module we are able to modify the ip we retrieved from socket and save it to our dictionary
    if x != y:
        print("Processing (" + str(x) + "/" + str(y) + ")..." )
    else:
        print("Processing (" + str(x) + "/" + str(y) + ")... End of Script")
    #A loop that prints out our progress 
    x = x + 1
    #print(host), used for debugging

with open('/Users/saumikabedin/Downloads/pdureading.csv', 'w') as f:    #Designate your path here
    writer = csv.writer(f)
    writer.writerow(host)
    for host in hostname:
        writer.writerow(host.values())
#Using the csv module we write the designated csv path: /Users/saumikabedin/Downloads/pdureading.csv
#change the path to your csv file
