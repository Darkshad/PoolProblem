package action;

import java.util.LinkedList;

public class SequentialScheduler extends Scheduler {

	@Override
	public void addAction(Action action) {
		this.isInitialized = true;
		this.list_action.add(action);
		
	}

	@Override
	public void removeFinishedAction() {
		this.list_action.remove(0);
		
	}

	@Override
	public Action getNextAction() {
		return this.list_action.get(0);
	}

	@Override
	public LinkedList<Action> getAction() {
		return this.list_action;
	}

	@Override
	public String getName() {
		return null;
	}


}
