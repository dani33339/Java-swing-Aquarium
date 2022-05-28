package part3;
import java.awt.Color;
import java.awt.Graphics;

/**
 * class Laminaria:
 * class of the Laminaria (tyoe of plant)
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class Laminaria extends Immobile{
    private int size;
    private int x;
    private int y;
    private Color color = Color.green;

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

     /**
     * this method draw the animal
     * 
     * @param g
     */
    public void drawCreature(Graphics g) {
		g.setColor(color);
		g.fillArc(x-size/20, y-size, size/10, size*4/5,0, 360);
		g.fillArc(x-size*3/20, y-size*13/15, size/10, size*2/3,0, 360);
		g.fillArc(x+size/20,y-size*13/15,size/10, size*2/3, 0, 360);
		g.drawLine(x, y, x, y-size/5);
		g.drawLine(x,y,x-size/10,y-size/5);
		g.drawLine(x, y, x+size/10, y-size/5);
        
    }
    
    /** 
     * retun's the size of the plant
     * @return int
     */
    public int getSize() {
        return this.size;
    }

    
    /** 
     * return the x cordinate
     * @return int
     */
    public int getX() {
        return this.x;
    }

    /** 
     * return the y cordinate
     * @return int
     */
    public int getY() {
        return this.y;
    }

    
    /** 
     * return's the string of the color
     * @return String
     */
    public String getColorString() {
        return "green";
    }

    
    /** 
     * return the color
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    
    /** 
     * return's the id of the plant
     * @param idnumber
     */
    public void setid(String idnumber) {
        this.id=this.id+idnumber;
      };

      
      /** 
       * save's the state of the plant
       * @param color
       * @param size
       * @param x
       * @param y
       */
      public void saveState(Color color,int size,int x,int y)
      {
          this.color=color;
          this.size=size;
          this.x=x;
          this.y=y;
      } 
}
