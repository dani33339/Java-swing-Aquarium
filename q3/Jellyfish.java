package q3;

/**
 * class  Jellyfish:
 * this calss is extands from fish class. in this class we have more method in addition to fish mathod
 *
 * @author Daniel Markov ,Anton Volkov 
 */
public class Jellyfish extends Swimmable {
    private int EAT_DISTANCE = 4;
    private int size;
    private int col;
    private int eatCount;
    private int x_front;
    private int y_front;
    private int x_dir;
    private int y_dir;

    /**
	  * this method is a copy constructor method to build a new Jellyfish.
    * @param other - other Jellyfish
	  */
    public Jellyfish(Jellyfish other )
    {
      super(other.gethorSpeed(),other.getverSpeed());
      this.size = other.getSize();
      this.col = other.getcol();
      this.eatCount = other.getEatCount();
      this.x_dir = other.getx_dir();
      this.x_front = other.getx_front();
      this.y_dir = other.gety_dir();
      this.y_front = other.gety_front();
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
    public Jellyfish(int size, int x_front, int y_front,int horSpeed, int verSpeed, int col)
    {
        this.size=size;
        this.col=col;
        this.x_front=x_front;
        this.y_front=y_front;
        this.eatCount=0;
        this.x_dir=1;
        this.y_dir=1;
    }

    
    /** 
    * return a string representation of the color: 
     * @return String
     */
    public String getColor()
    {
        String color = "";
        switch (this.col) {
          case 1:
            color = "Black";
            break;
          case 2:
            color = "Red";
            break;
          case 3:
            color = "Blue";
            break;
          case 4:
            color = "Green";
            break;
          case 5:
            color = "Cyan";
            break;
          case 6:
            color = "Orange";
            break;
          case 7:
            color = "Yellow";
            break;
          case 8:
            color = "Magenta";
            break;
          case 9:
            color = "Pink";
            break;
        }
        return color;
    }

    /**
    * return name  Jellyfish
    * @return String
    */
    public String getAnimalName() {return "Jellyfish";}

    
    /**
    * return eatCount of fish
    * @return int
    */
    public int getEatCount() {return this.eatCount;}

    /**
    * return size of fish
    * @return int
    */
    public int getSize() {return this.size;}

    /**
    * increase the eatCount if its get over the EAT_DISTANCE the size is increased
    */
    public void eatInc() 
    {
      this.eatCount+=1;
      if (this.eatCount>this.EAT_DISTANCE)
      {
        this.eatCount = 0;
        this.size++;
      }
    }

    /** 
    * this method get's other size change the size of the Jellyfish
    * @param size
    */
    public void changeJellyfish(int size){this.size=size;}

    /**
    * return x_front of fish
    * @return int
    */
    public int getx_front() {return this.x_front;}

    /**
    * return y_front of fish
    * @return int
    */
    public int gety_front() {return this.y_front;}

    /**
    * return x_dir of fish
    * @return int
    */
    public int getx_dir() {return this.x_dir;}

    /**
    * return y_dir of fish
    * @return int
    */
    public int gety_dir() {return this.y_dir;}

    /**
    * return col of fish
    * @return int
    */
    public int getcol() {return this.col;}

    /**
    * change the color of the Fish
    */
    public void changeColor()
    {
      this.col++;
      if(this.col >9)
        this.col =1;
    }

    /** 
     * return a string representation of a Jellyfish format: 
     * typs:animal name
     * color:color anme 
     * size: size 
     * EatCount: count of eat
     * horSpeed: hor speed
     * verSpeed: verspeed 
     * EAT_DISTANCE: eat distance
     * @return String
     */
    public String toString() {
      return "typs:"+getAnimalName()+"\n"+"color:"+getColor()+"\n"+ "size:"+getSize()+"\n"+"EatCount:"+getEatCount()+"\n"+"horSpeed:"+
      super.gethorSpeed()+"\n"+"verSpeed:"+super.getverSpeed()+"\n"+ "EAT_DISTANCE:" + this.EAT_DISTANCE;
    }

    
    /** 
     * this method get's an other Jellyfish and return true if this Jellyfish equal's to the other
     * @param other
     * @return boolean
     */
    public boolean equals(Object other)
    {
      if(other instanceof Jellyfish)
      {
        if(super.gethorSpeed() == ((Fish)other).gethorSpeed() && super.getverSpeed() == ((Fish)other).getverSpeed() 
        && this.getColor().equals(((Fish)other).getColor()) == true 
        && this.getSize() == ((Fish)other).getSize() && this.getEatCount() == ((Fish)other).getEatCount() && 
        this.getx_front() == ((Fish)other).getx_front() && this.gety_front() == ((Fish)other).gety_front() 
        && this.getx_dir() == ((Fish)other).getx_dir() && this.gety_dir() == ((Fish)other).gety_dir())
          return true;
        else     
          return false;   
      }
      else  
        return false;
      
    } 
}
