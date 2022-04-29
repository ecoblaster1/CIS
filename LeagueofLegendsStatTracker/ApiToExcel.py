import requests
import json
from riotwatcher import LolWatcher, ApiError
import pandas as pd

api_key = 'RGAPI-6fe9f72c-7bc4-45d6-b37f-f0b4e16fd55b'
url = 'https://developer.riotgames.com/apis#match-v4/GET_getMatch'
response = requests.get(url)

