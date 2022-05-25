package part3;
import javax.swing.*;
import part2.*;
import q3.Swimmable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JPanelDecorator extends JPanel{

    private AquaPanel aquaPanel;
    private Color col;
    private JFrame frame;   
    private JPanel panel; 
    private JPanel apply_panel; //apply panel
    private JButton btn_cancel;
    private JButton btn_apply;
    private JTable info;
    private String animalName;


    public JPanelDecorator(AquaPanel aquaPanel){
        this.aquaPanel = aquaPanel;
        this.frame = new JFrame("Decoretor");

        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());

        this.apply_panel = new JPanel();
        this.apply_panel.setLayout(new FlowLayout());

        this.btn_cancel = new JButton("Cancel");
        this.btn_apply = new JButton("Change Color");

        this.info = aquaPanel.getSwimibletable();

        this.btn_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btn_cancel)
                frame.dispose();
            }
        });

        this.btn_apply.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btn_apply){
                    frame.dispose();
                    try{
                        animalName = info.getModel().getValueAt(info.getSelectedRow(),0).toString(); //get the name of animal from selected row
                        if (animalName.equalsIgnoreCase("Name"))
                            throw new Exception();
                        selection();
                    }
                    catch(Exception exception)
                    {
                        JOptionPane.showMessageDialog(frame,"There is no object in this row please choose a row with an object");  
                    }
                }
            }
        });

        this.apply_panel.add(btn_apply);
        this.apply_panel.add(btn_cancel);

        this.panel.add(info,BorderLayout.NORTH);
        this.panel.add(apply_panel,BorderLayout.SOUTH);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * open's JColorChooser and set the new color for object
     */
    public void selection(){
        JFrame frame = new JFrame("Color Chooser:");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JColorChooser chooser = new JColorChooser();
        JButton select = new JButton("Select");
        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                col = chooser.getColor();
                for(Swimmable s : aquaPanel.getswimmables()){ 
                    if(s.getId().equalsIgnoreCase(animalName)){//Comparison with name
                        MarineAnimalDecorator objDraw=new MarineAnimalDecorator(s);
                        objDraw.PaintFish(col);  
                    }
                }
            }
        });

        panel.add(chooser, BorderLayout.NORTH);
        panel.add(select,BorderLayout.SOUTH);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
