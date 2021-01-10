package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class account implements PrintOnFile{
	ArrayList<info> acount;
	boolean checklog=false;
	public account()
	{
	    acount=new ArrayList<info>();
	}
	public void printonfile(String data) throws IOException
	{
		String str = data;
	    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Fatma\\Desktop\\Design\\users.txt", true));
	  //  writer.append(' ');
	    writer.append(str);
	    writer.close();
	}
	public void register(info inf) throws FileNotFoundException
	{
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\users.txt");
		Scanner myReader = new Scanner(myObj);
		boolean f=false;
		
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			
			String[]  x= data.split(" ");
			String e=x[2];
			String[]  y=e.split(":");
			String w=y[y.length-1];
			
			
			if(inf.getemail().equals(w))
			{
				System.out.println("Error,please enter another email ");
				f=true;
				break;
			}
			
		}
		myReader.close();
		if(f==false)
		{
			acount.add(inf);
			try {
				//String data=;
				printonfile("Name:"+inf.getname()+" "+"Password:"+inf.getpassword()+" "+"email:"+inf.getemail()+" "+"favorite_team:"+inf.getfavorite_team()+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	public ArrayList<info> getacounts()
	{
		return acount;
	}
	public boolean checkLogin(String e,String p) throws FileNotFoundException
	{
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\users.txt");
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			String pass=x[1];
			String[]  y=pass.split(":");
			String w=y[1];
			String mail=x[2];
			String[]  K=mail.split(":");
			String M=K[K.length-1];
			if(M.equals(e)&&w.equals(p))
			{
				return true;
				
			}
		}
		myReader.close();
		return false;	
	}
	public void printacount(String e) throws FileNotFoundException//String p
	{
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\users.txt");
		Scanner myReader = new Scanner(myObj);
		boolean b=false;
		while(myReader.hasNextLine()) {
			
			String data = myReader.nextLine();
			
			String[]  x= data.split(" ");
			//String pass=x[1];
			String mail=x[2];
			
			if(mail.equals(e))
			{
				System.out.print(data);	
				b=true;
			}
		}
		myReader.close();
		if(b==false)
			System.out.print("not found");
			
	}
	public void print() throws FileNotFoundException
	{
		
		File myObj = new File("C:\\Users\\Fatma\\Desktop\\Design\\users.txt");
		Scanner myReader = new Scanner(myObj);
		boolean b=false;
		while(myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.print(data);		
		}
		myReader.close();
	}
}