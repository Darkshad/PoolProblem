package action;

import java.util.Iterator;
import java.util.LinkedList;

public class FairScheduler extends Scheduler{

	// Attributes
	
	Iterator<Action> it;
	
	
	// Methods
	
	/**
	 * This method is used to add an action in the scheduler.
	 * @param action - the action we need to add in the scheduler.
	 */
	public void addAction(Action action){
		list_action.add(action);
		this.isInitialized = false;
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
	
	public void doStep(){
		it = list_action.iterator();
		super.doStep();
	}
	
}
