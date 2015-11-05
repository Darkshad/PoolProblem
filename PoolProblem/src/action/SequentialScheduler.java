package action;

import java.util.LinkedList;

/**
 * Class SequentialScheduler from package action.
 * A SequentialScheduler is a scheduler which make his step sequentially
 * @author Guyot Clement - Cornaire Francis
 *	Licence 3 Miage - 2015/206.
 */
public class SequentialScheduler extends Scheduler {

	/**
	 * This method permit to add an action in the scheduler.
	 */
	@Override
	public void addAction(Action action) {
		this.isInitialized = true;
		this.list_action.add(action);
		
	}

	/**
	 * This method permit to delete an action from the scheduler.
	 */
	@Override
	public void removeFinishedAction() {
		this.list_action.remove(0);
		
	}

	/**
	 * This method permit to get the next action in the scheduler.
	 * @return the next action from the scheduler.
	 */
	@Override
	public Action getNextAction() {
		return this.list_action.get(0);
	}

	/**
	 * This method permit to get the list of actions from the scheduler.
	 * @return the list of action.
	 */
	@Override
	public LinkedList<Action> getAction() {
		return this.list_action;
	}

	@Override
	public String getName() {
		return null;
	}


}
