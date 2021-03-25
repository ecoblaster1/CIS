import java.util.Scanner;
public class Circles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double PI = 3.14159;
		double radius;
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the radius?");
		radius = scan.nextDouble();
		System.out.println("The circumference is " + (2*PI*radius));
		System.out.println("The area is " + (PI*(radius*radius)));
	}

}
