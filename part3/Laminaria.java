package part3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;


public class Laminaria extends Immobile{
    private int size;
    private int x;
    private int y;
    private Color colorr;

    public Laminaria(int size,int x,int y){
        //default Ctor
        super("Laminaria");
        this.colorr = Color.green; //#197546 Color Hex
        this.size = size;
        this.x = x;
        this.y = y;
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
        // TODO Auto-generated method stub
        
    }

    public void getMemento() {
        // TODO Auto-generated method stub
        
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
