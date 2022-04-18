package q3;
import java.awt.Graphics;
import java.awt.Color; 
import java.awt.Polygon;

import part2.AquaFrame;

import java.awt.Graphics2D;
import  java.awt.BasicStroke;

/**
 * class  Fish:
 * its a basic class of the fish
 * 
 * @author Daniel Markov ,Anton Volkov 
 */
public class Fish extends Swimmable {
    private int EAT_DISTANCE=4;
    private int size;
    private int col;
    private int eatCount;
    private int x_front;
    private int y_front;
    private int x_dir;
    private int y_dir;


    /**
	  * this method is a constructor method to build a new Fish .
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
    public Fish(int size, int x_front, int y_front,int horSpeed, int verSpeed, int col)
    {
        super(horSpeed,verSpeed);
        this.size=size;
        this.col=col;
        this.x_front=x_front;
        this.y_front=y_front;
        this.eatCount=0;
        this.x_dir=1;
        this.y_dir=1;
    }

    /**
	  * this method is a copy constructor method to build a new Fish .
    * @param other - other Fish
	  */
    public Fish(Fish other )
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

    public void setx_dir(int x){
      this.x_dir = x;
    }

    public  void setx_front(int x){
      this.x_front = x;
    }

    public  void sety_front(int y){
      this.y_front = y;
    }


    /**
    * return name of fish
    * @return String
    */
    public String getAnimalName() {return "Fish";}

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
    * return col of fish
    * @return int
    */
    public int getcol() {return this.col;}
    
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
    * increase the eatCount if its get over the EAT_DISTANCE the size is increased
    */
    public void eatInc()
     {
      this.eatCount+=1;
      if (this.eatCount > this.EAT_DISTANCE)
      {
        this.eatCount = 0;
        this.size++;
      }
    }

    /**
    * change the size of the Fish
    */
    public void changeFish(int size){this.size=size;}

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
     * return a string representation of a Fish format: 
     * typs:animal name
     * color:color anme 
     * size: size 
     * EatCount: count of eat
     * horSpeed: hor speed
     * verSpeed: verspeed 
     * EAT_DISTANCE: eat distance
     * @return String
     */
    public String toString()
    {
        return "typs:"+getAnimalName()+"\n"+"color:"+getColor()+"\n"+ "size:"+getSize()+"\n"+"EatCount:"+getEatCount()+"\n"+"horSpeed:"+
        super.gethorSpeed()+"\n"+"verSpeed:"+super.getverSpeed()+"\n"+ "EAT_DISTANCE:" + this.EAT_DISTANCE;
    }
    
    
    /** 
     * this method get's an other Fish and return true if this Fish equal's to the other
     * @param other
     * @return boolean
     */
    public boolean equals(Object other)
    {
      if(other instanceof Fish)
      {
        if(super.gethorSpeed() == ((Fish)other).gethorSpeed() && super.getverSpeed() == ((Fish)other).getverSpeed() && this.getColor().equals(((Fish)other).getColor()) == true && this.getSize() == ((Fish)other).getSize() && this.getEatCount() == ((Fish)other).getEatCount() && 
        this.getx_front() == ((Fish)other).getx_front() && this.gety_front() == ((Fish)other).gety_front() && this.getx_dir() == ((Fish)other).getx_dir() && this.gety_dir() == ((Fish)other).gety_dir())
          return true;
        else  
          return false;
      }
      else  
        return false;
    }


  /** 
   * this method draw the animal
   * @param g
   */
  public void drawAnimal(Graphics g)
  {
    Color [] colors= new Color [] {Color.black,Color.red,Color.blue,Color.green, Color.cyan, Color.orange, Color.yellow, Color.magenta,Color.pink};
    Color color = colors[col-1];

   g.setColor(color);
   if(x_dir==1) // fish swims to right side
   {
      // Body of fish
      g.fillOval(x_front - size, y_front - size/4, size, size/2);

      // Tail of fish
      int[] x_t={x_front-size-size/4,x_front-size-size/4,x_front-size};
      int [] y_t = {y_front - size/4, y_front + size/4, y_front};
      Polygon t = new Polygon(x_t,y_t,3);		
      g.fillPolygon(t);

      // Eye of fish
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(new Color(255-color.getRed(),255-color.getGreen(),255- color.getBlue()));
      g2.fillOval(x_front-size/5, y_front-size/10, size/10, size/10);
          
      // Mouth of fish
      if(size>70)
        g2.setStroke(new BasicStroke(3));
      else if(size>30)
        g2.setStroke(new BasicStroke(2));
      else
        g2.setStroke(new BasicStroke(1));
      g2.drawLine(x_front, y_front, x_front-size/10, y_front+size/10);
      g2.setStroke(new BasicStroke(1));
   }
   else // fish swims to left side
   {
      // Body of fish
      g.fillOval(x_front, y_front - size/4, size, size/2);

      // Tail of fish
      int[] x_t={x_front+size+size/4,x_front+size+size/4,x_front+size};
      int [] y_t = {y_front - size/4, y_front + size/4, y_front};
      Polygon t = new Polygon(x_t,y_t,3);		
      g.fillPolygon(t);
      // Eye of fish
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue()));
      g2.fillOval(x_front+size/10, y_front-size/10, size/10, size/10);
          
      // Mouth of fish
      if(size>70)
        g2.setStroke(new BasicStroke(3));
      else if(size>30)
        g2.setStroke(new BasicStroke(2));
      else
        g2.setStroke(new BasicStroke(1));
          g2.drawLine(x_front, y_front, x_front+size/10, y_front+size/10);
          g2.setStroke(new BasicStroke(1));
   }
}

  @Override
  public void run() {

  while(!Thread.currentThread().isInterrupted()){
   
    if(AquaFrame.STATE == "sleeping"){
      
      synchronized(this) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    if(this.getx_front()>=AquaFrame.PANEL_WIDTH-this.getSize() || this.getx_front()<0){
      this.sethorSpeed(this.gethorSpeed()* -1);
      if(this.getx_dir()==1)
          this.setx_dir(-1);
      else 
          this.setx_dir(1);   
    }
    // System.out.println("x:" + this.getx_front() + "," + this.gety_front());
    this.setx_front(this.getx_front()+this.gethorSpeed()+this.getSize()*this.getx_dir());

    if(this.gety_front()>= AquaFrame.PANEL_HEIGTH-this.getSize() || this.gety_front() < 0){
      this.setverSpeed(this.getverSpeed()*-1);
    }
    this.sety_front(this.gety_front()+this.getverSpeed()); 
  }
    
  }
}

