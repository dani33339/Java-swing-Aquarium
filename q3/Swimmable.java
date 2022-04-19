package q3;

import java.awt.Graphics;
import java.util.concurrent.CyclicBarrier;
/**
 * class  Swimmable:
 * this calss is the bais of the all calsses we have is q3
 *
 * @author Daniel Markov ,Anton Volkov 
 */
public abstract class Swimmable implements Runnable {
    private int horSpeed;
    private int verSpeed;
    private boolean shutdown = false;
    private CyclicBarrier Foodrace=null;
    private int center_x;
    private int center_y;


    /**
	* this method is a default constructor method to build a new Swimmable .
	*/
    public Swimmable()
    {
        this.horSpeed=0;
        this.verSpeed=0;
    }

    /**
	* this method is a  constructor method to build a new Swimmable .
    * @param horSpeed 
    * @param verSpeed
	*/
    public Swimmable(int horSpeed,int verSpeed)
    {
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
    }
    
    /** 
     * set the horozantal speed
     * @param horSpeed
     */
    public void sethorSpeed(int horSpeed)
    {
        this.horSpeed = horSpeed;
    }

    
    /** 
     * set the vertical speed
     * @param verSpeed
     */
    public void setverSpeed(int verSpeed)
    {
        this.verSpeed = verSpeed;
    }

    /**
    * return horSpeed of Swimmable
    * @return int
    */
    public int gethorSpeed(){return this.horSpeed;}

   /**
    * return verSpeed of Swimmable
    * @return int
    */
    public int getverSpeed(){return this.verSpeed;}

    public boolean getshutdown() {return this.shutdown;}

    public void shutdown() {
        this.shutdown = true;
    }

    public CyclicBarrier getFoodrace() {return this.Foodrace;}

    public void Foodrace(CyclicBarrier Foodrace) {
        this.Foodrace=Foodrace;
    }

    public void setCenter (int x,int y)
    {
        this.center_x=x;
        this.center_y=y;
    }

    
    public int getCenter_x ()
    {
        return this.center_x;
    }

    public int getCenter_y ()
    {
        return this.center_y;
    }

    public abstract String getAnimalName();

    public abstract int getEatCount();

    public abstract int getSize();

    public abstract String getColor();

    public abstract void eatInc();
    
    public abstract String toString();
    
    public abstract boolean equals(Object other);
    
    public abstract void drawAnimal(Graphics g);

    public abstract int getx_front();

    public abstract int gety_front();

    public abstract void setx_front(int x);

    public abstract void sety_front(int y);

    public abstract void setx_dir(int x);

    public abstract int getx_dir();

    public abstract void run();

    // public abstract void sleep();
    
}
