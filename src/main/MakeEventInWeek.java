
package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class MakeEventInWeek {
	
	public String Eventline(int event) throws IOException
	{
		File myObj = new File("event.txt");
		Scanner myReader = new Scanner(myObj);
		int k=1;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			if(k==event)
			{
				return data;
			}
			k++;
			
		}
		myReader.close();
		return null;
	}
public void EventOfWeek(String week,int event,String name) throws IOException
{
	        PrintOnFile print=new PrintOnFile();
			print.printonfile(Eventline(event)+" by:"+name, "week"+week+".txt");
}
public void PrintEventOfWeek(String week) throws IOException
{
	File myObj = new File("week"+week+".txt");
	Scanner myReader = new Scanner(myObj);
	boolean b=false;
	while(myReader.hasNextLine()) {
		String data = myReader.nextLine();
		System.out.println(data);		
	}
	myReader.close();
}
}