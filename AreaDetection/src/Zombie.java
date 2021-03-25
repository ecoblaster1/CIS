import java.util.Random;

public class Zombie {
private double x;
private double y;

public Zombie() {
	Random rand = new Random();
	this.x = rand.nextInt(9);
	this.y = rand.nextInt(9);
}
public Zombie(double x, double y) {
	this.x = x;
	this.y = y;
}
public double getDistance(double x2, double y2) {
	return Math.sqrt(((x-x2)*(x-x2)) + ((y-y2)*(y-y2)));
}

}
