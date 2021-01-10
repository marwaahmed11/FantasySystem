package main;
import java.io.*;
import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		account a=new account();
		
		while(true) {
			
		
		System.out.println("if you want to sign up press '1' ,sign in press'2',print the information of an specific account press'3',print the information of all accounts press'4',exist press'5'");
		Scanner input =new Scanner (System.in) ;
		int l=input.nextInt();
		
		if (l==1)
		{
			System.out.println("enter your name");
			Scanner y =new Scanner (System.in) ;
			String x=y.nextLine();
			System.out.println("enter your email");
			Scanner w =new Scanner (System.in) ;
			String z=w.nextLine();
			System.out.println("enter your password");
			Scanner q =new Scanner (System.in) ;
			String v=q.nextLine();
			System.out.println("enter your favorite team");
			Scanner k =new Scanner (System.in) ;
			String m=k.nextLine();
			info inf=new info(x,z,v,m);
			a.register(inf);
		}
		else if(l==2)
		{
			System.out.println("enter your email");
			Scanner w =new Scanner (System.in) ;
			String z=w.nextLine();
			System.out.println("enter your name");
			Scanner c =new Scanner (System.in) ;
			String b=c.nextLine();
			System.out.println("enter your password");
			Scanner q =new Scanner (System.in) ;
			String v=q.nextLine();
			if(a.checkLogin(z,v)) {
				System.out.println("login successfully");
				while (true) {
					Squad s=new Squad(b);
					Player p=new Player();
				System.out.println("add player to squad press'1'");
				System.out.println("change squad press'2'");
				System.out.println("culculate price of squad press '3'");
				System.out.println("add player in the system press '4'");
				System.out.println("print information of one player '5'");
				System.out.println("print information of all player '6'");
				System.out.println("EXIT press '7'");
						
				Scanner in =new Scanner (System.in) ;
				int k=in.nextInt();
				if(k==1)
				{
					System.out.println("frist time press'1',not'2'");
					Scanner inp =new Scanner (System.in) ;
					int m=inp.nextInt();
					p.printPlayers();
					for(int i=0;i<2;i++)
					{
						System.out.println("enter the name of your goal keeper");
						Scanner p1 =new Scanner (System.in) ;
						String s1=p1.nextLine();
						int j=s.checkGoalKeeper(s1);
						if(j==1)//GoalKeeper
						{
							System.out.println("this goal keeper is added succesufully");
						}
						if(j==2)//NOT GoalKeeper
						{
							System.out.println("this player is not  goal keeper try again");
							i--;
						}
						if(j==3)//NOT PLAYER ON THE SYSTEM GoalKeeper
						{
							System.out.println("sorry, this player is not found try again");
							i--;
						}
					}
					for(int i=0;i<5;i++)
					{
						System.out.println("enter the name of your defender");
						Scanner p1 =new Scanner (System.in) ;
						String s1=p1.nextLine();
						int j=s.checkdefender(s1);
						if(j==1)//GoalKeeper
						{
							System.out.println("this goal keeper is added succesufully");
						}
						if(j==2)//NOT GoalKeeper
						{
							System.out.println("this player is not  goal keeper try again");
							i--;
						}
						if(j==3)//NOT PLAYER ON THE SYSTEM GoalKeeper
						{
							System.out.print("sorry, this player is not found try again");
							i--;
						}
					}
					for(int i=0;i<5;i++)
					{
						System.out.println("enter the name of your midfielder");
						Scanner p1 =new Scanner (System.in) ;
						String s1=p1.nextLine();
						int j=s.checkmidfielder(s1);
						if(j==1)//GoalKeeper
						{
							System.out.println("this goal keeper is added succesufully");
						}
						if(j==2)//NOT GoalKeeper
						{
							System.out.println("this player is not  goal keeper try again");
							i--;
						}
						if(j==3)//NOT PLAYER ON THE SYSTEM GoalKeeper
						{
							System.out.print("sorry, this player is not found try again");
							i--;
						}
					}
					for(int i=0;i<3;i++)
					{
						System.out.println("enter the name of your forward");
						Scanner p1 =new Scanner (System.in) ;
						String s1=p1.nextLine();
						int j=s.checkforward(s1);
						if(j==1)//GoalKeeper
						{
							System.out.println("this goal keeper is added succesufully");
						}
						if(j==2)//NOT GoalKeeper
						{
							System.out.println("this player is not  goal keeper try again");
							i--;
						}
						if(j==3)//NOT PLAYER ON THE SYSTEM GoalKeeper
						{
							System.out.print("sorry, this player is not found try again");
							i--;
						}
					}
					if(m==1)
					{
						//s.addScore("0");
						if(s.calculatefirstime())
							System.out.println("Squad is added Succesfully");
						else
							System.out.println("Squad is out of budget");
					}
					else 
						System.out.println("Squad is added Succesfully and its price is "+s.calculate());
				}
				else if (k==2)
				{
					System.out.println("enter the name of OLD player");
					Scanner p3 =new Scanner (System.in) ;
					String s3=p3.nextLine();
					System.out.println("enter the name of new player");
					Scanner p4 =new Scanner (System.in) ;
					String s4=p4.nextLine();
					infoPlayer oldplayer=p.foundPlayer(s3);
					infoPlayer newplayer=p.foundPlayer(s4);
					
					if(oldplayer!=null&&newplayer!=null)
					    s.changeSquad(oldplayer, newplayer);
				}
				else if (k==3)
				{
					System.out.println(" price of squad is "+s.calculate());
				}
				else if (k==4)
				{
					System.out.println("enter the name ");
					Scanner p1 =new Scanner (System.in) ;
					String name=p1.nextLine();
					System.out.println("enter the nationality ");
					Scanner p2 =new Scanner (System.in) ;
					String nationality=p2.nextLine();
					System.out.println("enter the position ");
					Scanner p3 =new Scanner (System.in) ;
					String position=p3.nextLine();
					System.out.println("enter the club ");
					Scanner p4 =new Scanner (System.in) ;
					String club =p4.nextLine();
					System.out.println("enter the price ");
					Scanner p5 =new Scanner (System.in) ;
					String value =p5.nextLine();
					infoPlayer inf=new infoPlayer(name,nationality,position,club,value);
					p.Addplayer(inf);
				}
				else if (k==5)
				{
					System.out.println("enter the name ");
					Scanner p1 =new Scanner (System.in) ;
					String name=p1.nextLine();
					p.printplayer(name);
				}
				else if (k==6)
				{
					
					p.printPlayers();
				}
				
				else if (k==7)
				{
					break;
				}
			}
			}	
			
			else
				System.out.println("Error");
			
		}
		else if(l==3)
		{
			System.out.println("enter your password");
			Scanner q =new Scanner (System.in) ;
			String p=q.nextLine();
			try {
				a.printacount(p);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(l==4)
		{
			
			try {
				a.print();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(l==5)
		{
			
			break;
		}
		
		}
	}

}