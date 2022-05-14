package part3;
import part2.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class AddPlanetDialog extends JDialog  implements ActionListener {    

/**
 * class  AddAnimalDialog:
 * JDialog that add's a fish
 * 
 * @author Daniel Markov ,Anton Volkov 
 */
	public JFrame f;  
	private JPanel p1,p2;
    private JButton add, cancel;
    private JLabel lbl_type,lbl_size;
	private JComboBox <String>  typeComboBox;
	private JTextField txfsize;
    private AquaPanel panel;
	private AbstractSeaFactory abstractSeaFactory;
	private SeaCreature seaCreature;
 
	/**
	* this method is a constructor method to build a new AddAnimalDialog .
    * @param AquaFrame -AquaFrame of the parent
    * @param pan - AquaPanel parent
	* @param title - title of the AddAnimalDialog
	*/
    public AddPlanetDialog(AquaFrame parent, AquaPanel pan, String title) {
    	super((AquaFrame)parent,title,true);
    	panel = pan;

    	setSize(600,400);
	
		setBackground(new Color(100,230,255));
		p1 = new JPanel(); // selections
		p2 = new JPanel(); //add and cencel
	
		p1.setLayout(new GridLayout(6,1,10,5));
		lbl_type = new JLabel("Plant type:",JLabel.CENTER);
		lbl_size = new JLabel("Plant size from 20 to 320:",JLabel.CENTER);;

		/*JComboBox for animal type */
		p1.add(lbl_type);
		String s1[] = { "Laminaria", "Zostera" };
		typeComboBox = new JComboBox <String> (s1);
		p1.add(typeComboBox);

		/*JTextField for animal size */
		p1.add(lbl_size);
		txfsize = new JTextField();
		p1.add(txfsize);
		
		p2.setLayout(new GridLayout(1,2,5,5));
		add=new JButton("Add");
		add.addActionListener(this);
		add.setBackground(Color.lightGray);
		p2.add(add);		
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setBackground(Color.lightGray);
		p2.add(cancel);
		
		setLayout(new BorderLayout());
		add("North" , p1);
		add("South" , p2);
    }

	
	/** 
	 * Perform the action selected (add or cencel)
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add){
			if(panel.getImmobilesize()<5){
				if (txfsize.getText().isBlank()|| Integer.parseInt(txfsize.getText())>320 || Integer.parseInt(txfsize.getText())<20)
				{
					f=new JFrame();  
					JOptionPane.showMessageDialog(f,"The size have to be from 20 to 320");  
				}
				else{
					Random rand = new Random();
					int rand_x = rand.nextInt(100,600);
					int rand_y = rand.nextInt(100,400);
					abstractSeaFactory=new PlantFactory(Integer.parseInt(txfsize.getText()), rand_x, rand_y);
					if (typeComboBox.getSelectedItem().toString()=="Laminaria")
					{
						seaCreature=abstractSeaFactory.produceSeaCreature("Laminaria");
					}
					else
					{
						seaCreature=abstractSeaFactory.produceSeaCreature("Zostera");
					}
					panel.addimmobiles((Immobile)seaCreature);
					setVisible(false);
				}
			}
			else
			{
				f=new JFrame();  
				JOptionPane.showMessageDialog(f,"There are maximum 5 plants in the aquarium");  
			}
		}
		if(e.getSource() == cancel){
			setVisible(false);
		}
	}
}
