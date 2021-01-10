
package main;
import java.io.IOException;
import java.util.ArrayList;
public class Event implements Subject{
private ArrayList observers;
private String name [];
private int point[];
     public Event()
     {
    	 observers=new ArrayList();
     }
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i=observers.indexOf(o);
		if(i>0)
		{
			observers.remove(i);
		}	
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++)
		{
			Observer observer =(Observer)observers.get(i);
			try {
				observer.update(name, point);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    public void ScoreChanged() {
    	notifyObservers();
    }
    public void SetPoints(String name [],int point[])
    {
    	this.name=name;
    	this.point=point;
    	ScoreChanged();
    }
}