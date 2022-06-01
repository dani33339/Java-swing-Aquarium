package part3;
import java.util.ArrayList;
import java.util.List;

/**
 * class CareTaker:
 * class CareTaker Memento design pattern ,control's over the saved object's
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class CareTaker {
	private List<Memento> Smemento=new ArrayList<Memento>(); //swimmable list
	private List<Memento> Pmemento= new ArrayList<Memento>(); //plat's list

	
	/** 
	 * add 
	 * @param state Memento
	 */
	public void addSmemento(Memento swimmable)
	{
		Smemento.add(swimmable);
	}
	
	/** 
	 * @param state
	 */
	public void addPmemento(Memento immobile)
	{
		Pmemento.add(immobile);
	}
	
	
	/** 
	 * @param i
	 * @return Memento
	 */
	public Memento getSmementoo(int i){
		return Smemento.get(i);
	}
	
	
	/** 
	 * @param i
	 * @return Memento
	 */
	public Memento getPmemento(int i){
		return Pmemento.get(i);
    }
	

	public List<Memento> getSmemento(){return Smemento;}
	public List<Memento>getPmemento(){return Pmemento;}

}
