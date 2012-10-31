
public class Car {
	int leftBound = -100;
	int rightBound = 100;
	int topBound = 100;
	int botBound = -100;
	double charge;
	int speed;
	int x;
	int y;
	public Car() {
		x = 0;
		y =0;
		speed = 0;
		charge = .99;
	}
	public void isInside() {
		if(x<leftBound || x > rightBound || y < botBound || y > topBound)
			charge += 10000;
	}
	public int getx() {
		return x;
	}
	public void setx(int X) {
		x=X;
	}
	public int gety() {
		return y;
	}
	public void sety(int Y) {
		y=Y;
	}
	public int getSpeed() {
		
	}
	public double getcharge() {
		return charge;
	}
	public void setCharge(double j) {
		charge = j;
	}
}
