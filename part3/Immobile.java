package part3;
import java.awt.Color;


public abstract class Immobile implements SeaCreature {
    protected String name;
    protected String id=this.getClass().getSimpleName();


    public Immobile(String name){
        this.name = name;
    }
    public abstract int getSize();
    public abstract int getX();
    public abstract int getY();
    public abstract String getColorString();
    public abstract void setid(String id) ;
    public abstract Color getColor();
	public abstract void setState(Color color,int size,int x,int y);
    public String getId(){return id;};
    public String getName(){return name;};


}
