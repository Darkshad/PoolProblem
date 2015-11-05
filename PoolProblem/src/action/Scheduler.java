package action;

import java.util.LinkedList;

import exception.ActionFinishedException;


public abstract class Scheduler extends Action{
	
	//Attributes
	
	protected boolean isReady = true;
	protected boolean isInitialized = false;
	LinkedList<Action> list_action = new LinkedList<Action>();
	
	// Methods

	/**
	 * This method permit to know if a scheduler is in progress or not.
	 * @return true if a scheduler is initialized and in progress, false either. 
	 */
	@Override
	public boolean isInProgress(){
		return this.isInitialized && super.isInProgress();
	}
	
	/**
	 * This method permit to know if a scheduler is ready to make steps or not
	 * @return true if a scheduler is initialized and ready, false either.
	 */
	@Override
	public boolean isReady(){
		return (this.isReady && this.isInitialized);
	}
	
	/**
	 * This method permit to know if a scheduler is finished or not.
	 * It means, all of his steps are making.
	 * @return true if the scheduler hasn't more action to do, false either.
	 */
	@Override
	public boolean isFinished(){
		return (getAction().isEmpty() && !(isReady) && (isInitialized));
	}
	
	/**
	 * This method permit to execute the method doStep.
	 * A simple action is created and next the method make a doStep.
	 * Finally the method test, if the action is finished then she's removed from the scheduler. 
	 */
	@Override
	public void reallyDoStep() throws ActionFinishedException{
		Action nextAction = getNextAction();
		nextAction.doStep();
		if(nextAction.isFinished()){
			removeFinishedAction();
		}
	}
	
	/**
	 * The method doStep permit to the scheduler to make an action. 
	 */
	@Override
	public void doStep() throws ActionFinishedException{
		this.isReady = false;
		if (this.getName() != null)
			System.out.println(this.getName() + "'s turn");
		super.doStep();
	}
	

	
	protected abstract void addAction(Action action);
	protected abstract void removeFinishedAction();
	protected abstract Action getNextAction();
	protected abstract LinkedList<Action> getAction();
}
