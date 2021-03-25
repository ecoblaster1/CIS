import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Lab16 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String userinput;
		System.out.println("Which story would you like to work with?");
		userinput = scan.nextLine();
		
		if (userinput.equals("story1.txt")) {
			FileInputStream infs = new FileInputStream("story1.txt");
		
			Scanner inputScan = new Scanner(infs);
		
			while (inputScan.hasNextLine()) {
				String line = inputScan.nextLine();
				System.out.println(line);
			}
			infs.close();
		
			System.out.println("Add a line:");
			String line = scan.nextLine();
		
			FileOutputStream outfs = new FileOutputStream("story1.txt", true);
			PrintWriter pw = new PrintWriter(outfs);
		
			pw.println(line);
			pw.flush();
		
			outfs.close();
		}
		else if (userinput.equals("story2.txt")) {
			FileInputStream infs = new FileInputStream("story2.txt");
			
			Scanner inputScan = new Scanner(infs);
			
			while (inputScan.hasNextLine()) {
				String line = inputScan.nextLine();
				System.out.println(line);
			}
			infs.close();
			
			System.out.println("Add a line:");
			String line = scan.nextLine();
			
			FileOutputStream outfs = new FileOutputStream("story2.txt", true);
			PrintWriter pw = new PrintWriter(outfs);
			
			pw.println(line);
			pw.flush();
			outfs.close();
			
		}
	}

}
