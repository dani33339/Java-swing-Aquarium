package part2;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.awt.Graphics;



public class AquaFrame extends JFrame implements ActionListener{
    private AquaPanel panel;
    public final static int PANEL_WIDTH = 800;
    public final static int PANEL_HEIGTH = 600;
    public static String STATE = "swiming";
    JFrame f;
    // menubar
    JMenuBar mb;
  
    // JMenu
    JMenu File,Background,Help;
  
    // Menu items
    JMenuItem Exit, Image, Blue, None, help;
  
    // create a frame
    public AquaFrame(){   
        // super("Post tracking system");
	    panel = new AquaPanel(this);
	    // add(panel);
	    // panel.setVisible(true); 

        f=new JFrame("my Aquarium");
        f.add(panel);
    
        // create a menubar
        mb = new JMenuBar();

        // create a menu
        File = new JMenu("File");
        Background = new JMenu("Background");
        Help = new JMenu("Help");
        
        // create menuitems
        Exit = new JMenuItem("Exit");
        Image = new JMenuItem("Image");
        Blue = new JMenuItem("Blue");
        None = new JMenuItem("None");
        help = new JMenuItem("Help");
        
        // add menu items to menu
        File.add(Exit);
        Background.add(Image);
        Background.add(Blue);
        Background.add(None);
        Help.add(help);
        
        // add menu to menu bar
        mb.add(File);
        mb.add(Background);
        mb.add(Help);

        help.addActionListener(this);
        Blue.addActionListener(this);
        Image.addActionListener(this);
        None.addActionListener(this);
        Exit.addActionListener(this);

        // add menubar to frame
        f.setJMenuBar(mb);
        
        // set the size of the frame
        f.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGTH));
        f.setVisible(true);
        f.setResizable(true);
        
        f.pack();
        } 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==help)
            JOptionPane.showMessageDialog(f, "Home Work 3 \n GUI @ Threads"); 

        if(e.getSource()==Blue)
        {
            /*remove picLabel JLabel if it exit's*/
            if (panel.getComponentCount()>1)
                panel.remove(1);
            panel.setBackground(Color.blue);
        }
        
        if(e.getSource()==Image)
        {
            panel.addimage();
            f.pack();
        }
        if(e.getSource()==None)
        {
            /*remove picLabel JLabel if it exit's*/
            if (panel.getComponentCount()>1)
                panel.remove(1);
            panel.setBackground(Color.white);
        }

        if(e.getSource()==Exit)
            this.panel.Close();
            System.exit(0);    
    }
        
    public static void main(String[] args) {  

        AquaFrame fr = new AquaFrame();
        fr.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        
    }

}
