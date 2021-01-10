
package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class Squad {
	ArrayList<infoPlayer> squads;
	String user;
    String Position[]={ "Goalkeeper", "Defender","Midfielder","Forward"};
      int RulesPosition[]={ 2, 5,5,3};
      PrintOnFile print=new PrintOnFile();
	public Squad(String user)
	{
		this.user=user;
	     squads=new ArrayList<infoPlayer>();
	}
	public void addScore(String score) throws IOException
	{
		print.printonfile("Score of squad:"+score,user+".txt");
	}
	public void addPlayerinSquad(String name) throws FileNotFoundException
	{ 
		Player player=new Player();
		infoPlayer inf=player.foundPlayer(name);
		if(inf !=null)
		{
		squads.add(inf);
		try {
			print.printonfile("Name:"+inf.getname()+" "+"Position:"+inf.getposition()+" "+"Nationality:"+inf.getnationality()+" "+"Club:"+inf.getclub()+" "+"Value:"+inf.getvalue()+" "+"Point:"+inf.getpoint()+"\n",user+".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 
		else
			System.out.println("sorry, this name is not found");
		CheckRulesOfPosition check=new CheckRulesOfPosition() ;
		boolean t=true;
		for(int i=0;i<4;i++)
		{
			boolean t1=check.applayChecking(user,Position[i] ,RulesPosition[i]);
			if(t1==false)
			{
				System.out.println("the squad is out of range in position:"+Position[i]);
			    t=false;
			}
		}
		if(t==true)
			System.out.println("the squad is in range ");
	}
	
	public int calculateValue() throws FileNotFoundException
	{
		int sum=0;
		File myObj = new File(user+".txt");
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String value=x[4];
			String[]  y= value.split(":");
			String nomber=y[1];
			int foo=Integer.parseInt(nomber);
			sum=sum+foo;
		}
		myReader.close();
		return sum;	
	}
	public int calculateScore() throws FileNotFoundException
	{
		int sum=0;
		File myObj = new File(user+".txt");
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String value=x[5];
			String[]  y= value.split(":");
			String nomber=y[1];
			int foo=Integer.parseInt(nomber);
			sum=sum+foo;
		}
		myReader.close();
		return sum;	
	}
	public boolean calculatefirstime() throws FileNotFoundException
	{
		int sum=0;
		File myObj = new File(user+".txt");
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String value=x[4];
			String[]  y= value.split(":");
			String nomber=y[1];
			int foo=Integer.parseInt(nomber);
			sum=sum+foo;
		}
		myReader.close();
		if(sum<=100)
			return true;
		else
			return false;
	}
	public void changeSquad(infoPlayer oldplayer,infoPlayer newplayer) throws IOException
	{
	File inputFile = new File(user+".txt");
    Path path = FileSystems.getDefault().getPath("myTempFile.txt");
	File userfile = new File(path.toString());
	File tempFile = new File("myTempFile.txt");

	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	String lineToRemove = "Name:"+oldplayer.getname()+" "+"Position:"+oldplayer.getposition()+" "+"Nationality:"+oldplayer.getnationality()+" "+"Club:"+oldplayer.getclub()+" "+"Value:"+oldplayer.getvalue();
	String currentLine;
	//System.out.println(lineToRemove);
	while((currentLine = reader.readLine()) != null) {
	    String trimmedLine = currentLine.trim();
	    //System.out.println(trimmedLine);
	    
	    if(trimmedLine.equals(lineToRemove)) {
	    	//System.out.println("D5l ");
	    	continue;
	    }
	    writer.write(currentLine + System.getProperty("line.separator"));    
	}
	writer.close(); 
	reader.close();
	inputFile.delete();
	//boolean successful =
	//tempFile.renameTo(inputFile);
	File myObj = new File("myTempFile.txt");
    Scanner myReader = new Scanner(myObj);
    Path path1 = FileSystems.getDefault().getPath(user+".txt");
   	File userfile1 = new File(path1.toString());
    File myObj1 = new File(user+".txt");
    FileWriter fw=new FileWriter(myObj1);
    PrintWriter pw=new PrintWriter(fw);
	while(myReader.hasNextLine()) {
		
		String data = myReader.nextLine();
		pw.println(data);
	
	}
	
	myReader.close();
    pw.close();
    myObj.delete();
    
	addPlayerinSquad(newplayer.getname());
	System.out.println("change is succesefull");		
	}
	
	  public void changeScoreSquad(String actualScore,String score) throws IOException
	{
		  File inputFile = new File(user+".txt");
		    Path path = FileSystems.getDefault().getPath("myTempFile.txt");
			File userfile = new File(path.toString());
			File tempFile = new File("myTempFile.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String lineToRemove =actualScore; 
			String currentLine;
			//System.out.println(lineToRemove);
			while((currentLine = reader.readLine()) != null) {
			    String trimmedLine = currentLine.trim();
			    //System.out.println(trimmedLine);
			    
			    if(trimmedLine.equals(lineToRemove)) {
			    	//System.out.println("D5l ");
			    	continue;
			    }
			    writer.write(currentLine + System.getProperty("line.separator"));    
			}
			writer.close(); 
			reader.close();
			inputFile.delete();
			//boolean successful =
			//tempFile.renameTo(inputFile);
			File myObj = new File("myTempFile.txt");
		    Scanner myReader = new Scanner(myObj);
		    Path path1 = FileSystems.getDefault().getPath(user+".txt");
		    File userfile1 = new File(path1.toString());
		    File myObj1 = new File(user+".txt");
		    FileWriter fw=new FileWriter(myObj1);
		    PrintWriter pw=new PrintWriter(fw);
			while(myReader.hasNextLine()) {
				
				String data = myReader.nextLine();
				pw.println(data);
			
			}
			
			myReader.close();
		    pw.close();
		    myObj.delete();
		    
			addScore(score);
			System.out.println("change is succesefull");
	}
}