import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class CarRunner{
	@SuppressWarnings("resource")
	public static void main(String[]args) throws IOException{
		Scanner listen;
		Car hoboKiller = new Car("57862347");
		for(int t = 0;;t++){
			listen = new Scanner(new File("carRead.txt"));
			listen.useDelimiter("\\z");
			if(t%50==0){
				hoboKiller.update(listen.next());
				System.out.println(hoboKiller);
			}
		}
	}
}
