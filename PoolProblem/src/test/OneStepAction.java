package test;
import action.*;

/**
 * Class OneStepAction from the package test
 * An action used for test (need 1 step to finish)
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class OneStepAction extends Action {
	
	protected boolean isReady = true;
	
	@Override
	public boolean isReady(){
		return isReady;
	}
	
	@Override
	public boolean isFinished(){
		return !isReady;
	}
	
	@Override
	public void reallyDoStep(){
		isReady = false;
	}

	@Override
	public String getName() {
		return null;
	}
	
}
