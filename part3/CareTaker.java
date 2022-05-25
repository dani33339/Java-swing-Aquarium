package part3;
import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	private List<Memento> Smemento=new ArrayList<Memento>();
	private List<Memento> Pmemento= new ArrayList<Memento>();; 

	public void addSmemento(Memento state)
	{
		Smemento.add(state);

	}
	public void addPmemento(Memento state)
	{
		Pmemento.add(state);
	}
	
	public Memento getSmementoo(int i){
		return Smemento.get(i);
	}
	
	public Memento getPmemento(int i){
		return Pmemento.get(i);
    }

	public List<Memento> getSmemento(){return Smemento;}
	public List<Memento>getPmemento(){return Pmemento;}

}
