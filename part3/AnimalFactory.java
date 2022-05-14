package part3;
import q3.*;

public class AnimalFactory extends Thread implements AbstractSeaFactory{


	private int size;
    private int x;
	private int y;

	public AnimalFactory(int size,int x,int y)
    {
		this.size=size;
		this.x=x;
		this.y=x;
	}

	public SeaCreature produceSeaCreature(String type)
    {
		if(type.equalsIgnoreCase("Laminaria"))
			return new Laminaria(size,x,y);
		
		else if(type.equalsIgnoreCase("Zostera")){
			return new Zostera(size,x,y); 
		}
		return null;

	}  return obj;
    }

}
