package action;

import resource.Resource;
import resource.ResourcePool;
import resource.ResourcefulUser;

/**
 * Class ResourcePoolAction from package action
 * A ResourcePoolAction is a action for ResourcePool
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public abstract class ResourcePoolAction<R extends Resource> extends Action {
	//Attribute
	protected boolean isReady = true;
	protected boolean isFinished = false;
	protected ResourcePool<R> pool;
	protected ResourcefulUser<R> user;
	
	//Methods
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
		return this.isFinished;
	}
	

	
}
