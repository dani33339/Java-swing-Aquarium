package q3;

import java.awt.Graphics;
import java.util.concurrent.CyclicBarrier;
import part3.SeaCreature;
import part3.*;
import java.util.Observable;


/**
 * class  Swimmable:
 * this calss is the bais of the all calsses we have is q3
 *
 * @author Daniel Markov ,Anton Volkov 
 */
public abstract class Swimmable extends Observable implements Runnable,SeaCreature,Cloneable  {
    protected int horSpeed;
    protected int verSpeed;
    protected int foodFrequency;
    protected CyclicBarrier Barrier=null;
    protected final Callback callback;
    protected String id=this.getClass().getSimpleName();
    protected int frequencyCounter=0;
    protected HungerState hungrstatus;
    protected boolean counterflag=false;

    
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
        this.foodFrequency=0;
        this.callback = null;
    }

    /**
	* this method is a  constructor method to build a new Swimmable .
    * @param horSpeed 
    * @param verSpeed
	*/
    public Swimmable(int horSpeed,int verSpeed, Callback callback, int foodFreq)
    {
        this.callback = callback;
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
        this.foodFrequency=foodFreq;
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
     * get Barrier
     */
    public CyclicBarrier getBarrier() {return this.Barrier;}
    
    /** 
     * set Barrier
     * @param Barrier
     */
    public void setBarrier(CyclicBarrier Barrier) {
        this.Barrier=Barrier;
    } 

    public abstract String getAnimalName();

    public abstract void setid(String id) ;

    /**
     * get id from animal
     * @param num
     */
    public String getId(){return id;};

    public abstract int getEatCount();

    public abstract int getSize();

    public abstract String getColor();

    public abstract void eatInc();
    
    public abstract String toString();
    
    public abstract boolean equals(Object other);
    
    public abstract void drawCreature(Graphics g);

    public abstract int getx_front();

    public abstract int gety_front();

    public abstract int getx_dir();

    public abstract void run();

    public abstract Swimmable clone();

    public abstract void edit(int size,int horSpeed, int verSpeed, int col);

    public abstract void setHungery(HungerState state);

}
