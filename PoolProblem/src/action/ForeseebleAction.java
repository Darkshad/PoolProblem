package action;

/**
 * Class ForeseebleAction from package action
 * A foreseebleAction is a action which need a certain number call of the method doStep to finish it
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class ForeseebleAction extends Action{
	//Attribute
	protected int totalTime;
	protected int currentTime;
	protected String name;

	//Constructor
	public ForeseebleAction(int totalT,String name) {
		this.totalTime = totalT;
		this.currentTime = totalT;
		this.name = name;
	}
	
	//Methods
	/**
	 * Check if the action is ready  
	 * @return true if this action is ready,false if not
	 */
	public boolean isReady() {
		return this.totalTime == this.currentTime;
	}
	
	/**
	 * Check if the action is in progress
	 * @return true if this action is in progress,false if not
	 */
	public boolean isInProgress() {
		return this.totalTime > this.currentTime;
	}
	
	/**
	 * Check if the action is finished
	 * @return true if this action is finished,false if not
	 */
	public boolean isFinished() {
		return this.currentTime == 0;
	}
	
	/**
	 * The principal method which allow to pass through the state ready,in progress and finished 
	 */
	public void reallyDoStep() {
		this.currentTime = this.currentTime--;
	}
	
	/**
	 * Show the statue of this action
	 */
	public String toString() {
		return (this.name + "(" + this.currentTime + "/" + this.totalTime + ")" );
	}
}
