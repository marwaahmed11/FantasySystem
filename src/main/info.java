package main;
public class info {
	String name;
	String email;
	String password;
	String favorite_team;
	public info (String name,String email,String password,String favorite_team)
	{
		 this.name=name;
		this.email=email;
		this.password=password;
		this.favorite_team=favorite_team;
	}
	public  void setname(String n)
	{
		 name=n;
	}
	public  void setfavorite_team(String favorite_team)
	{
		this.favorite_team=favorite_team;
	}
	public  void setemail(String e)
	{
		 email=e;
	}
	public  void setpassword(String p)
	{
		 password=p;
	}
	public String getname()
	{
		return name;
	}
	public String getemail()
	{
		return email;
	}
	public String getpassword()
	{
		return password;
	}
	public String getfavorite_team()
	{
		return favorite_team;
	}
}