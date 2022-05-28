package part3;
import q3.*;
import q3.Swimmable.Callback;
import java.awt.*;
import part2.*;

/**
 * class AnimalFactory:
 * class AnimalFactory design pattern Factory for animal's
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class AnimalFactory implements AbstractSeaFactory{

    protected int horSpeed;
    protected int verSpeed;
    protected int size;
    protected Color col;
    protected int x_front;
    protected int y_front;
    protected final AquaPanel callback;
    protected int foodFreq;


	public AnimalFactory(int size, int x_front, int y_front, int horSpeed, int verSpeed, Color col,AquaPanel callback,int foodFreq)
    {
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
        this.foodFreq=foodFreq;
        this.size = size;
        this.col = col;
        this.x_front = x_front;
        this.y_front = y_front;
        this.callback = callback;

	}

	
    /** 
    * return's a new object with the given type(Laminaria or Zostera)
     * @param type
     * @return SeaCreature
     */
    public SeaCreature produceSeaCreature(String type)
    {
		if(type.equalsIgnoreCase("Fish"))
			return new Fish(size,x_front,y_front,horSpeed,verSpeed,col,callback,foodFreq);
		
		else if(type.equalsIgnoreCase("Jellyfish")){
			return new Jellyfish(size,x_front,y_front,horSpeed,verSpeed,col,callback,foodFreq); 
		}
		return null;

	}  
}
