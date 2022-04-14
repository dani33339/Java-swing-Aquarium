package part2;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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


public class AquaFrame extends JFrame implements ActionListener{
    private AquaPanel panel;
    
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
        f.setSize(700, 500);
        f.setVisible(true);

        } 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==help)
            JOptionPane.showMessageDialog(f, "Home Work 3 \n GUI @ Threads"); 

        if(e.getSource()==Blue)
            // f.getContentPane().setBackground(Color.blue);
            panel.setBackground(Color.blue);
        
        if(e.getSource()==Image)
        {
            BufferedImage img = null;
                try { 
                    img = ImageIO.read(new URL ("https://www.ubuy.com.tr/productimg/?image=aHR0cHM6Ly9tLm1lZGlhLWFtYXpvbi5jb20vaW1hZ2VzL0kvODFsbzVaTGJiOUwuX0FDX1NMMTUwMF8uanBn.jpg"));
                    Image dimg = img.getScaledInstance(800, 508, Image.CENTER);
                    ImageIcon imageIcon = new ImageIcon(dimg);
                    f.setContentPane(new JLabel(imageIcon));
                }   
                    catch (IOException exp) {};
        }
        if(e.getSource()==None)
            panel.setBackground(Color.white);

        if(e.getSource()==Exit)
            System.exit(0);

        
    }
        

    public static void main(String[] args) {  

        AquaFrame fr = new AquaFrame();
        fr.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        fr.setSize(1200,700);
        
    }

}
