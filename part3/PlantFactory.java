package part3;

/**
 * class PlantFactory:
 * class PlantFactory design pattern Factory for plant's
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class PlantFactory implements AbstractSeaFactory{

	private int size;
    private int x;
	private int y;

	public PlantFactory(int size,int x,int y)
    {
		this.size=size;
		this.x=x;
		this.y=x;
	}

	
	/** 
	 * return's a new object with the given type(Laminaria or Zostera)
	 * @param type
	 * @return SeaCreature
	 */
	public SeaCreature produceSeaCreature(String type)
    {
		if(type.equalsIgnoreCase("Laminaria"))
			return new Laminaria(size,x,y);
		
		else if(type.equalsIgnoreCase("Zostera")){
			return new Zostera(size,x,y); 
		}
		return null;
	}
}
