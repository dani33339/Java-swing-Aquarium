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
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class  AddDuplicateAnimal:
 * JDialog that Duplicate an animal
 * 
 * @author Daniel Markov ,Anton Volkov 
 */
public class AddDuplicateAnimal extends JDialog implements ActionListener{
	
	public JFrame f;  
	private JPanel p1,p2; 
    private JButton select, cancel;
    private AquaPanel panel;
    JTable info;


	/**
	* this method is a constructor method to build a new AddDuplicateAnimal.
    * @param AquaFrame -AquaFrame of the parent
    * @param pan - AquaPanel parent
	* @param title - title of the AddAnimalDialog
	*/
	public AddDuplicateAnimal(AquaFrame parent, AquaPanel panel, String title)
	{
		super((AquaFrame)parent,title,true);
    	this.panel = panel;

    	setSize(600,400);
	
		setBackground(new Color(100,230,255));
		p1 = new JPanel(); // selections
		p2 = new JPanel(); //add and cencel
	
		p1.setLayout(new BorderLayout());
		info=panel.getSwimibletable();
		p1.add(info);
		
		p2.setLayout(new GridLayout(1,2,5,5));
		select=new JButton("select");
		select.addActionListener(this);
		select.setBackground(Color.lightGray);
		p2.add(select);		
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setBackground(Color.lightGray);
		p2.add(cancel);
		setLayout(new BorderLayout());
		add("North" , p1);
		add("South" , p2);
  
    }

	
	/** 
	 * Perform the action selected (duplicate or cencel)
	 * @param e
	 */
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == select){
			try{
				String name = info.getModel().getValueAt(info.getSelectedRow(),0).toString(); //get the name of animal from selected row
				if (name.equalsIgnoreCase("Name"))
					throw new Exception();
				for(Swimmable s : panel.getswimmables()){ //run over swimmables hashset
					if(s.getId().equalsIgnoreCase(name)){ //Comparison with name
						Swimmable clone = s.clone(); //clone
						panel.addswimmables(clone); 
						if (JOptionPane.showConfirmDialog(null, s.getId()+ "duplicated,do you want to edit the animal?", "Edit Message",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { //if user want's to edit
							p1.setVisible(false);
							p2.setVisible(false);
							editAnimal(clone);
						}
						else
						{
						this.setVisible(false);
						}
					break;
					}
				}
			}
			catch(Exception exception)
			{
				JOptionPane.showMessageDialog(f,"There is no object in this row please choose a row with an object");  
			}
		}
		if(e.getSource() == cancel){
			setVisible(false);
			this.dispose();
		}
	}

	/** 
	 * edit the animal 
	 * @Swimmable s
	 */
	public void editAnimal (Swimmable s)
	{
		JPanel p3,p4;
		JButton update, cancel;
		JLabel lbl_size, lbl_Horizontal, lbl_Vertical, lbl_color;
		JComboBox <String> colorComboBox;
		JTextField txfsize;
		JSlider sl_Horizontal, s2_Vertical;

		p3 = new JPanel(); // selections
		p4 = new JPanel(); //add and cencel
	
		p3.setLayout(new GridLayout(6,1,10,5));
		lbl_size = new JLabel("Animal size from 20 to 320:",JLabel.CENTER);
		lbl_Horizontal = new JLabel("Horizontal speed:",JLabel.CENTER);
		lbl_Vertical = new JLabel("Vertical speed:",JLabel.CENTER);
		lbl_color = new JLabel("Color of the animal:",JLabel.CENTER);

		/*JTextField for animal size */
		p3.add(lbl_size);
		txfsize = new JTextField();
		p3.add(txfsize);

		/*slider for Horizontal speed  */
		p3.add(lbl_Horizontal);
		sl_Horizontal = new JSlider(1,10);
		sl_Horizontal.setMajorTickSpacing(1);
		sl_Horizontal.setMinorTickSpacing(1);
		sl_Horizontal.setPaintTicks(true);
		sl_Horizontal.setPaintLabels(true);
		p3.add(sl_Horizontal);

		/*slider for Vertical speed  */
		p3.add(lbl_Vertical);
		s2_Vertical = new JSlider(1,10);
		s2_Vertical.setMajorTickSpacing(1);
		s2_Vertical.setMinorTickSpacing(1);
		s2_Vertical.setPaintTicks(true);
		s2_Vertical.setPaintLabels(true);
		p3.add(s2_Vertical);

		p3.add(lbl_color);
		String s2[] = { "Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow" ,"Magenta", "Pink"};
		colorComboBox = new JComboBox<String> (s2);
		p3.add(colorComboBox);
		
		p4.setLayout(new GridLayout(1,2,5,5));
		update=new JButton("Update");
		update.setBackground(Color.lightGray);
		p4.add(update);		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.lightGray);
		p4.add(cancel);
		
		setLayout(new BorderLayout());
		add("North" , p3);
		add("South" , p4);

		//update the animmal with the given values
		update.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == update)
				{
					if (txfsize.getText().isBlank()|| Integer.parseInt(txfsize.getText())>320 || Integer.parseInt(txfsize.getText())<20)
					{
						JOptionPane.showMessageDialog(f,"The size have to be from 20 to 320");  
					}
					else
					{
						// convert color in colorbox to a color number 1-9
						Color color = Color.black;
						switch (colorComboBox.getSelectedItem().toString()) {
							case "Black":
								color =Color.black;
								break;
							case "Red":
								color= Color.red;
								break;

							case "Blue":
								color= Color.blue;
								break;

							case "Green":
								color= Color.green;
								break;

							case "Cyan":
								color= Color.cyan;
								break;

							case "Orange":
								color= Color.orange;
								break;

							case "Yellow":
								color= Color.yellow;
								break;

							case "Magenta":
								color= Color.magenta;
								break;

							case "Pink":
								color=	Color.pink;
								break;

						}
						s.edit(Integer.parseInt(txfsize.getText()),sl_Horizontal.getValue(), s2_Vertical.getValue(),color);
						setVisible(false);
					}
				}
				if(e.getSource() == cancel){
					setVisible(false);
				}
			}
		});
		
	}
}



