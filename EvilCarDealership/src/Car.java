
public class Car {
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
	public Car() {
		x = 0;
		y =0;
		speed = 0;
		charge = .99;
		deadHobos = 0;
	}
	public void isInside() {
		if(x<leftBound || x > rightBound || y < botBound || y > topBound)
			charge += 10000;
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
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	public double getcharge() {
		return charge;
	}
	public void setCharge(double j) {
		charge = j;
	}
	public int getDeadHobos() {
		return deadHobos;
	}
	public void setDeadHobos(int newDeadHobos) {
		deadHobos = newDeadHobos;
	}
	public void isSpeeding() {
		if(speed > 60 && speed < 150) 
			charge += 30000;
		if(speed > 150)
			charge -= 50;
	}
	public void hoboToll() {
		if (getDeadHobos() < 20) 
			charge += (getDeadHobos() * 30);
		if (getDeadHobos() >= 20)
			charge -= (20 * getDeadHobos());
	}
	public void update(int newX, int newY, int newSpeed, int newDeadHobos) {
		setX(newX);
		setY(newY);
		setSpeed(newSpeed);
		setDeadHobos(newDeadHobos);
		isInside();
		
	}
}
