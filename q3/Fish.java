package q3;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;
import part2.*;
import part3.*;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * class Fish:
 * basic class of the fish
 * 
 * @author Daniel Markov ,Anton Volkov
 */
public class Fish extends Swimmable {
    private int EAT_DISTANCE = 4;
    private int size;
    private Color col;
    private int eatCount;
    private int x_front;
    private int y_front;
    private int x_dir;
    private int y_dir;


    /**
     * this method is a constructor method to build a new Fish .
     * 
     * @param size     - the size of the fish.
     * @param col      - the color of the fish.
     * @param eatCount - count of the eating.
     * @param x_front  - move straight on x scale.
     * @param x_dir    - move back on x scale.
     * @param y_dir    - move back on y scale.
     * @param y_front  - move straight on y scale.
     * @param horSpeed - horizantal speed
     * @param verSpeed - vertical speed
     */
    public Fish(int size, int x_front, int y_front, int horSpeed, int verSpeed, Color col,AquaPanel callback ,int foodFrequency) {
      super(horSpeed, verSpeed,callback,foodFrequency);
      this.size = size;
      this.col = col;
      this.x_front = x_front;
      this.y_front = y_front;
      this.eatCount = 0;
      this.x_dir = 1;
      this.y_dir = 1;
    }

    /**
     * this method is a copy constructor method to build a new Fish .
     * 
     * @param other - other Fish
     */
    public Fish(Fish other) {
      super(other.horSpeed, other.verSpeed,other.callback, other.foodFrequency);
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
     * 
     * @return String
     */
    public String getColor() { 
      if(col==Color.black)
        return "Black";
      if(col==Color.red)
        return "Red";
      if(col==Color.blue)
        return "Blue";
      if(col==Color.green)
        return "Green";
      if(col==Color.cyan)
        return "Cyan";
      if(col==Color.orange)
        return "Orange";
      if(col==Color.yellow)
        return "Yellow";
      if(col==Color.magenta)
        return "Magenta";
      if(col==Color.pink)
        return "Pink";
      return String.format("#%06x", col.getRGB() & 0x00FFFFFF);
    }

    /**
     * return name of fish
     * 
     * @return String
     */
    public String getAnimalName() {
      return "Fish";
    }

    /**
     * return eatCount of fish
     * 
     * @return int
     */
    public int getEatCount() {
      return this.eatCount;
    }

    /**
     * return size of fish
     * 
     * @return int
     */
    public int getSize() {
      return this.size;
    }

    /**
     * return col of fish
     * 
     * @return int
     */
    public Color getcol() {
      return this.col;
    }

    /**
     * return x_front of fish
     * 
     * @return int
     */
    public int getx_front() {
      return this.x_front;
    }

    /**
     * return y_front of fish
     * 
     * @return int
     */
    public int gety_front() {
      return this.y_front;
    }

    /**
     * return x_dir of fish
     * 
     * @return int
     */
    public int getx_dir() {
      return this.x_dir;
    }

    /**
     * return y_dir of fish
     * 
     * @return int
     */
    public int gety_dir() {
      return this.y_dir;
    }

    /**
     * increase the eatCount if its get over the EAT_DISTANCE the size is increased
     */
    public void eatInc() {
      this.eatCount += 1;
      if (this.eatCount > this.EAT_DISTANCE) {
        this.eatCount = 0;
        this.size++;
      }
    }

    /**
     * change the size of the Fish
     */
    public void changeFish(int size) {
      this.size = size;
    }


     /**
     * set color to object
     * @param col
     */
    public void setColor(Color col) {
        this.col = col;
    }


    /**
    * set new id to animal
    * @param num
    */
    public void setid(String idnumber) {
      this.id=this.id+idnumber;
    };


  /**
   * clone method reutrns acopy Fish
   * 
   * @return Fish
   */
    public Fish clone(){
      Random rand = new Random();
      int rand_x = rand.nextInt(600);
      int rand_y = rand.nextInt(400);
      Fish obj = new Fish(this.size, rand_x, rand_y, this.horSpeed, this.verSpeed, this.col,this.callback,this.foodFrequency);
      return obj;
  }

    /**
   * update method updates the fish
   * @param size
   * @param horSpeed
   * @param verSpeed
   * @param col
   * 
   */
  public void edit(int size,int horSpeed, int verSpeed, Color col)
  {
    this.size=size;
    this.horSpeed=horSpeed;
    this.verSpeed=verSpeed;
    this.col=col;
  }

    /**
   * set state method set's the state to the fish
   * @param size
   * @param horSpeed
   * @param verSpeed
   * @param x_front
   * @param y_front
   * @param x_dir  
   * @param y_dir
   * 
   */
  public void saveState(Color col, int size, int x_front, int y_front, int horSpeed, int verSpeed,int x_dir,int y_dir) {
		this.col=col;
		this.size=size;
		this.x_front=x_front;
		this.y_front=y_front;
		this.horSpeed=horSpeed;
		this.verSpeed=verSpeed;
		this.x_dir=x_dir;
		this.y_dir=y_dir;
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
     * 
     * @return String
     */
    public String toString() {
      return "typs:" + getAnimalName() + "\n" + "color:" + getColor() + "\n" + "size:" + getSize() + "\n" + "EatCount:"
          + getEatCount() + "\n" + "horSpeed:" +
          super.gethorSpeed() + "\n" + "verSpeed:" + super.getverSpeed() + "\n" + "EAT_DISTANCE:" + this.EAT_DISTANCE;
    }

    /**
     * this method get's an other Fish and return true if this Fish equal's to the
     * other
     * 
     * @param other
     * @return boolean
     */
    public boolean equals(Object other) {
      if (other instanceof Fish) {
        if (super.gethorSpeed() == ((Fish) other).gethorSpeed() && super.getverSpeed() == ((Fish) other).getverSpeed()
            && this.getColor().equals(((Fish) other).getColor()) == true && this.getSize() == ((Fish) other).getSize()
            && this.getEatCount() == ((Fish) other).getEatCount() &&
            this.getx_front() == ((Fish) other).getx_front() && this.gety_front() == ((Fish) other).gety_front()
            && this.getx_dir() == ((Fish) other).getx_dir() && this.gety_dir() == ((Fish) other).gety_dir())
          return true;
        else
          return false;
      } else
        return false;
    }

    /**
     * this method draw the animal
     * 
     * @param g
     */
    public void drawCreature(Graphics g) {
      g.setColor(col);
      if(x_dir==1) // fish swims to right side
      {
        // Body of fish
        g.fillOval(x_front - size, y_front - size/4, size, size/2);
  
        // Tail of fish
        int [] x_t = {x_front - size - size/4, x_front - size - size/4, x_front - size};
        int [] y_t = {y_front - size/4, y_front + size/4, y_front};
        Polygon t = new Polygon(x_t,y_t,3);		
        g.fillPolygon(t);
  
        // Eye of fish
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(255-col.getRed(),255-col.getGreen(),255-col.getBlue()));
        g2.fillOval(x_front - size/5, y_front - size/10, size/10, size/10);
        
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
        int [] x_t = {x_front + size + size/4, x_front + size + size/4, x_front + size};
        int [] y_t = {y_front - size/4, y_front + size/4, y_front};
        Polygon t = new Polygon(x_t,y_t,3);		
        g.fillPolygon(t);
  
        // Eye of fish
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(255-col.getRed(),255-col.getGreen(),255-col.getBlue()));
        g2.fillOval(x_front + size/10, y_front - size/10, size/10, size/10);
        
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

    /**
     *this method calls setcolor of the fish and sets the new color
     * @Color col
     */
    public void PaintFish(Color col) {
      this.setColor(col);
  }


    /**
     * this method run's the fish thread
     */
    public void run() {
      float angle;
      int distance_x, distance_y;
      int border_x = AquaFrame.PANEL_WIDTH - 15;
      int border_y = AquaFrame.PANEL_HEIGTH - 85;
      int speed_x = horSpeed, speed_y = verSpeed;
      synchronized (this) {
        while (!Thread.interrupted()) {
          if (Barrier == null || (Barrier!=null && hungerstate instanceof Satiated)) { //if worm doesn't exit's or hunger state is not hungry just swim normaly
            x_front += speed_x;
            y_front += speed_y;
            if (x_front > border_x || x_front < 0) {
              if (x_front > border_x) {
                x_front -= (size + size / 4);
              }
              if (x_front < 0) {
                x_front += (size + size / 4);
              }
              speed_x = -speed_x;
            }
            if (y_front - size / 4 < 0 || y_front + size / 4 > border_y) {
              speed_y = -speed_y;
            }
            x_dir = speed_x / Math.abs(speed_x);
            y_dir = speed_y / Math.abs(speed_y);

            
            if (frequencyCounter==foodFrequency)
            {
              hungerstate=new Hungry();
              hungerstate.doAction(this);
              notifyAllObservers(this);
              frequencyCounter=0;
            }
              frequencyCounter++;

            if (AquaFrame.STATE == "sleeping") {
              synchronized (this) {
                try {
                  this.wait();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            }
            try {
              Thread.sleep((int) (100));
            } 
            catch (InterruptedException e) {}
          } 
          if(Barrier != null && hungerstate instanceof Hungry) {//if worm exit's and the animal is hungry then go and eat
            try {
              distance_x = border_x / 2 - x_front;
              distance_y = border_y / 2 - y_front;
              if (Math.sqrt((distance_y * distance_y) + (distance_x * distance_x)) <= 5) {
                callback.DisableBarrire(this);
                hungerstate=new Satiated();
                hungerstate.doAction(this); 
                } 
              else {
                angle = (float) Math.atan2(distance_x, distance_y);
                if (Math.abs(distance_x) != 0) {
                  x_dir = (int) (distance_x / Math.abs(distance_x));
                }
                if (Math.abs(distance_y) != 0) {
                  y_dir = (int) (distance_y / Math.abs(distance_y));
                }
                y_front += verSpeed * Math.cos(angle);
                x_front += horSpeed * Math.sin(angle);
                Thread.sleep((int) (100));
              }
            } catch (InterruptedException e) {
            }
          }
        }
      }
    }
}
