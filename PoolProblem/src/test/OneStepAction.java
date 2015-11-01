package test;
import action.*;

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
	
	// coucou test 
}
