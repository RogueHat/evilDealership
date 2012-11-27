import java.util.ArrayList;


public class Charges {
	private final int 	
		HALFSIDE 	= 1000, 
		OUTCHARGE 	= 10000,
		SPDCHARGE	= 30000;
	
	private Car car;
	private int newCharges,totalCharges;
	private ArrayList<String> list = new ArrayList<String>();
	public Charges(Car newCar){
		car=newCar;
		newCharges=totalCharges=0;
	}
	public void payUp(int time){
		boolean isGuilty=false;
		newCharges=0;
		if(!car.isAround(HALFSIDE)){
			isGuilty = true;
			newCharges += OUTCHARGE;
			list.add("Outside Range.\tCharge = "+OUTCHARGE);
		}
		if(car.getSpd()>=150){
			isGuilty = true;
			newCharges-=50;
			list.add("Speeding Bonus.\tCharge = -50");
		}else if(car.getSpd()>=60){
			isGuilty = true;
			newCharges+=SPDCHARGE;
			list.add("Speeding.\tCharge = "+SPDCHARGE);
		}
		if(car.getCK()<20&&car.getCK()>0){
			isGuilty = true;
			newCharges+= 30*car.getCK();
			list.add("Hobos Killed.\tCharge = "+30*car.getCK());
		}else if(car.getCK()>0){
			isGuilty = true;
			newCharges-= 20*car.getCK();
			list.add("Killing Spree Bonus.\tCharge = "+(-20*car.getCK()));
		}
		if(isGuilty){
			list.add(car.getVIN()+"\tTime = "+time+"\tTotalCharge = "+newCharges+"\n");
		}
		totalCharges+=newCharges;
	}
	public String toString(){
		return "Charges =\t"+totalCharges;
	}
	public String getList(){
		String out="";
		try{
			for(String entry:list)
				out+=entry+"\n";
		}catch(Exception e){
			System.err.println(e);
			return getList();
		}
		return out;
	}
}
