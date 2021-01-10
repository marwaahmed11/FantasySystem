
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Squad implements PrintOnFile{
	ArrayList<infoPlayer> squads;
	String user;
	public Squad(String user)
	{
		this.user=user;
	     squads=new ArrayList<infoPlayer>();
	}
	
	public void printonfile(String data) throws IOException
	{
		String str = data;
		Path path =Paths.get( "C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\"+user+".txt");
        if (!Files.exists(path))
        {
            Files.createFile(path);
           // System.out.print("created successfully");
            
        }
	    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\"+user+".txt", true));
	   // writer.append(' ');
	    writer.append(str);
	    writer.close();
	}
	
	public void addSquad(infoPlayer inf)
	{ 
		
		squads.add(inf);
		try {
			printonfile("Name:"+inf.getname()+" "+"Position:"+inf.getposition()+" "+"Nationality:"+inf.getnationality()+" "+"Club:"+inf.getclub()+" "+"Value:"+inf.getvalue()+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	 
	}
	public int checkGoalKeeper(String name) throws FileNotFoundException
	{
		
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\players.txt");
		Scanner myReader = new Scanner(myObj);
		String copydata = null;
		boolean f=false;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String z=x[0];
			String[]  y=z.split(":");
			String w=y[y.length-1];
			
			if(w.equals(name))
			{
				copydata=data;
				f=true;
				break;
			}
			
		}
		myReader.close();
		if(f==false)
		{
			//System.out.print("sorry, this name is not found");
			return 3;
			
		}
		else {	
			String[]  h= copydata.split(" ");
			String position=h[1];
			String[]  position1=position.split(":");
			String position2=position1[1];
			
		if(position2.equals("Goalkeeper"))
		{
			Player p=new Player();
			addSquad(p.foundPlayer(name));
			return 1;
		}
		else
			return 2;
		}
	}
	public int checkdefender(String name) throws FileNotFoundException
	{
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\players.txt");
		Scanner myReader = new Scanner(myObj);
		String copydata = null;
		boolean f=false;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String z=x[0];
			String[]  y=z.split(":");
			String w=y[y.length-1];
			if(w.equals(name))
			{
				copydata=data;
				f=true;
				break;
			}
			
		}
		myReader.close();
		if(f==false)
		{
			//System.out.print("sorry, this name is not found");
			return 3;
			
		}
		else {	
			String[]  h= copydata.split(" ");
			String position=h[1];
			String[]  position1=position.split(":");
			String position2=position1[1];
			
		if(position2.equals("Defender"))
		{
			Player p=new Player();
			addSquad(p.foundPlayer(name));
			return 1;
		}
		else
			return 2;
		}
	}
	public int checkmidfielder(String name) throws FileNotFoundException
	{
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\players.txt");
		Scanner myReader = new Scanner(myObj);
		String copydata = null;
		boolean f=false;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String z=x[0];
			String[]  y=z.split(":");
			String w=y[y.length-1];
			if(w.equals(name))
			{
				copydata=data;
				f=true;
				break;
			}
			
		}
		myReader.close();
		if(f==false)
		{
			//System.out.print("sorry, this name is not found");
			return 3;
			
		}
		else {	
			String[]  h= copydata.split(" ");
			String position=h[1];
			String[]  position1=position.split(":");
			String position2=position1[1];
		if(position2.equals("Midfielder"))
		{
			Player p=new Player();
			addSquad(p.foundPlayer(name));
			return 1;
		}
		else
			return 2;
		}
	}
	public int checkforward(String name) throws FileNotFoundException
	{
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\players.txt");
		Scanner myReader = new Scanner(myObj);
		String copydata = null;
		boolean f=false;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String z=x[0];
			String[]  y=z.split(":");
			String w=y[y.length-1];
			if(w.equals(name))
			{
				copydata=data;
				f=true;
				break;
			}
			
		}
		myReader.close();
		if(f==false)
		{
			//System.out.print("sorry, this name is not found");
			return 3;
			
		}
		else {	
			String[]  h= copydata.split(" ");
			String position=h[1];
			String[]  position1=position.split(":");
			String position2=position1[1];
		if(position2.equals("Forward"))
		{
			Player p=new Player();
			addSquad(p.foundPlayer(name));
			return 1;
		}
		else
			return 2;
		}
	}
	public int calculate() throws FileNotFoundException
	{
		int sum=0;
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\"+user+".txt");
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
	public boolean calculatefirstime() throws FileNotFoundException
	{
		int sum=0;
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\"+user+".txt");
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
	File inputFile = new File("C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\"+user+".txt");
	Path path =Paths.get( "C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\myTempFile.txt");
    if (!Files.exists(path))
     Files.createFile(path);
    
	File tempFile = new File("C:\\Users\\Fatma\\Desktop\\Design\\\\UsersSquad\\myTempFile.txt");

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
	File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\myTempFile.txt");
    Scanner myReader = new Scanner(myObj);
    Path path1 =Paths.get( "C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\"+user+".txt");
    if (!Files.exists(path1))
     Files.createFile(path1);
    File myObj1 = new File("C:\\Users\\Fatma\\Desktop\\Design\\UsersSquad\\"+user+".txt");
    FileWriter fw=new FileWriter(myObj1);
    PrintWriter pw=new PrintWriter(fw);
	while(myReader.hasNextLine()) {
		
		String data = myReader.nextLine();
		pw.println(data);
	
	}
	
	myReader.close();
    pw.close();
    myObj.delete();
	addSquad(newplayer);
	System.out.println("change is succesefull");		
	}
	
}