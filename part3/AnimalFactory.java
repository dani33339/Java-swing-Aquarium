package part3;

import q3.*;
import q3.Swimmable.Callback;

public class AnimalFactory implements AbstractSeaFactory{

    protected int horSpeed;
    protected int verSpeed;
    private int size;
    private int col;
    private int x_front;
    private int y_front;
    protected final Callback callback;


	public AnimalFactory(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col,Callback callback)
    {
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
        this.size = size;
        this.col = col;
        this.x_front = x_front;
        this.y_front = y_front;
        this.callback = callback;

	}

	public SeaCreature produceSeaCreature(String type)
    {
		if(type.equalsIgnoreCase("Fish"))
			return new Fish(size,x_front,y_front,horSpeed,verSpeed,col,callback);
		
		else if(type.equalsIgnoreCase("Jellyfish")){
			return new Jellyfish(size,x_front,y_front,horSpeed,verSpeed,col,callback); 
		}
		return null;

	}  
}
