package part2;
import part2.AquaFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import q3.*;

public class AquaPanel extends JPanel implements ActionListener{
    private AquaFrame frame;
    private JPanel p1;
    private JButton[] b_num;
    private String[] names = {"Add Animal","Sleep","Wake up","reset","Food","Info","Exit"};
    private JScrollPane scrollPane;
    private boolean isTableVisible = false;
    private boolean isTable2Visible = false;
    private HashSet<Swimmable> swimmables = new HashSet<Swimmable>();
    public static ExecutorService executorService = Executors.newFixedThreadPool(5);
    BufferedImage image=null;
        
     

    public AquaPanel(AquaFrame f) {
         frame = f;
         setBackground(new Color(255,255,255));
         p1=new JPanel();
         p1.setLayout(new GridLayout(1,7,0,0));
         p1.setBackground(new Color(0,150,255));
         b_num=new JButton[names.length];
         
         for(int i=0;i<names.length;i++) {
             b_num[i]=new JButton(names[i]);
             b_num[i].addActionListener(this);
             b_num[i].setBackground(Color.lightGray);
             p1.add(b_num[i]);		
         }
 
         setLayout(new BorderLayout());
         add("South", p1);

    }

    public HashSet<Swimmable> getswimmables(){return swimmables;}
    
    public int getswimmablessize(){return swimmables.size();}

    public void addswimmables(Swimmable s){
        
        executorService.execute(s);
        this.swimmables.add(s);
        
        }

    public void addimage(){
        BufferedImage img = null;
        try { 
            img = ImageIO.read(new URL ("https://www.ubuy.com.tr/productimg/?image=aHR0cHM6Ly9tLm1lZGlhLWFtYXpvbi5jb20vaW1hZ2VzL0kvODFsbzVaTGJiOUwuX0FDX1NMMTUwMF8uanBn.jpg"));

            }   
        catch (IOException exp) {};
        Image dimg = img.getScaledInstance(800, 508, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(dimg);
        JLabel picLabel = new JLabel(imageIcon);
        add(picLabel);
    }

    public void paintComponent(Graphics g)
    {    
        super.paintComponent(g);
        for (Swimmable s : swimmables){
            s.drawAnimal(g);
        }
        g.drawImage(image, 0, 0, null);
        repaint();
    }
    
    public void AddAnimal(){
        AnimalDialog dial = new AnimalDialog(frame,this,"Create post system");
        dial.setVisible(true);
    }

    public  void Sleep() {
        AquaFrame.STATE = "sleeping"; 
    }
    
    

     public void Wakeup() {
        AquaFrame.STATE = "swiming";
        for (Swimmable swimmable : this.swimmables) {
            synchronized(swimmable) {
                swimmable.notify();
            }
        }
    }
 
      public void Reset () {
        this.executorService.shutdown();
        this.swimmables.clear();
    }

      public void Close(){
        this.executorService.shutdown();
      }
      public void food(){
        // image = ImageIO.read(new File("C:\\Projects\\MavenSandbox\\src\\main\\resources\\img.jpg"))

      }
 
      
     public void Info () {
        

        if(isTable2Visible == true) {
            this.Wakeup();
            scrollPane.setVisible(false);
            isTable2Visible = false;
            
        }
        if(isTableVisible == false) {
               this.Sleep();
               
               int i=0;
               String[] columnNames = {"Animal", "Color", "Size", "Hor. speed", "Ver. speed","Eat counter"};
               Object [][] data = new String[5][columnNames.length];
               for (Swimmable s : swimmables) {
                    data[i][0] = "" + s.getAnimalName();
                    data[i][1] = "" + s.getColor();
                    data[i][2] = "" + s.getSize();
                    data[i][3] = "" + s.gethorSpeed();
                    data[i][4] = "" + s.getverSpeed();
                    data[i][5] = "" + s.getEatCount();
                    i++;                  
                    }
               JTable table = new JTable(data, columnNames);
               scrollPane = new JScrollPane(table);
               scrollPane.setSize(450,table.getRowHeight()*(5)+24);
               add( scrollPane, BorderLayout.CENTER );
               isTableVisible = true;
               
        }
        else{
            isTableVisible = false;
            this.Wakeup();
        }
        
        scrollPane.setVisible(isTableVisible);
        repaint();
        
     }
     
    
    public void Exit() {
        this.Close();
        System.exit(0);
    }
 
    
    
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == b_num[0]) 
        AddAnimal();
     else if(e.getSource() == b_num[1]) 
        Sleep();
     else if(e.getSource() == b_num[2])  
        Wakeup();
     else if(e.getSource() == b_num[3])  
        Reset(); 
     else if(e.getSource() == b_num[4])
        food();
     else if(e.getSource() == b_num[5])  
        Info();
     else if(e.getSource() == b_num[6])  
        Exit();
    }
 
    
}
