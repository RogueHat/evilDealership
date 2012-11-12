import java.util.*;
public class Car {
	/**
	 * This is Carlo Speaking
	 * 
	 * Please rethink some of this...
	 * booleans should only return booleans and do nothing else.
	 */
	
	
	
	
	Scanner scan;
	int leftBound = -100;
	int rightBound = 100;
	int topBound = 100;
	int botBound = -100;
	double charge;
	int speed;
	int x;
	int y;
	int deadHobos;
	double time;
	String VIN;
	ArrayList<String> offenses = new ArrayList<String>();
	public Car(String newVIN) {
		VIN = newVIN;
		x = 0;
		y =0;
		speed = 0;
		charge = .99;
		deadHobos = 0;
	}
	public String getVIN() {
		return VIN;
	}
	public int getX() {
		return x;
	}
	public void setX(int newX) {
		x=newX;
	}
	public int getY() {
		return y;
	}
	public void setY(int newY) {
		y= newY;
	}
	public int getSpeed() {
		return speed;
	}
	
	public String toString(){
		return 	"x = "+getX()+"\t"+
				"y = "+getY()+"\t"+
				"Speed = "+getSpeed()+"\t"+
				"charges = "+getcharge()
				;
	}
	
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	public double getcharge() {
		return charge;
	}
	public void setCharge(double newCharge) {
		charge = newCharge;
	}
	public int getDeadHobos() {
		return deadHobos;
	}
	public void setDeadHobos(int newDeadHobos) {
		deadHobos = newDeadHobos;
	}
	public boolean isSpeeding() {
		if(speed > 60 && speed < 150) {
			charge += 30000;
			return true;
		}
		if(speed >= 150)
			charge -= 50;
		return false;
	}
	public boolean hoboToll() {
		if (getDeadHobos() < 20) {
			charge += (getDeadHobos() * 30);
			return true;
		}
		if (getDeadHobos() >= 20)
			charge -= (20 * getDeadHobos());
		return false;
	}
	public boolean isOutside() {
		if(x<leftBound || x > rightBound || y < botBound || y > topBound) {
			charge += 10000;
			return true;
		}
		return false;
	}
	public void update(int newX, int newY, int newSpeed, int newDeadHobos) {
		String newOffense = "";
		setX(newX);
		setY(newY);
		setSpeed(newSpeed);
		newDeadHobos += getDeadHobos();
		setDeadHobos(newDeadHobos);
		if(isOutside()) {
			newOffense = "Outside of driving boundaries "  + " with car " + getVIN();
			offenses.add(newOffense);
		}
		if(isSpeeding()) {
			newOffense = "Speeding at " + " with car " + getVIN();
			offenses.add(newOffense);
		}
		if(hoboToll()) {
			newOffense = "You killed some hobos at " + " with car " + getVIN();
			offenses.add(newOffense);
		}
	}
	public void update(String str){
		scan = new Scanner(str);
		this.update(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
		scan.close();
	}
}
