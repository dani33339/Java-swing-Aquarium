package part3;
import java.awt.Color;
import java.awt.Graphics;


public class Laminaria extends Immobile{
    private int size;
    private int x;
    private int y;
    private Color colorr = Color.green;

    public Laminaria(int size,int x,int y){
        //default Ctor
        super("Laminaria");
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public Laminaria(Laminaria other) {
        super(other.name);
        this.size = other.getSize();
        this.x = other.getX();
        this.y = other.getY();
      }

    public void drawCreature(Graphics g) {
		g.setColor(colorr);
		g.fillArc(x-size/20, y-size, size/10, size*4/5,0, 360);
		g.fillArc(x-size*3/20, y-size*13/15, size/10, size*2/3,0, 360);
		g.fillArc(x+size/20,y-size*13/15,size/10, size*2/3, 0, 360);
		g.drawLine(x, y, x, y-size/5);
		g.drawLine(x,y,x-size/10,y-size/5);
		g.drawLine(x, y, x+size/10, y-size/5);
        
    }

    public void setMemento() {
        
    }

    public void getMemento() {
        
    }

    public int getSize() {
        return this.size;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getColorString() {
        return "green";
    }
    
}
