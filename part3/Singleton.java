package part3;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import part2.AquaFrame;

public class Singleton {
    BufferedImage wormImage=null;
    boolean Visible=false;

    private static Singleton instance = null;
    /* A private Constructor prevents any other
    * class from instantiating.*/
    private Singleton(){ }
    /* Static 'instance' method */
    public static Singleton getInstance( ){
    if(instance == null)
        instance = new Singleton();
    return instance;
    }

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

    public void undraw()
    {
        Visible=false;
    }

    public void setVisible (Boolean visible)
    {
        Visible=visible;
    }

    public Boolean getStatus ()
    {
        return Visible;
    }

    // public static void set(){
	// 	if(instance!=null){
	// 		instance=null;
	// 	}
	// }

}
