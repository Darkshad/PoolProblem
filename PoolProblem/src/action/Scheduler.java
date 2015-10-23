package action;

import java.util.LinkedList;


public abstract class Scheduler extends Action{
	
	//Attributes
	
	protected boolean isReady = true;
	protected boolean isInitialized = false;
	LinkedList<Action> list_action = new LinkedList<Action>();
	
	// Methods

	@Override
	public boolean isInProgress(){
		return this.isInitialized && super.isInProgress();
	}
	
	@Override
	public boolean isReady(){
		return (this.isReady && this.isInitialized);
	}
	
	@Override
	public boolean isFinished(){
		return (getAction().isEmpty() && !(isReady) && (isInitialized));
	}
	
	@Override
	public void reallyDoStep(){
		Action nextAction = getNextAction();
		nextAction.doStep();
		if(nextAction.isFinished()){
			removeFinishedAction();
		}
	}
	
	@Override
	public void doStep(){
		this.isReady = false;
		super.doStep();
	}
	
	protected abstract void addAction(Action action);
	protected abstract void removeFinishedAction();
	protected abstract Action getNextAction();
	protected abstract LinkedList<Action> getAction();
}
