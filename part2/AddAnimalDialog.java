package part2;
import q3.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class  AddAnimalDialog:
 * JDialog that add's a fish
 * 
 * @author Daniel Markov ,Anton Volkov 
 */
public class AddAnimalDialog extends JDialog  implements ActionListener {
	public JFrame f;  
	private static final long serialVersionUID = 1L;
	private JPanel p1,p2;
    private JButton add, cancel;
    private JLabel lbl_type, lbl_size, lbl_Horizontal, lbl_Vertical, lbl_color;
	private JComboBox typeComboBox,colorComboBox;
	private JTextField txfsize;
    private JSlider sl_Horizontal, s2_Vertical;
    private AquaPanel panel;
 
	/**
	* this method is a constructor method to build a new AddAnimalDialog .
    * @param AquaFrame -AquaFrame of the parent
    * @param pan - AquaPanel parent
	* @param title - title of the AddAnimalDialog
	*/
    public AddAnimalDialog(AquaFrame parent, AquaPanel pan, String title) {
    	super((AquaFrame)parent,title,true);
    	panel = pan;

    	setSize(600,400);
	
		setBackground(new Color(100,230,255));
		p1 = new JPanel(); // selections
		p2 = new JPanel(); //add and cencel
	
		p1.setLayout(new GridLayout(6,1,10,5));
		lbl_type = new JLabel("Animal type:",JLabel.CENTER);
		lbl_size = new JLabel("Animal size from 20 to 320:",JLabel.CENTER);
		lbl_Horizontal = new JLabel("Horizontal speed:",JLabel.CENTER);
		lbl_Vertical = new JLabel("Vertical speed:",JLabel.CENTER);
		lbl_color = new JLabel("Color of the animal:",JLabel.CENTER);

		/*JComboBox for animal type */
		p1.add(lbl_type);
		String s1[] = { "Fish", "Jellyfish" };
		typeComboBox = new JComboBox(s1);
		p1.add(typeComboBox);

		/*JTextField for animal size */
		p1.add(lbl_size);
		txfsize = new JTextField();
		p1.add(txfsize);

		/*slider for Horizontal speed  */
		p1.add(lbl_Horizontal);
		sl_Horizontal = new JSlider(1,10);
		sl_Horizontal.setMajorTickSpacing(1);
		sl_Horizontal.setMinorTickSpacing(1);
		sl_Horizontal.setPaintTicks(true);
		sl_Horizontal.setPaintLabels(true);
		p1.add(sl_Horizontal);

		/*slider for Vertical speed  */
		p1.add(lbl_Vertical);
		s2_Vertical = new JSlider(1,10);
		s2_Vertical.setMajorTickSpacing(1);
		s2_Vertical.setMinorTickSpacing(1);
		s2_Vertical.setPaintTicks(true);
		s2_Vertical.setPaintLabels(true);
		p1.add(s2_Vertical);

		p1.add(lbl_color);
		String s2[] = { "Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow" ,"Magenta", "Pink"};
		colorComboBox = new JComboBox(s2);
		p1.add(colorComboBox);
		
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
	 * Perform the action selected (add or cencel)
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add){
			if(panel.getswimmablessize()<5){
				if (Integer.parseInt(txfsize.getText())>=20 && Integer.parseInt(txfsize.getText())<=320)
					if (typeComboBox.getSelectedItem().toString()=="Fish")
					{
						Fish fish=new Fish(Integer.parseInt(txfsize.getText()), 600, 400,sl_Horizontal.getValue(), s2_Vertical.getValue(), this.getColorint());
						panel.addswimmables(fish);
						setVisible(false);
					}
					else
					{
						
						Jellyfish Jellyfish=new Jellyfish(Integer.parseInt(txfsize.getText()), 600, 400,sl_Horizontal.getValue(), s2_Vertical.getValue(), this.getColorint());
						panel.addswimmables(Jellyfish);
						setVisible(false);
					}
				
				else{
					f=new JFrame();  
					JOptionPane.showMessageDialog(f,"The size have to be from 20 to 320");  
				}
			}
			else
			{
				f=new JFrame();  
				JOptionPane.showMessageDialog(f,"There are maximum 5 animal in the aquarium");  
			}
		}
		if(e.getSource() == cancel){
			setVisible(false);
		}
	}
}