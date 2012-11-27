import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Car {
	private int x,y,spd,kills,allKills,dir;
	private String VIN;
	private Scanner scan;
	public Car(){
		String VIN="";
		x=y=spd=kills=allKills=dir=0;
	}
	public void update(File file){
		try {
			scan = new Scanner(file);
			VIN = scan.next();
			x = scan.nextInt();
			y = scan.nextInt();
			spd = scan.nextInt();
			dir = scan.nextInt();
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
	
	private FileWriter out;
	public void move(File file) throws IOException{
		update(file);
		x+=spd*Math.acos(Math.toRadians(dir));
		y+=spd*Math.asin(Math.toRadians(dir));
		out = new FileWriter("carRead.txt");
		out.write(toText());
		out.close();
	}
	
	public String toText(){
		return VIN+" "+x+" "+y+" "+spd+" "+dir+" "+kills
				+"\nVIN, x, y, speed, direction, dead hobos";
	}
	/*
	57862347 0 0 90 45 0
	VIN, x, y, speed, direction, dead hobos
	 */
	
}
