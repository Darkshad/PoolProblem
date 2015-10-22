package action;

import java.util.Stack;

public abstract class PersonAction extends Action {
	//Attributes
	protected Stack<Action> allActions = new Stack<Action>();
	boolean isReady = true;
	boolean isInitialized = false;
	String name;
	
	//Methods
	/**
	 * Push the action into the Stack
	 * @param action The action we are pushing
	 */
	public void addAction(Action action) {
		this.isInitialized = true;
		allActions.push(action);
	}
	
	/**
	 * Remove the action at the top of the Stack only if it's finished
	 */
	public void removeAction() {
		if(this.allActions.peek().isFinished()) {
			this.allActions.pop();
		}
	}
	
	/**
	 * Check if the action is ready  
	 * @return true if this action is ready,false if not
	 */
	public boolean isReady() {
		return this.isReady;
	}

	/**
	 * Check if the action is finished
	 * @return true if this action is finished,false if not
	 */
	public boolean isFinished() {
		return this.allActions.isEmpty() && this.isInitialized;
	}
	
	/**
	 * Do the real step ( do the first action of all his actions )
	 */
	public void reallyDoStep() {
		this.isReady = false;
		if(!this.isFinished()) {
			this.allActions.peek().doStep();
			this.removeAction(); // If the action is finished,we remove it
		}
	}
	
}
