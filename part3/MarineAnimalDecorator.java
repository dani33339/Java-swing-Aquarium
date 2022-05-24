package part3;
import java.awt.*;

public class MarineAnimalDecorator implements MarineAnimal {
        protected MarineAnimal marineAnimal;
    
        public MarineAnimalDecorator(MarineAnimal marineAnimal){
            this.marineAnimal = marineAnimal;
        }
        public void PaintFish(Color col) {
            marineAnimal.PaintFish(col);
        }
}
