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
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	ArrayList<infoPlayer> players;
	boolean checklog=false;
	PrintOnFile print=new PrintOnFile();
	public Player()
	{
		players=new ArrayList<infoPlayer>();
	}
	
	public void Addplayer( infoPlayer inf) throws FileNotFoundException
	{
		File myObj = new File("players.txt");
		Scanner myReader = new Scanner(myObj);
		boolean f=false;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String e=x[0];
			String[]  y=e.split(":");
			String w=y[y.length-1];
			
			
			if(inf.getname().equals(w))
			{
				System.out.println("Error,We have already this player in the system ");
				f=true;
				break;
			}
			
		}
		myReader.close();
		if(f==false)
		{
			players.add(inf);
			try {
				print.printonfile("Name:"+inf.getname()+" "+"Position:"+inf.getposition()+" "+"Nationality:"+inf.getnationality()+" "+"Club:"+inf.getclub()+" "+"value:"+inf.getvalue()+" "+"Point:0"+"\n","players.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public ArrayList<infoPlayer> getplayers()
	{
		return players;
	}
	
	public void printplayer(String n) throws FileNotFoundException//String p
	{
		File myObj = new File("players.txt");
		Scanner myReader = new Scanner(myObj);
		boolean b=false;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String z=x[0];
			String[]  y=z.split(":");
			String name=y[1];
			
			if(name.equals(n))
			{
				System.out.println(data);	
				b=true;
				
				
			}
		}
		myReader.close();
		if(b==false)
			System.out.println("not found");
		
			
	}
	public  infoPlayer foundPlayer(String n) throws FileNotFoundException
	{
		File myObj = new File("players.txt");
		Scanner myReader = new Scanner(myObj);
		boolean b=false;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String z=x[0];
			String[]  y=z.split(":");
			String name=y[1];
			
			
			if(name.equals(n))
			{
				b=true;
				String[]  h= data.split(" ");
				String position=h[1];
				String[]  position1=position.split(":");
				String position2=position1[1];
				String nameofplayer=h[0];
				String[]  nameofplayer1=nameofplayer.split(":");
				String nameofplayer2=nameofplayer1[1];
				String nationality=h[2];
				String[]  nationality1=nationality.split(":");
				String nationality2=nationality1[1];
				String club=h[3];
				String[]  club1=club.split(":");
				String club2=club1[1];
				String value=h[4];
				String[]  value1=value.split(":");
				String value2=value1[1];
				String point=h[5];
				String[]  point1= point.split(":");
				String  point2= point1[1];
				infoPlayer inf=new infoPlayer(nameofplayer2,nationality2,position2,club2,value2,point2);
				return inf;
				
			}
		}
		myReader.close();
		if(b==false)   
			return null;
		return null;
			
	}
	public void printPlayers() throws FileNotFoundException
	{
		
		File myObj = new File("players.txt");
		Scanner myReader = new Scanner(myObj);
		boolean b=false;
		while(myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.println(data);		
		}
		myReader.close();
	}}