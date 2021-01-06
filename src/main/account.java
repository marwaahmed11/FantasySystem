package main;
import java.util.ArrayList;

public class account {
    ArrayList<info> acount;
	boolean checklog=false;
	public account()
	{
		acount=new ArrayList<info>();
		
	}
	public void register(String name,String email,String password,String favorite_team)
	{
		info inf=new info(name,email,password, favorite_team);
		
		acount.add(inf);
	}
	public ArrayList<info> getacounts()
	{
		return acount;
	}
	public boolean checkLogin(String e,String p)
	{
		
		for(int i=0;i<acount.size();i++)
		{ 
			
			info inf=(info)acount.get(i);
			
			if(inf.getemail().equals(e)&&inf.getpassword().equals(p))
			{
				checklog=true;
				return true;
			}
		}
		       return false;
	}
	public void printacount(String p)//String p
	{
		for(int i=0;i<acount.size();i++)
		{
			info inf=(info)acount.get(i);
			if(inf.getpassword().equals(p))
			{
				System.out.print("Name: "+inf.getname()+" "+"password: "+inf.getpassword()+" "+"email: "+inf.getemail()+" " +"favorite_team: "+inf.getfavorite_team());
			}
		}
		
	}
	public void print()
	{
		for(int i=0;i<acount.size();i++)
		{
			info inf=(info)acount.get(i);
			System.out.print("Name: "+inf.getname()+" "+"password: "+inf.getpassword()+" "+"email: "+inf.getemail()+" " +"favorite_team: "+inf.getfavorite_team());
		
		}
		
	}
}