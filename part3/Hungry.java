package part3;
import q3.*;

/**
 * class Hungry:
 * State design pattern
 * class Hungry implements HungerState have a mthod doAction that set's the state to the animal
 * 
 * @author Daniel Markov ,Anton Volkov
 */
public class Hungry implements HungerState{
    
    /** 
     * set's the hunger state to the Swimmable
     * @param s
     */
    public void doAction(Swimmable s) {
        s.setHungeryState(this);
    }

}