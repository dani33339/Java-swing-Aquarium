package part3;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import part2.AquaFrame;


/**
 * class Singleton:
 * design pattern of Singleton for the worm
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class Singleton {
    BufferedImage wormImage=null;
    boolean Visible=false;

    private static Singleton instance = null;
    /* A private Constructor prevents any other
    * class from instantiating.*/
    private Singleton(){ }
    
    /** 
     * @return Singleton
    *
    * Static 'instance' method */
    public static Singleton getInstance( ){
    if(instance == null)
        instance = new Singleton();
    return instance;
    }

    
    /** 
     * draw's the worm
     * @param g
     */
    public void draw(Graphics g)
    {
        if (Visible)
        {
            try {
                wormImage = ImageIO.read(new File("part2\\worm.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int border_x = AquaFrame.PANEL_WIDTH-15;
            int border_y= AquaFrame.PANEL_HEIGTH-85;
            g.drawImage(wormImage,border_x /2 ,border_y/2 ,50, 50, null); 
        }
    }

  
    /** 
     * set's the visiblty
     * @param visible
     */
    public void setVisible (Boolean visible)
    {
        Visible=visible;
    }

    
    /** 
     * get's the Visible
     * @return Boolean
     */
    public Boolean getStatus ()
    {
        return Visible;
    }

}
