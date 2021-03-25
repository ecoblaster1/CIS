import java.util.*;

public class PasswordValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan = new Scanner(System.in);
String password;
System.out.println("Enter your password?");
password=scan.nextLine();

int digitCount = 0;
int upperCount = 0;
int lowerCount = 0;

for (int i = 0; i < password.length(); ++i) {
	char c = password.charAt(i);

	if (Character.isDigit(c)) {
		digitCount = digitCount + 1;
	}
	else if (Character.isUpperCase(c)) {
		upperCount = upperCount + 1;
	}
	else if (Character.isLowerCase(c)) {
		lowerCount = lowerCount + 1;
	}
}
if (digitCount >= 1 && upperCount >= 1 && lowerCount >= 1) {
	System.out.println("Valid Format");
}
else {
System.out.println("Invalid Format!");
	}

}
}