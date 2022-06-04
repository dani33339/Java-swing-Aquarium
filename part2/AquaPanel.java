package part2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import q3.*;
import part3.*;

/**
 * class AquaPanel:
 * JPanel of aquarium
 * 
 * @author Daniel Markov ,Anton Volkov 
 */
public class AquaPanel extends JPanel implements ActionListener,Swimmable.Callback,Observer{
    private AquaFrame frame;
    private JPanel p1;
    private JButton[] b_num;
    private String[] names = {"Add Animal","Add Plant","Animal Duplicate","Decorator","Sleep","Wake up","Reset","Food","Info","Exit"};
    private JScrollPane scrollPane;
    private boolean isTableVisible = false;
    private boolean isTable2Visible = false;
    private HashSet<Swimmable> swimmables = new HashSet<Swimmable>();
    private HashSet<Immobile> immobiles = new HashSet<Immobile>();
    private boolean BackgroundeImageStatus=false;
    public ExecutorService executorService = Executors.newFixedThreadPool(5);
    public CyclicBarrier Barrier=null;
    CareTaker cartaker= new CareTaker();
    JTable swimibleInfo,immobileInfo;
    Originator originator = new Originator();

	/**
	* this method is a constructor method to build a new AquaPanel .
    * @param AquaFrame -AquaFrame of the parent
	*/
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

    /**
    * return HashSet<Swimmable> of panel
    * @return HashSet<Swimmable>
    */
    public HashSet<Swimmable> getswimmables(){return swimmables;}
    
    /**
    * return size of swimmables
    * @return int
    */
    public int getswimmablessize(){return swimmables.size();}


    /**
    * return size of Immobiles
    * @return int
    */
    public int getImmobilesize(){return immobiles.size();}

    /**
    * return HashSet<Swimmable> of panel
    * @return HashSet<Swimmable>
    */
    public HashSet<Immobile> getImmobile(){return immobiles;}
    

    /** 
     * add swimmable to the hashset
     * @param s
     */
    public void addswimmables(Swimmable s){
        s.registerObserver(this);
        executorService.execute(s);
        this.swimmables.add(s);
        s.setid(Integer.toString(swimmables.size()));  
    }

    /** 
     * add Immobile to the hashset
     * @param plant
     */
    public void addimmobiles(Immobile plant ){
        
        this.immobiles.add(plant);
        plant.setid(Integer.toString(swimmables.size()));  

    }


    /** 
     * change image Background status
     */
    public void changeBackgroundimagestatus(){

        this.BackgroundeImageStatus= !this.BackgroundeImageStatus;
    }

