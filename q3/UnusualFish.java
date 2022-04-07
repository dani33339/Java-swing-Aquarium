package q3;

/**
 * class  UnusualFish:
 * this calss is extands from fish class. in this class we have more method in addition to fish mathod
 *
 * @author Daniel Markov ,Anton Volkov 
 */
public class UnusualFish extends Fish {
    private int factor;


    /**
	* this method is a copy constructor method to build a new UnusualFish .
    * @param other - other UnusualFish
	*/
    public UnusualFish(UnusualFish other) {
        super(other.getSize(), other.getx_front(), other.gety_front(), other.getverSpeed(), other.gethorSpeed(), other.getcol());
        this.factor=other.getfactor();
    }


    /**
	* this method is a constructor method to build a new UnusualFish .
    * @param size - the size of the fish.
    * @param col - the color of the fish.
	* @param eatCount - count of the eating.
	* @param x_front - move straight on x scale.
    * @param x_dir - move back on x scale.
    * @param y_dir -  move back on y scale.
    * @param y_front -  move straight on y scale.
    * @param horSpeed -  horizantal speed
    * @param verSpeed -  vertical speed
	*/
    public UnusualFish(int size, int x_front, int y_front,int horSpeed, int verSpeed, int col,int factor) {
        super(size, x_front, y_front, verSpeed, horSpeed, col);
        this.factor=factor;
    }

    /**
    * return factor of UnusualFish
    * @return int
    */
    public int getfactor() {return this.factor;}
    
    public void setfactor(int factor) {this.factor=factor;}

    /**
    * return size of UnusualFish
    * @return int
    */
    public int getSize() {return this.factor*super.getSize();}

    /**
    * return UnusualFish
    * @return String
    */
    public String getAnimalName() {return "UnusualFish";}

 
}
