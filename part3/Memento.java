package part3;
import java.awt.Color;
import q3.Swimmable;

/**
 * class Memento:
 * class Memento design pattern
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class Memento {
	private int size,x_front,y_front,horSpeed,verSpeed,eatCount, x_dir,y_dir,foodFrequency;
	private Color col;
    private String colorstring;
	private String id,creatureType;
	private Swimmable s;
	private Immobile i;
	public Memento(Swimmable s)
	{	
		this.s=s;
        this.creatureType=s.getAnimalName();
		this.id=s.getId();
		this.col=s.getcol();
		this.size=s.getSize();
        this.x_dir=s.getx_dir();
		this.y_dir=s.gety_dir();
		this.x_front=s.getx_front();
		this.y_front=s.gety_front();
		this.horSpeed=s.gethorSpeed();
		this.verSpeed=s.getverSpeed();
        this.colorstring=s.getColor();
        this.eatCount=s.getEatCount();
        this.foodFrequency=s.getfoodFrequency();

	}
	public Memento(Immobile i){
		this.i=i;
		this.id=i.getId();
		this.col=i.getColor();
		this.size=i.getSize();
		this.x_front=i.getX();
		this.y_front=i.getY();
		this.creatureType=i.getName();
        this.colorstring=i.getColorString();
	}

	public Swimmable getSwimmable(){
		return s;
	 }	

	 public Immobile getImmobile(){
		return i;
	 }	

    public Color getCol(){return col;}
    public String getColor(){return colorstring;}
	public String getId(){return id;}
	public int getSize(){return size;}
	public int getXfront(){return x_front;}
	public int getYfront(){return y_front;}
	public int getHorSpeed(){return horSpeed;}
	public int getVerSpeed(){return verSpeed;}
	public String getAnimalName(){return creatureType;}
	public int getX_dir(){return x_dir;}
	public int getY_dir(){return y_dir;}
    public int geteatCount(){return eatCount;}
    public int getfoodFrequency(){return foodFrequency;}

}