    public boolean getimagestatus(){return this.BackgroundeImageStatus;};

    
    /** 
     * paint the Component
     * @param g
     */
    public void paintComponent(Graphics g)
    {    
        super.paintComponent(g);
        BufferedImage img = null;

        if (BackgroundeImageStatus==true)
        {
        try {
            img = ImageIO.read(new File ("part2//aquarium.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
        g.drawImage(dimg, 0, 0, null);
        }

        for (Swimmable s : swimmables){
            s.drawCreature(g);
        }
        for (Immobile plant : immobiles){
            plant.drawCreature(g);
        }
        Singleton.getInstance().draw(g);
        repaint();
    }
    
        
    /** 
     * create a AddAnimalDialog
     */
    public void AddAnimal(){

        try{
            if(swimmables.size()>=5)
                throw new Exception("Sorry the aquarium can only hold 5 animals!"); 
            else
            {
                AddAnimalDialog dial = new AddAnimalDialog(frame,this,"Add Animal");
                dial.setVisible(true);
            }
            
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /** 
     * create a AddPlanetDialog
     */
    public void AddPlant(){
        try{
            if(immobiles.size()>=5)
                throw new Exception("Sorry the aquarium can only hold 5 plants!");
            else
            {
                AddPlanetDialog dial = new AddPlanetDialog(frame,this,"Add Plant");
                dial.setVisible(true);
            }
            
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /** 
     * Duplicate an animmal, call AddDuplicateAnimal
     */
    public void DuplicateAnimal(){

        try{
            if(swimmables.size()>=5)
                throw new Exception("You can't duplicate animals, The Aquarium already contains 5 animals!"); // the aquarium limits to only 5 swimmable
            else if(swimmables.size()==0)
                throw new Exception("There are no animals in aquarium to duplicate"); // the aquarium limits to only 5 swimmable
            else
            {
                AddDuplicateAnimal dial = new AddDuplicateAnimal(frame,this,"Duplicate Animal");
                dial.setVisible(true);                  
            }
        }
        catch(Exception e1){
             JOptionPane.showMessageDialog(null,e1.getMessage());
        }
    }

    
    /** 
     * Duplicate an animmal, call AddDuplicateAnimal
     */
    public void Decorator()
    {
        try{
            if (swimmables.size()==0)
                throw new Exception("There are no animals in aquarium to Decorator");
            else
                new JPanelDecorator(this);
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1.getMessage());
       }
    }

    /** 
     * stop the threads
     */
    public void Sleep() {
        AquaFrame.STATE = "sleeping"; 
    }
    
     /** 
     * wake up the threads
     */
     public void Wakeup() {
        if (AquaFrame.STATE == "sleeping")
        {
            AquaFrame.STATE = "swiming";
            for (Swimmable swimmable : this.swimmables) {
                synchronized(swimmable) {
                    swimmable.notify();
                }
            }
        }
    }
 
     /** 
     * reset the panel from swimibles
     */
      public void Reset () {
        Barrier=null;
        for (Swimmable swimmable : this.swimmables) { //set barrier to null to all the animal's (stop the food race)
            swimmable.setBarrier(Barrier);
        }
        this.swimmables.clear(); //delete the swimmables
        this.immobiles.clear();//delete all the plates
        //stop all threads.
        executorService.shutdownNow();
        executorService = Executors.newFixedThreadPool(5);
        Singleton.getInstance().setVisible(false);//undraw the worm
        cartaker.getPmemento().clear(); //clear all saves
        cartaker.getSmemento().clear();
        Barrier=null;
        repaint();
    }

     /** 
     * shutdown the threads
     */
      public void Close(){
        this.executorService.shutdown();
      }

    /** 
     * feed the fish
     */
      public void food(){
        if (Barrier==null && this.getswimmablessize()>0)
        {
            Singleton.getInstance().setVisible(true);//set worm to be unvisible
            Barrier=new CyclicBarrier(swimmables.size());
            for (Swimmable swimmable : this.swimmables) {
                swimmable.setBarrier(Barrier);
            }
        }
    }
    
    /** 
     * lift's the Barrier and gives the food to the fish
     * @param s
     */
    public void DisableBarrire (Swimmable s)
    {
        s.eatInc();
        Barrier=null;
        for (Swimmable i : swimmables) 
        {
            i.setBarrier(null);
        }
        Singleton.getInstance().setVisible(false);//set worm to be unvisible
    } 


    /** 
     * fils and returns the swimible table with the swimbel's data
    * @return JTable
     */
    public JTable getSwimibletable()
    {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Animal Name");
        tbl.addColumn("Color");
        tbl.addColumn("Size");
        tbl.addColumn("Hor.Speed");
        tbl.addColumn("Var.Speed");
        tbl.addColumn("Eat Count");
        tbl.addColumn("Eat Frequency (steps)");
        tbl.addColumn("State");

        
        Object[] columns = {"Name", "Color", "Size", "Hor.Speed", "Var.Speed",
                "Eat Count", "Frequency", "State"};
        tbl.addRow(columns);

        for (Swimmable s : this.swimmables) {
                Object[] row = {s.getId(), s.getColor(), s.getSize(),
                        s.gethorSpeed(), s.getverSpeed(), s.getEatCount()
                        , s.getfoodFrequency()};
                tbl.addRow(row);
        }
        swimibleInfo= new JTable(tbl);
        return swimibleInfo;
    }

    /** 
     * fils and returns the swimible that are saved
    * @return JTable
     */
    public JTable getSavedSwimibelsTable()
    {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Animal Name");
        tbl.addColumn("Color");
        tbl.addColumn("Size");
        tbl.addColumn("Hor.Speed");
        tbl.addColumn("Var.Speed");
        tbl.addColumn("Eat Count");
        tbl.addColumn("Eat Frequency (steps)");
        tbl.addColumn("State");


        Object[] columns = {"Name", "Color", "Size", "Hor.Speed", "Var.Speed",
                "Eat Count", "Frequency", "State"};
        tbl.addRow(columns);

        for (Memento m : this.cartaker.getSmemento()) {
                Object[] row = {m.getId(), m.getColor(), m.getSize(),
                        m.getHorSpeed(), m.getVerSpeed(), m.geteatCount()
                        , m.getfoodFrequency()};
                tbl.addRow(row);
        }
        JTable info = new JTable(tbl);
        return info;
    }


    /** 
     * fils and returns the plants table with the plant's data
    * @return JTable
     */
    public JTable getImmobiletable()
    {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Plant Name");
        tbl.addColumn("Color");
        tbl.addColumn("Size");
        tbl.addColumn("X Position");
        tbl.addColumn("Y Position");

        Object[] columns = {"Name", "Color", "Size", "X Position", "Y Position"};
        tbl.addRow(columns);

        for (Immobile i : this.immobiles) {
                Object[] row = {i.getId(), i.getColorString(), i.getSize(),
                        i.getX(), i.getY()};
                tbl.addRow(row);
        }
        immobileInfo= new JTable(tbl);
        return immobileInfo;
    }


    /** 
     * fils and returns the animal table with the swimmbles
    * @return JTable
     */
    public JTable getSavedImmobiletable()
    {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Plant Name");
        tbl.addColumn("Color");
        tbl.addColumn("Size");
        tbl.addColumn("X Position");
        tbl.addColumn("Y Position");

        Object[] columns = {"Name", "Color", "Size", "X Position", "Y Position"};
        tbl.addRow(columns);

        for (Memento m : this.cartaker.getPmemento()) {
                Object[] row = {m.getId(), m.getColor(), m.getSize(),
                        m.getXfront(), m.getYfront()};
                tbl.addRow(row);
        }
        immobileInfo= new JTable(tbl);
        return immobileInfo;
    }

     /** 
     * fils and returns the swimible table with the swimbel's data for the info button
    * @return JTable
     */
    public JTable getSwimibletableForInfo()
    {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Animal Name");
        tbl.addColumn("Color");
        tbl.addColumn("Size");
        tbl.addColumn("Hor.Speed");
        tbl.addColumn("Var.Speed");
        tbl.addColumn("Eat Count");
        tbl.addColumn("Eat Frequency (steps)");
        tbl.addColumn("State");

        for (Swimmable s : this.swimmables) {
                Object[] row = {s.getId(), s.getColor(), s.getSize(),
                        s.gethorSpeed(), s.getverSpeed(), s.getEatCount()
                        , s.getfoodFrequency(),s.getState()};
                tbl.addRow(row);
        }
        swimibleInfo= new JTable(tbl);
        return swimibleInfo;
    }

     /** 
     * create and Show info table
     */     
     public void Info () {

        if(isTable2Visible == true) {
            this.Wakeup();
            scrollPane.setVisible(false);
            isTable2Visible = false;
            
        }
        if(isTableVisible == false) {
            this.Sleep();
            swimibleInfo=getSwimibletableForInfo();
            scrollPane = new JScrollPane(swimibleInfo);
            scrollPane.setSize(450,swimibleInfo.getRowHeight()*(5)+24);
            add(scrollPane, BorderLayout.CENTER );
            isTableVisible = true;
               
        }
        else{
            isTableVisible = false;
            this.Wakeup();
        }
        
        scrollPane.setVisible(isTableVisible);
        repaint();
     }

     
    /** 
     * close the threads and exit
     */    
    public void Exit() {
        this.Close();
        System.exit(0);
    } 
    
    /** 
     * Perform the action selected (AddAnimal,Sleep,Wakeup,Reset,food,Info,Exit)
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == b_num[0]) 
        AddAnimal();
    else if(e.getSource() == b_num[1]) 
        AddPlant();
    else if(e.getSource() == b_num[2]) 
        DuplicateAnimal();
    else if(e.getSource() == b_num[3]) 
        Decorator();
     else if(e.getSource() == b_num[4]) 
        Sleep();
     else if(e.getSource() == b_num[5])  
        Wakeup();
     else if(e.getSource() == b_num[6])  
        Reset(); 
     else if(e.getSource() == b_num[7])
        food();
     else if(e.getSource() == b_num[8])  
        Info();
     else if(e.getSource() == b_num[9])  
        Exit();
    }

    
    /**
     * notifyAllObservers Listener to the hunger status of the animal's, if they hungry shows the massege
     */
   
    public void update(Swimmable i) 
    {
        if (i.getState() instanceof Hungry && i.getfoodFrequency()==i.getfrequencyCounter())
            JOptionPane.showMessageDialog(null,i.getId() +" wants to eat! ","Hungry animal",JOptionPane.PLAIN_MESSAGE);	
    }
    


    /**
     * save Memento menu
     */
    public void saveMemento() {
        JFrame newframe = new JFrame("Which Animal To Save?");
        swimibleInfo = getSwimibletable();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel apply_panel = new JPanel();
        JButton memento_save = new JButton("Save");
        memento_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == memento_save){
                    newframe.dispose();
                    try {
                        String name = swimibleInfo.getModel().getValueAt(swimibleInfo.getSelectedRow(), 0).toString(); 
                        if (name.equalsIgnoreCase("Name")) //if equals to the first row 
                            throw new Exception();
                        for (Swimmable s : swimmables) { 
                            if (s.getId().equalsIgnoreCase(name)) { 
                                originator.setSwimmable(s);
                                cartaker.addSmemento(originator.saveSwimmableToMemento());
                                JOptionPane.showMessageDialog(null,s.getId() + "State Saved!");
                            }
                        }
                    }
                    catch(Exception exception)
                    {
                        JOptionPane.showMessageDialog(frame,"There is no object in this row please choose a row with an object");  
                    }
                }
            }
        });
        JButton memento_cancel = new JButton("Cancel");
        memento_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == memento_cancel){
                    newframe.dispose();
                }
            }
        });
        apply_panel.setLayout(new GridLayout());

        apply_panel.add(memento_cancel);
        apply_panel.add(memento_save);

        panel.add(swimibleInfo,BorderLayout.NORTH);
        panel.add(apply_panel, BorderLayout.SOUTH);
        newframe.add(panel);
        newframe.pack();
        newframe.setLocationRelativeTo(null);
        newframe.setVisible(true);
    }

    /**
     * save Plants menu
     */
    public void savePlantsMemento(){
        JFrame newframe = new JFrame("Which plant to save?");
        immobileInfo = getImmobiletable();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel apply_panel = new JPanel();
        JButton memento_save = new JButton("Save");
        memento_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == memento_save) {
                    newframe.dispose();
                    try {
                        String name = immobileInfo.getModel().getValueAt(immobileInfo.getSelectedRow(), 0).toString(); //get the name
                        if (name.equalsIgnoreCase("Name"))
                            throw new Exception();
                        for (Immobile i : immobiles) { 
                            if (i.getId().equalsIgnoreCase(name) ) {
                                originator.setImmobile(i);
                                cartaker.addPmemento(originator.saveImmobileToMemento());
                                JOptionPane.showMessageDialog(null,i.getId() + "State Saved!");
                            }
                        }
                    }
                    catch(Exception exception)
                    {
                        JOptionPane.showMessageDialog(frame,"There is no object in this row please choose a row with an object");  
                    }
                }
            }
        });

        JButton memento_cancel = new JButton("Cancel");
        memento_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == memento_cancel){
                    newframe.dispose();
                }
            }
        });
        apply_panel.setLayout(new GridLayout());

        apply_panel.add(memento_cancel);
        apply_panel.add(memento_save);

        panel.add(immobileInfo,BorderLayout.NORTH);
        panel.add(apply_panel, BorderLayout.SOUTH);
        newframe.add(panel);
        newframe.pack();
        newframe.setLocationRelativeTo(null);
        newframe.setVisible(true);
    }
    /**
     * restoreMemento menu
     */
    public void restoreMemento() {
        JFrame newframe = new JFrame("Which animal to restore?");
        JTable SavedSwimibels = getSavedSwimibelsTable();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel apply_panel = new JPanel();
        JButton restore_select = new JButton("Restore");
        restore_select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == restore_select){
                    newframe.dispose();
                    try {
                        String name = SavedSwimibels.getModel().getValueAt(SavedSwimibels.getSelectedRow(), 0).toString();
                        if (name.equalsIgnoreCase("Name"))
                            throw new Exception(); 
                        for (Memento m : cartaker.getSmemento()) { 
                            if (m.getId().equalsIgnoreCase(name)) { 
                                Swimmable s= m.getSwimmable();
                                s.saveState(m.getCol(), m.getSize(),m.getXfront(), m.getYfront(),m.getHorSpeed(),m.getVerSpeed(),m.getX_dir(),m.getY_dir());
                            }
                        }
                    }
                    catch(Exception exception)
                    {
                        JOptionPane.showMessageDialog(frame,"There is no object in this row please choose a row with an object");  
                    }
                }
            }
        });
        JButton memento_cancel = new JButton("Cancel");
        memento_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == memento_cancel){
                    newframe.dispose();
                }
            }
        });
        apply_panel.setLayout(new GridLayout());

        apply_panel.add(memento_cancel);
        apply_panel.add(restore_select);

        panel.add(SavedSwimibels,BorderLayout.NORTH);
        panel.add(apply_panel, BorderLayout.SOUTH);
        newframe.add(panel);
        newframe.pack();
        newframe.setLocationRelativeTo(null);
        newframe.setVisible(true);
    }

    /**
     * restore Plant's menu
     */
    public void restorePlantsMemento(){
        JFrame newframe = new JFrame("Which plant to restore?");
        JTable SavedImmobiles = getSavedImmobiletable();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel apply_panel = new JPanel();
        JButton memento_select = new JButton("Restore");
        memento_select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == memento_select) {
                    newframe.dispose();
                    try{
                        String name = SavedImmobiles.getModel().getValueAt(SavedImmobiles.getSelectedRow(), 0).toString(); 
                        if (name.equalsIgnoreCase("Name"))
                            throw new Exception();
                        for (Memento m : cartaker.getSmemento()) { 
                            if (m.getId().equalsIgnoreCase(name)) { 
                                Immobile i= m.getImmobile();
                                i.saveState(m.getCol(), m.getSize(),m.getXfront(), m.getYfront());
                            }
                        
                        }
                    }
                    catch(Exception exception)
                    {
                        JOptionPane.showMessageDialog(frame,"There is no object in this row please choose a row with an object");  
                    }
                }
            }
        });

        JButton memento_cancel = new JButton("Cancel");
        memento_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == memento_cancel){
                    newframe.dispose();
                }
            }
        });
        apply_panel.setLayout(new GridLayout());

        apply_panel.add(memento_cancel);
        apply_panel.add(memento_select);

        panel.add(SavedImmobiles,BorderLayout.NORTH);
        panel.add(apply_panel, BorderLayout.SOUTH);
        newframe.add(panel);
        newframe.pack();
        newframe.setLocationRelativeTo(null);
        newframe.setVisible(true);
    }

    /**
     * Select Action for animal Restore or Save menu
     */
    public void selectAnimalMemento(){
        JFrame newframe = new JFrame("Select Action:");
        JPanel newpanel = new JPanel();
        JButton btn_memento_restore = new JButton("Restore State");
        JButton btn_memento_save = new JButton("Save State");;
        newpanel.add(btn_memento_restore);
        btn_memento_restore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btn_memento_restore){
                    newframe.dispose();
                    restoreMemento();
                }
            }
        });
        newpanel.add(btn_memento_save);
        btn_memento_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btn_memento_save){
                    newframe.dispose();
                    saveMemento();
                }
            }
        });

        newframe.add(newpanel);
        newframe.pack();
        newframe.setLocationRelativeTo(null);
        newframe.setVisible(true);
    }

    /**
     * Select Action for plant's Restore or Save menu
     */
    public void selectPlantsMemento(){
        JFrame newframe = new JFrame("Select action:");
        JPanel newpanel = new JPanel();
        JButton btn_plants_memento_save = new JButton("Save state");
        JButton btn_plants_memento_restore = new JButton("Restore State");

        btn_plants_memento_restore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btn_plants_memento_restore){
                    newframe.dispose();
                    restorePlantsMemento();
                }
            }
        });
        newpanel.add(btn_plants_memento_restore);

        btn_plants_memento_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btn_plants_memento_save){
                    newframe.dispose();
                    savePlantsMemento();
                }
            }
        });
        newpanel.add(btn_plants_memento_save);

        newframe.add(newpanel);
        newframe.pack();
        newframe.setLocationRelativeTo(null);
        newframe.setVisible(true);
    }
}


