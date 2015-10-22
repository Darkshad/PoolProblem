package action;

import resource.Resource;
import resource.ResourcePool;
import resource.ResourcefulUser;

/**
 * Class FreeResourceAction from package action
 * A FreeResourceAction is a action which will free the resource in the user 
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class FreeResourceAction<R extends Resource> extends ResourcePoolAction<R> {
	//Constructor
	public FreeResourceAction(ResourcefulUser<R> user,ResourcePool<R> pool ) {
		this.user = user;
		this.pool = pool;
	}
	
	//Method
	/**
	 * The principal method which allow to free a resource from the ResourcefulUser
	 * the resource we are freeing need to be in the pool
	 */
	public void reallyDoStep() {
		this.isReady = false;
		System.out.println(this.user.getName() + " freeing resource from the pool");
		this.pool.freeResource(this.user.getResource());
		this.user.resetResource();
		
		this.isFinished = true;

	}
	
}
