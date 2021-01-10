
package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CheckRulesOfPosition {
	public boolean applayChecking(String Filename,String Position,int number) throws FileNotFoundException {
		File myObj = new File(Filename+".txt");
		Scanner myReader = new Scanner(myObj);
		int k=0;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			String[]  SplitOfLine= data.split(" ");
			String PositionOfFile=SplitOfLine[1];
			String[]  SplitPosition=PositionOfFile.split(":");
			String PositionOfPlayerInFile=SplitPosition[1];
			
		if(PositionOfPlayerInFile.equals(Position))
		{
		 k++;
		}
			
			
		}
		myReader.close();
		if(k<=number)
			return true;
		else 
			return false;
		
	}

}