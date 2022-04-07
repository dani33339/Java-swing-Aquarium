package q3;

/**
 * class  MultiColorFish:
 * this calss is extands from fish class. in this class we have more method in addition to fish mathod
 *
 * @author Daniel Markov ,Anton Volkov 
 */
public class MultiColorFish extends Fish {

    /**
	* this method is a copy constructor method to build a new MultiColorFish .
    * @param other - other MultiColorFish
	*/
    public MultiColorFish(MultiColorFish other) {
        super(other.getSize(), other.getx_front(), other.gety_front(), other.getverSpeed(), other.gethorSpeed(), other.getcol());
    }

    /**
	* this method is a constructor method to build a new MultiColorFish .
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
    public MultiColorFish(int size, int x_front, int y_front,int horSpeed, int verSpeed, int col) {
        super(size, x_front, y_front, verSpeed, horSpeed, col);
    }

    /**
    * return name MultiColorFish
    * @return String
    */
    public String getAnimalName() {return "MultiColorFish";}

    
    /** 
     * this method change the color and the size of the MultiColorFish
     * @param size
     */
    public void changeFish(int size){
        super.changeFish(size);
        super.changeColor();
    }


}
