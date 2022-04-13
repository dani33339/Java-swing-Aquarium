package part2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import q3.Swimmable;

public class AquaPanel extends JPanel implements ActionListener{
    private AquaFrame frame;
    private JPanel p1;
    private JButton[] b_num;
    private String[] names = {"Add Animal","Sleep","Wake up","Food","Info","Exit"};
    private JScrollPane scrollPane;
    private boolean isTableVisible = false;
    private HashSet<Swimmable> set = new HashSet<>();

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


    public void paintComponent()
    {
        for (Swimmable s : set) {
            s.drawAnimal();
        repaint();
    }
    
    public void AddAnimal(){
        AnimalDialog dial = new AnimalDialog(frame,this,"Create post system");
        dial.setVisible(true);
    }

    public void Sleep() {

    }
    
     public void Wakeup() {
         
    }
 
      public void Reset () {
          
      }
 
      
     public void Info () {
        if(isTableVisible == true) {
            scrollPane.setVisible(false);
            isTableVisible = false;
        }
         if(isTableVisible == false) {
               int i=0;
               String[] columnNames = {"Animal", "Color", "Size", "Hor. speed", "Ver. speed","Eat counter"};
               String [][] data = new String[5][columnNames.length];

               JTable table = new JTable(data, columnNames);
               scrollPane = new JScrollPane(table);
               scrollPane.setSize(450,table.getRowHeight()*(5)+24);
               add( scrollPane, BorderLayout.CENTER );
               isTableVisible = true;
         }
         else
             isTableVisible = false;
         
         scrollPane.setVisible(isTableVisible);
        repaint();
        
     }
     
    
    public void Exit() {
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
         Info();
     else if(e.getSource() == b_num[5])  
         Exit();
    }
 
    
}
