package q3;

import java.awt.Graphics;
import java.util.concurrent.CyclicBarrier;

import part2.AquaPanel;
/**
 * class  Swimmable:
 * this calss is the bais of the all calsses we have is q3
 *
 * @author Daniel Markov ,Anton Volkov 
 */
public abstract class Swimmable implements Runnable {
    protected int horSpeed;
    protected int verSpeed;
    protected boolean shutdown = false;
    public CyclicBarrier Barrier=null;
    protected final Callback callback;

    
    public interface Callback {
        void DisableBarrire(Swimmable s);
    }
    
    /**
	* this method is a default constructor method to build a new Swimmable .
	*/
    public Swimmable()
    {
        this.horSpeed=0;
        this.verSpeed=0;
        this.callback = null;
    }

    /**
	* this method is a  constructor method to build a new Swimmable .
    * @param horSpeed 
    * @param verSpeed
	*/
    public Swimmable(int horSpeed,int verSpeed, Callback callback)
    {
        this.callback = callback;
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

    /**
    * return shutdown
    * @return int
    */
    public boolean getshutdown() {return this.shutdown;}

    /**
    * set shutdown to true
    */
    public void shutdown() {
        this.shutdown = true;
    }

    public CyclicBarrier getBarrier() {return this.Barrier;}

    
    /** 
     * set Barrier
     * @param Barrier
     */
    public void setBarrier(CyclicBarrier Barrier) {
        this.Barrier=Barrier;
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

    public abstract int getx_dir();

    public abstract void run();

    


}
