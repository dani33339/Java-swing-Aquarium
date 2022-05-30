package part3;
import q3.Swimmable;

/**
 * class Satiated:
 * State design pattern
 * class Satiated implements HungerState have a mthod doAction that set's the state to the animal
 * 
 * @author Daniel Markov ,Anton Volkov
 */

public class Satiated implements HungerState {

    /** 
     * set the state for the animal
     * @param s
     */
    public void doAction(Swimmable s) {
        s.setHungeryState(this);     
    }

    /** 
     * return name of the state
     * @return String
     */
    public String toString(){
		return "Satiated";
	}
}