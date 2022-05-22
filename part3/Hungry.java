package part3;
import q3.Swimmable;

	
public class Hungry implements HungerState {

   public String toString(){
      return "Hungry";
   }

   public void doAction(Swimmable objSwim) {
      objSwim.setHungery(this);
   }
}