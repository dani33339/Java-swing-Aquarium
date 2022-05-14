package part3;

public abstract class Immobile implements SeaCreature {
    protected String name;


    public Immobile(String name){
        this.name = name;
    }
    public abstract int getSize();
    public abstract int getX();
    public abstract int getY();
    public abstract String getColorString();
}
