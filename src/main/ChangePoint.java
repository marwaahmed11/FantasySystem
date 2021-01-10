
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
import java.util.Scanner;
public class ChangePoint implements Observer{
  
	Event event;
	public ChangePoint()
	{
		
	}
	public ChangePoint(Event event)
	{
		this.event=event;
	}
public void readFileEvents() throws FileNotFoundException	
{
	
	File myObj = new File("event.txt");
	Scanner myReader = new Scanner(myObj);
	boolean f=false;
	int i=1;
	while(myReader.hasNextLine()) {
		
		String data = myReader.nextLine();
		System.out.println(i+")"+data);
		i++;
		
	}
	myReader.close();
}
public int getScore(int i) throws IOException 	
{
	        MakeEventInWeek m= new MakeEventInWeek();
            int EventScore=0;  
			String[]  x= m.Eventline(i).split(",");
			String e=x[2];
			String[]  y=e.split(":");
			String w=y[y.length-1];
			EventScore=Integer.parseInt(w);
		    return EventScore;
} 

public void reflectChange(String name,int point) throws IOException
{
	
	    //////cd userSquad
	    int k=1;
	    String pwd=System.getProperty("user.dir");
		File dir = new File(pwd);
		  File[] directoryListing = dir.listFiles();
		
		  if (directoryListing.length != 0) {
		    for (File child : directoryListing) {
		    	/////////IF The player excit in this squad
		    	
		    	File myObj1 = new File(child.getName());
		    	Scanner myReader1 = new Scanner(myObj1);
		   
		    	while(myReader1.hasNextLine()) {
		    		
		    		String data = myReader1.nextLine();
		    		
		    		String[]  x= data.split(" ");
					String z=x[0];
					String[]  y=z.split(":");
					String w=y[y.length-1];
					Squad s=new Squad(name);
					if(w.equals(name))
					{
						File inputFile = new File("players.txt");
			      	    Path path = FileSystems.getDefault().getPath("myTempFile.txt");
			      		File userfile = new File(path.toString());
			      		File tempFile = new File("myTempFile.txt");
			      		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			      		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			      		infoPlayer inf;
			      		Player p=new Player();
			        	 inf=p.foundPlayer(name);
			        	 String lineToRemove = "Name:"+inf.getname()+" "+"Position:"+inf.getposition()+" "+"Nationality:"+inf.getnationality()+" "+"Club:"+inf.getclub()+" "+"Value:"+inf.getvalue()+"Point:"+inf.getpoint();
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
			     	    Path path1 = FileSystems.getDefault().getPath("players.txt");
			     	   	File userfile1 = new File(path1.toString());
			     	    File myObj3 = new File("players.txt");
			     	    FileWriter fw=new FileWriter(myObj3);
			     	    PrintWriter pw=new PrintWriter(fw);
			     		while(myReader.hasNextLine()) {
			     			
			     			String data1 = myReader.nextLine();
			     			pw.println(data1);
			     		
			     		}
			     		
			     		myReader.close();
			     	    pw.close();
			     	    myObj.delete();
			     	   int actualScore=Integer.parseInt(inf.getpoint());
						int sum=actualScore+point;
						String m="";
						
			     	    infoPlayer newplayer=new infoPlayer(inf.getname(),inf.getnationality(),inf.getposition(),inf.getclub(),inf.getvalue(),m.valueOf(sum));
			     	   try {
						p.Addplayer(newplayer);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			     		System.out.println("change is succesefull");
			         }
				    	}
				    	myReader1.close();
					}
		    	
		    	}
		    	
		    }
		  
		


@Override
public void update(String[] name, int[] point) throws IOException {
    for(int i=0;i<name.length;i++)
    {
	reflectChange( name[i], point[i]);
    }
}
}  

