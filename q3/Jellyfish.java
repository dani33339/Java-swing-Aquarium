package q3;

import java.awt.Graphics;
import java.text.DateFormat.Field;
import java.util.concurrent.BrokenBarrierException;

import part2.AquaFrame;

import java.awt.Color;

/**
 * class Jellyfish:
 * this calss is extands from fish class. in this class we have more method in
 * addition to fish mathod
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
   * 
   * @param other - other Jellyfish
   */
  public Jellyfish(Jellyfish other) {
    super(other.gethorSpeed(), other.getverSpeed(),other.callback);
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
  public Jellyfish(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col,Callback callback) {
    super(horSpeed, verSpeed,callback);
    this.size = size;
    this.col = col;
    this.x_front = x_front;
    this.y_front = y_front;
    this.eatCount = 0;
    this.x_dir = 1;
    this.y_dir = 1;

  }

  /**
   * return a string representation of the color:
   * 
   * @return String
   */
  public String getColor() {
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
   * return name Jellyfish
   * 
   * @return String
   */
  public String getAnimalName() {
    return "Jellyfish";
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
   * this method get's other size change the size of the Jellyfish
   * 
   * @param size
   */
  public void changeJellyfish(int size) {
    this.size = size;
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
   * return col of fish
   * 
   * @return int
   */
  public int getcol() {
    return this.col;
  }

  /**
   * change the color of the Fish
   */
  public void changeColor() {
    this.col++;
    if (this.col > 9)
      this.col = 1;
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
   * 
   * @return String
   */
  public String toString() {
    return "typs:" + getAnimalName() + "\n" + "color:" + getColor() + "\n" + "size:" + getSize() + "\n" + "EatCount:"
        + getEatCount() + "\n" + "horSpeed:" +
        super.gethorSpeed() + "\n" + "verSpeed:" + super.getverSpeed() + "\n" + "EAT_DISTANCE:" + this.EAT_DISTANCE;
  }

  /**
   * this method get's an other Jellyfish and return true if this Jellyfish
   * equal's to the other
   * 
   * @param other
   * @return boolean
   */
  public boolean equals(Object other) {
    if (other instanceof Jellyfish) {
      if (super.gethorSpeed() == ((Fish) other).gethorSpeed() && super.getverSpeed() == ((Fish) other).getverSpeed()
          && this.getColor().equals(((Fish) other).getColor()) == true
          && this.getSize() == ((Fish) other).getSize() && this.getEatCount() == ((Fish) other).getEatCount() &&
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
  public void drawAnimal(Graphics g) {
    Color[] colors = new Color[] { Color.black, Color.red, Color.blue, Color.green, Color.cyan, Color.orange,
        Color.yellow, Color.magenta, Color.pink };
    Color color = colors[col - 1];

    int numLegs;
    if (size < 40)
      numLegs = 5;
    else if (size < 80)
      numLegs = 9;
    else
      numLegs = 12;

    g.setColor(color);
    g.fillArc(x_front - size / 2, y_front - size / 4, size, size / 2, 0, 180);

    for (int i = 0; i < numLegs; i++)
      g.drawLine(x_front - size / 2 + size / numLegs + size * i / (numLegs + 1), y_front,
          x_front - size / 2 + size / numLegs + size * i / (numLegs + 1), y_front + size / 3);
  }

  /**
   * this method run's the fish thread
   */
  public void run() {
    float angle;
    int distance_x, distance_y;
    int border_x = AquaFrame.PANEL_WIDTH - 30;
    int border_y = AquaFrame.PANEL_HEIGTH - 85;
    synchronized (this) {
      int speed_x = horSpeed, speed_y = verSpeed;
      while (!this.getshutdown()) {
        if (Barrier == null) {
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
          } catch (InterruptedException e) {
          }
        } else {
          try {
            distance_x = border_x / 2 - x_front;
            distance_y = border_y / 2 - y_front;
            if (Math.sqrt((distance_y * distance_y) + (distance_x * distance_x)) <= 5) {
              callback.DisableBarrire(this);
            } else {
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
              if (Barrier != null)
                Barrier.await();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (BrokenBarrierException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

}
