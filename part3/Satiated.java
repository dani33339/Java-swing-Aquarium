package part3;

import q3.Swimmable;

public class Satiated implements HungerState {

    public void doAction(Swimmable objSwim) {
		objSwim.setHungery(this);
	}
}
