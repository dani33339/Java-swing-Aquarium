package part3;

import q3.*;
/**
 * interface HungerState:
 * State design pattern
 * interface Satiated implements HungerState have a mthod doAction that set's the state to the animal
 * 
 * @author Daniel Markov ,Anton Volkov
 */
public interface HungerState {
    public void doAction(Swimmable obj);
}
