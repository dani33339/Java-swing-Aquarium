import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlantFactory implements AbstractSeaFactory{

    public SeaCreature produceSeaCreature(String type) {
        Immobile obj = null;

        if("Laminaria".equalsIgnoreCase(type)){
            /*
             *  Return new Laminaria
             */
            obj = new Laminaria();
        }
        if("Zostera".equalsIgnoreCase(type)){
            /*
             *  Return new Jelly Zostera
             */
            obj = new Zostera();
        }
        return obj;
    }
}
