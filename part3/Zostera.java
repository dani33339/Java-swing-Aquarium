package part3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

/**
 * class Zostera:
 * class of the Zostera (tyoe of plant)
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class Zostera extends Immobile{

    private int size;
    private int x;
    private int y;
    private Color color;

    public Zostera(int size,int x,int y){
        super("Zostera");
        this.color = Color.green; 
        this.size = size;
        this.x = x;
        this.y = y;
    }

    
     /**
     * this method draw the animal
     * 
     * @param g
     */
    public void drawCreature(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(color);
        g.drawLine(x, y, x, y - size);
        g.drawLine(x-2, y, x-10, y-size*9/10);
        g.drawLine(x+2, y, x+10, y-size*9/10);
        g.drawLine(x-4, y, x-20, y-size*4/5);
        g.drawLine(x+4, y, x+20, y-size*4/5);
        g.drawLine(x-6, y, x-30, y-size*7/10);
        g.drawLine(x+6, y, x+30, y-size*7/10);
        g.drawLine(x-8, y, x-40, y-size*4/7);
        g.drawLine(x+8, y, x+40, y-size*4/7);
        g2.setStroke(new BasicStroke(1));
        
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
