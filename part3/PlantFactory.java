package part3;

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
