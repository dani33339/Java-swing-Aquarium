package part2;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

/**
 * class AquaFrame:
 * Jframe of aquarium
 * 
 * @author Daniel Markov ,Anton Volkov 
 */
public class AquaFrame extends JFrame implements ActionListener{
    private AquaPanel panel;
    public final static int PANEL_WIDTH = 1200;
    public final static int PANEL_HEIGTH = 800;
    public static String STATE = "swiming";
    JFrame f;
    // menubar
    JMenuBar mb;
  
    // JMenu
    JMenu File,Background,Memento,Help;
  
    // Menu items
    JMenuItem Exit, Image, Blue, None, help,Animal,Plant;
  
    /**
	* this method is a constructor method to build a new AquaFrame
	*/
    public AquaFrame(){   
	    panel = new AquaPanel(this);

        f=new JFrame("my Aquarium");
        f.add(panel);
    
        // create a menubar
        mb = new JMenuBar();

        // create a menu
        File = new JMenu("File");
        Background = new JMenu("Background");
        Memento = new JMenu("Memento");
        Help = new JMenu("Help");
        
        // create menuitems
        Exit = new JMenuItem("Exit");
        Image = new JMenuItem("Image");
        Blue = new JMenuItem("Blue");
        None = new JMenuItem("None");
        help = new JMenuItem("Help");
        Animal = new JMenuItem("Animal");
        Plant = new JMenuItem("Plant");

        
        // add menu items to menu
        File.add(Exit);
        Background.add(Image);
        Background.add(Blue);
        Background.add(None);
        Help.add(help);
        Memento.add(Animal);
        Memento.add(Plant);

        // add menu to menu bar
        mb.add(File);
        mb.add(Background);
        mb.add(Memento);
        mb.add(Help);

        help.addActionListener(this);
        Blue.addActionListener(this);
        Image.addActionListener(this);
        None.addActionListener(this);
        Animal.addActionListener(this);
        Plant.addActionListener(this);
        Exit.addActionListener(this);

        // add menubar to frame
        f.setJMenuBar(mb);
        
        // set the size of the frame
        f.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGTH));
        f.setVisible(true);
        f.setResizable(true);
        
        f.pack();
        }     
    
    /** 
     *Perform the action selected (help,Blue,image,none,exit)
     * @param e
     */
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==help)
            JOptionPane.showMessageDialog(f, "Home Work 3 \n GUI @ Threads"); 

        if(e.getSource()==Blue)
        {
            //remove image if it exit's

            if(panel.getimagestatus())
                panel.changeBackgroundimagestatus();
            panel.setBackground(Color.blue);
        }
        
        if(e.getSource()==Image)
        {
            if(!panel.getimagestatus())
                panel.changeBackgroundimagestatus();
        }
        if(e.getSource()==None)
        {
            //remove image if it exsist's
            if(panel.getimagestatus())
                panel.changeBackgroundimagestatus();
            panel.setBackground(Color.white);
        }


        if(e.getSource()==Animal)
        {
            panel.selectAnimalMemento();
        }  

        
        if(e.getSource()==Plant)
        {
            panel.selectPlantsMemento();
        }  

        if(e.getSource()==Exit){
            this.panel.Close();
            System.exit(0);   
        }

    }
        
    
    /** 
     * main function
     * create AquaFrame frame
     * @param args
     */
    public static void main(String[] args) {  

        AquaFrame fr = new AquaFrame();
        fr.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  
    }
}
