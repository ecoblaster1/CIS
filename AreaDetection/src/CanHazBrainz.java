import java.util.Scanner;
public class CanHazBrainz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan = new Scanner(System.in);

final int ZOMBIE_COUNT = 5;
double survivorx;
double survivory;

System.out.println("Enter your x position: ");
survivorx = scan.nextDouble();
System.out.println("Enter your y position: ");
survivory = scan.nextDouble();

Zombie survivor = new Zombie(survivorx, survivory);
Zombie [] horde = new Zombie [ZOMBIE_COUNT];
	
for (int i = 0; i < ZOMBIE_COUNT; i++) {
	horde[i] = new Zombie();
}
for (int i = 0; i < ZOMBIE_COUNT; i++) {
	if (horde[i].getDistance(survivorx, survivory) <= 5) {
		System.out.println("Brainzzzzzz!!!");
	}
}
	}

}
