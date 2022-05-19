package part3;
import part2.*;
import q3.*;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.HashSet;



public class AddDuplicateAnimal extends JDialog implements ActionListener{
	
	public JFrame f;  
	private JPanel p1,p2;
    private JButton duplicate, cancel;
    private JLabel lbl_type, lbl_size, lbl_Horizontal, lbl_Vertical, lbl_color;
	private JComboBox <String> typeComboBox,colorComboBox;
	private JTextField txfsize;
    private AquaPanel panel;
	private AbstractSeaFactory abstractSeaFactory;
	private SeaCreature seaCreature;
    JScrollPane scrollPane;

	public AddDuplicateAnimal(AquaFrame parent, AquaPanel pan, String title,JScrollPane scrollPane)
	{
        super((AquaFrame)parent,title,true);
    	panel = pan;
        this.scrollPane=scrollPane;
        add( scrollPane, BorderLayout.CENTER );

        scrollPane.setVisible(true);
        repaint();

    	setSize(600,400);
	
		// setBackground(new Color(100,230,255));
		// p1 = new JPanel(); // selections
		// p2 = new JPanel(); //duplicate and cencel
	
		// p1.setLayout(new GridLayout(6,1,10,5));
		// lbl_type = new JLabel("Animal type:",JLabel.CENTER);
		// lbl_size = new JLabel("Animal size from 20 to 320:",JLabel.CENTER);
		// lbl_Horizontal = new JLabel("Horizontal speed:",JLabel.CENTER);
		// lbl_Vertical = new JLabel("Vertical speed:",JLabel.CENTER);
		// lbl_color = new JLabel("Color of the animal:",JLabel.CENTER);

		// /*JComboBox for animal type */
		// p1.add(lbl_type);
		// String s1[] = { "Fish", "Jellyfish" };
		// typeComboBox = new JComboBox<String> (s1);
		// p1.add(typeComboBox);

		// /*JTextField for animal size */
		// p1.add(lbl_size);
		// txfsize = new JTextField();
		// p1.add(txfsize);


		// p1.add(lbl_color);
		// String s2[] = { "Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow" ,"Magenta", "Pink"};
		// colorComboBox = new JComboBox<String> (s2);
		// p1.add(colorComboBox);
		
		// p2.setLayout(new GridLayout(1,2,5,5));
		// duplicate=new JButton("duplicate");
		// duplicate.addActionListener(this);
		// duplicate.setBackground(Color.lightGray);
		// p2.add(duplicate);		
		// cancel=new JButton("Cancel");
		// cancel.addActionListener(this);
		// cancel.setBackground(Color.lightGray);
		// p2.add(cancel);
		
		// setLayout(new BorderLayout());
		// add("North" , p1);
		// add("South" , p2);
    }

	
	/** 
	 * convert color in colorbox to a color number 1-9
	 * @return int
	 */
	public int getColorint()
    {
        int color = 1;
        switch (colorComboBox.getSelectedItem().toString()) {
          case "Black":
            color = 1;
            break;
          case "Red":
            color = 2;
            break;
          case "Blue":
            color = 3;
            break;
          case "Green":
            color = 4;
            break;
          case "Cyan":
            color = 5;
            break;
          case "Orange":
            color = 6;
            break;
          case "Yellow":
            color = 7;
            break;
          case "Magenta":
            color = 8;
            break;
          case "Pink":
            color = 9;
            break;
        }
        return color;
    }
	
	/** 
	 * Perform the action selected (duplicate or cencel)
	 * @param e
	 */
    public void actionPerformed(ActionEvent e) {
	// 	if(e.getSource()==duplicate)
	// 	{
    //         String name = info.getModel().getValueAt(info.getSelectedRow(),0).toString(); //get the name of animal from selected row
    //             for(SeaCreature obj : seaItems){ //run over seaitems hashset
    //                 if(obj instanceof Swimmable){ //check for swimmable object
    //                     if(((Swimmable)obj).getAnimalName().equalsIgnoreCase(name)){ //Comparison with name
    //                         if(obj instanceof Fish){// check for fish object
    //                             SeaCreature clone = ((Fish)obj).clone(); //clone
    //                             cloneFactory = new CloneFactory(((Fish)clone));
    //                             addToHash(clone); //add to list
    //                             break;
    //                         }
    //                         if(obj instanceof Jellyfish){ //jelly Fish object
    //                             SeaCreature clone = ((Jellyfish)obj).clone(); //clone
    //                             cloneFactory = new CloneFactory(((Jellyfish)clone));
    //                             addToHash(clone); //add to list
    //                             break;
    //                         }

		
	// 	}
	// 	if(e.getSource()==cancel)
	// 	{
	// 		setVisible(false);
	// 	}
		
	}
	
	// public void duplicateAnimalObject(int idObject,String typeAnimal) //duplicate the swimmable by get id and type
	// {
	// 	itrAnimals= animalsSet.iterator(); 
	// 	while(itrAnimals.hasNext()){
	// 		Swimmable sw=itrAnimals.next();
	// 		if(sw.getID()==idObject){
	// 			if(typeAnimal=="Fish")
	// 				duplicateSwimmable=(Fish)sw.clone();
	// 			if(typeAnimal=="Jelly Fish")
	// 				duplicateSwimmable=(Fish)sw.clone();
	
	// 		}
	// 	}

}
