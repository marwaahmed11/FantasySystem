
package main;

public class infoPlayer {
	    String name;
	    String nationality;
	    String position;
	    String club;
	    String value;
	    
	    public infoPlayer(String name,String nationality,String position,String club,String value)
	    {
	        this.name=name;
	        this.nationality=nationality;
	        this.position=position;
	        this.club=club;
	        this.value=value;
	    }
	    public void setname (String name)
	    {
	        this.name=name;
	    }
	    public void setvalue (String value)
	    {
	        this.value=value;
	    }
	    public void setnationality (String nationality)
	    {
	        this.nationality=nationality;
	    }
	    public void setposition (String position)
	    {
	        this.position=position;
	    }
	    public void setclub (String club)
	    {
	        this.club=club;
	    }
	    public String getname ()
	    {
	        return name;
	    }
	    public String getnationality ()
	    {
	        return nationality;
	    }
	    public String getposition ()
	    {
	        return position;
	    }
	    public String getclub ()
	    {
	        return club;
	    }
	    public String getvalue ()
	    {
	        return value;
	    }
}