import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Car {
	private int x,y,spd,kills,allKills;
	private String VIN;
	private Scanner scan;
	public Car(){
		String VIN="";
		x=y=spd=kills=allKills=0;
	}
	public void update(File file){
		try {
			scan = new Scanner(file);
			VIN = scan.next();
			x = scan.nextInt();
			y = scan.nextInt();
			spd = scan.nextInt();
			kills = scan.nextInt();
			allKills += kills;
		} catch (FileNotFoundException e) {
			update(file);
		}
	}
	public boolean isAround(int halfLimit){
		return Math.abs(x)<=halfLimit && Math.abs(y)<=halfLimit;
	}
	public int getSpd(){
		return spd;
	}
	public int getCK(){
		return kills;
	}
	public String getVIN(){
		return VIN;
	}
	
	public String toString(){
		return  "VIN =\t"+VIN+" \n"+
				"x =\t"+x+" \n"+
				"y =\t"+y+" \n"+
				"speed =\t"+spd+" \n"+
				"Hobo Kills =\t"+kills+" \n"+
				"Total Kills =\t"+allKills;
	}
	
}
