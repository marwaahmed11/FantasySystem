package main;
import java.io.*;
import java.util.Scanner;
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
				System.out.println("Applay Event '7'");
				System.out.println("print Events of a Week '8'");
				System.out.println("score of your Squad '9'");
				System.out.println("EXIT press '10'");
						
				Scanner in =new Scanner (System.in) ;
				int k=in.nextInt();
				if(k==1)
				{
					System.out.println("frist time press'1',not'2'");
					Scanner inp =new Scanner (System.in) ;
					int m=inp.nextInt();
					p.printPlayers();
					
					System.out.println("Now you ready to make your squad please enter 2 goolkeeper,5 defender,5 midfieder,3 forward");
					for(int i=0;i<15;i++)
					{
						System.out.println("enter the name of your Player");
						Scanner name =new Scanner (System.in) ;
						String name1=name.nextLine();
						s.addPlayerinSquad(name1);
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
						System.out.println("Squad is added Succesfully and its price is "+s.calculateValue());
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
					System.out.println(" price of squad is "+s.calculateValue());
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
					infoPlayer inf=new infoPlayer(name,nationality,position,club,value,"0");
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
				    String names[] =new String[20] ;
				    int point[] = new int[20];
				    int i=0;
				    ChangePoint cs=new ChangePoint();
					cs.readFileEvents();
					Event ev=new Event();
					ChangePoint ch =new ChangePoint(ev);
					ev.registerObserver(ch);
					while(true) {
						
					System.out.println("enter the number of your Event ");
					Scanner number =new Scanner (System.in) ;
					int num=number.nextInt();
					System.out.println("which week ");
					Scanner week=new Scanner (System.in) ;
					String wk=week.nextLine();
					MakeEventInWeek event= new MakeEventInWeek();
					int o=cs.getScore(num);
					System.out.println("Which player ");
					Scanner p1 =new Scanner (System.in) ;
					String name=p1.nextLine();
					event.EventOfWeek(wk, num,name);
					names[i]=name;
					point[i]=o;
					i++;
					System.out.println("if you want to continue press 1 if exit perss 2");
					Scanner choice =new Scanner (System.in) ;
					int choice1=choice.nextInt();
					if(choice1==2)
					{
						ev.SetPoints(names, point);
						break;
					}
					}	
				}
				else if (k==8)///print event of week
				{
					MakeEventInWeek event= new MakeEventInWeek();	
					System.out.println("which week ");
					Scanner week=new Scanner (System.in) ;
					String wk=week.nextLine();
					event.PrintEventOfWeek(wk);
				}
				else if (k==9)///print event of week
				{
					Squad s4=new Squad(b);
					System.out.println("your squad Score:"+s4.calculateScore());
					
				}
				else if (k==10)
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