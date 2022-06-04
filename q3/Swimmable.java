package q3;

import java.util.Vector;
import java.util.concurrent.CyclicBarrier;
import javax.swing.JOptionPane;

import part2.AquaPanel;
import part3.*;
import java.awt.*;



/**
 * class Swimmable:
 * abstract class of the all swimmables in the program
 *
 * @author Daniel Markov ,Anton Volkov 
 */
public abstract class Swimmable implements Runnable,SeaCreature,Cloneable,MarineAnimal {
    protected int horSpeed;
    protected int verSpeed;
    protected int foodFrequency;
    protected CyclicBarrier Barrier=null;
    protected final AquaPanel callback;
    protected String id=this.getClass().getSimpleName();
    protected int frequencyCounter=0;
    protected HungerState hungerstate= new Satiated();
    protected Vector<Observer> list = new Vector<Observer>();
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
    public Swimmable(int horSpeed,int verSpeed, AquaPanel callback, int foodFreq)
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
    
    public int getfrequencyCounter() {return this.frequencyCounter;}

    /** 
     * set Barrier
     * @param Barrier
     */
    public void setBarrier(CyclicBarrier Barrier) {
        this.Barrier=Barrier;
    } 
   /**
    * return foodFrequency of Swimmable
    * @return int
    */
    public int getfoodFrequency(){return this.foodFrequency;};

   /**
    * return id of Swimmable
    * @return int
    */
    public String getId(){return id;};

    public abstract String getAnimalName();

    public abstract void setid(String id) ;

    public abstract int getEatCount();

    public abstract int getSize();

    public abstract String getColor();

    public abstract Color getcol() ;

    public abstract void eatInc();
    
    public abstract String toString();
    
    public abstract boolean equals(Object other);
    
    public abstract void drawCreature(Graphics g);

    public abstract int getx_front();

    public abstract int gety_front();

    public abstract int getx_dir();

    public abstract int gety_dir();

    public abstract void run();

    public abstract Swimmable clone();

    public abstract void edit(int size,int horSpeed, int verSpeed, Color col);

    /**
    * show's a message that the fish is hungry
    */
    public void notifyAllObservers(Swimmable s) {
        	for (Observer observer : list) {
                observer.update(this);
            }
    }

    public void registerObserver(Observer i){
        list.add(i);
    }

    abstract public void saveState(Color col,int size,int x_front,int y_front,int horSpeed,int verSpeed,int x_dir,int y_dir);

    /**
     * set's the hunger state
    * @param hungerstate 
    */
    public void setHungeryState(HungerState hungerstate){
        this.hungerstate = hungerstate;		
     }
      /**
     * return the hunger state of swimmable
     * 
     * @return HungerState
     */
     public HungerState getState(){
        return hungerstate;
     }

}
