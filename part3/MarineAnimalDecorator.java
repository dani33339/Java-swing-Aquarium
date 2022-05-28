package part3;
import java.awt.*;

/**
 * class MarineAnimalDecorator:
 * class MarineAnimalDecorator design pattern Decorator
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class MarineAnimalDecorator implements MarineAnimal {
        protected MarineAnimal marineAnimal;
    
        public MarineAnimalDecorator(MarineAnimal marineAnimal){
            this.marineAnimal = marineAnimal;
        }
        
        /** 
         * chang's the animal color
         * @param col
         */
        public void PaintFish(Color col) {
            marineAnimal.PaintFish(col);
        }
}
