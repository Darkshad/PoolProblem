package action;

import java.util.Iterator;
import java.util.LinkedList;

import exception.ActionFinishedException;

public class FairScheduler extends Scheduler{

	// Attributes
	
	Iterator<Action> it = null;
	
	// Methods
	
	/**
	 * This method is used to add an action in the scheduler.
	 * @param action - the action we need to add in the scheduler.
	 */
	public void addAction(Action action){
		list_action.add(action);
		this.isInitialized = true;
	}
	
	/**
	 * This method is used to remove from the scheduler a finished action.
	 */
	public void removeFinishedAction(){
		this.it.remove();	
	}
	
	/**
	 * This method is used to get the next action from the scheduler.
	 * @return - It returns the next action. 
	 */
	public Action getNextAction(){
		if (it.hasNext()) 
			return it.next();
		else{
			it = list_action.iterator();
			return it.next();
		}
	}
	
	/**
	 * This method is used to get the list of all the actions from the scheduler.
	 * @return - It returns a list of action.
	 */
	public LinkedList<Action> getAction(){
		return this.list_action;
	}
	
	/**
	 * This method is used to make a step of an action.
	 */
	public void doStep() throws ActionFinishedException{
		if (this.it == null)
			it = list_action.iterator();
		super.doStep();
	}

	@Override
	public String getName() {
		return null;
	}

}
