package main;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
               account a=new account();
		while(true) {
			
		
		System.out.print("if you want to sign up press '1' ,sign in press'2',print the information of an specific account press'3',print the information of all accounts press'4',exist press'5'");
		Scanner input =new Scanner (System.in) ;
		int l=input.nextInt();
		
		if (l==1)
		{
			System.out.print("enter your name");
			Scanner y =new Scanner (System.in) ;
			String x=y.nextLine();
			System.out.print("enter your email");
			Scanner w =new Scanner (System.in) ;
			String z=w.nextLine();
			System.out.print("enter your password");
			Scanner q =new Scanner (System.in) ;
			String v=q.nextLine();
			System.out.print("enter your favorite team");
			Scanner k =new Scanner (System.in) ;
			String m=k.nextLine();
			a.register(x,z,v,m);
		}
		else if(l==2)
		{
			System.out.print("enter your email");
			Scanner w =new Scanner (System.in) ;
			String z=w.nextLine();
			System.out.print("enter your password");
			Scanner q =new Scanner (System.in) ;
			String v=q.nextLine();
			if(a.checkLogin(z,v))
                        {
			 System.out.print("login successfully");	
			}
			else
				System.out.print("Error");
			
		}
		else if(l==3)
		{
			System.out.print("enter your password");
			Scanner q =new Scanner (System.in) ;
			String p=q.nextLine();
			a.printacount(p);
		}
		else if(l==4)
		{
			
			a.print();
		}
		else if(l==5)
		{
			
			break;
		}
		}
	}
    }
    