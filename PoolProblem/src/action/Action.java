package action;

/** Class Action of the package action
 * 	The class represent an action.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016.
 */
public abstract class Action {

	// Methods
	
	/**
	 * This method permit to know if an action is ready to be executed or not.
	 * @return true if the action is ready, false either.
	 */
	public abstract boolean isReady();
	
	
	/**
	 * This method permit to know if an action is in progress,
	 * it mean the action was not ready because a doStep was make but the action is not finished. 
	 * @return true if an action is in progress, false either.
	 */
	public boolean isInProgress(){
		return !isReady() && !isFinished();
	}
	
	/**
	 * This method permit to know if an action is finished or not,
	 * It mean the action make all the step she had to do.
	 * @return true if the action is finished, false either.
	 */
	public abstract boolean isFinished();
	
	
	/**
	 * This method permit to execute a step of an action.
	 * When the action is not finished the method call the method reallyDoStep
	 */
	public void doStep(){
		if(!isFinished())
			reallyDoStep();
	}
	
	/**
	 * This method permit to check if the doStep works good.
	 * A verifier !!!!!!!!!!!
	 */
	public abstract void reallyDoStep();
}
