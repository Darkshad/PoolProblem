package action;

import resource.Resource;
import resource.ResourcePool;
import resource.ResourcefulUser;

/**
 * Class TakeResourceAction from package action
 * A TakeResourceAction is a action which will take a resource in the pool and add it in the user 
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class TakeResourceAction<R extends Resource> extends ResourcePoolAction<R> {
	
	//Constructor
	public TakeResourceAction(ResourcefulUser<R> user,ResourcePool<R> pool ) {
		this.user = user;
		this.pool = pool;
	}
	
	//Method
	/**
	 * The principal method which allow to take a resource from the pool and add it to the ResourceFulUser
	 */
	public void reallyDoStep() {
		this.isReady = false;
		System.out.println(user.getName() + " trying to take resource from the pool" + this.user.getName() + "...");
		
		if(this.pool.hasAvailableResource()) {
				this.user.setResource(this.pool.provideResource());
				this.isFinished = true;
				System.out.println("sucess\n");
			}
		else
			System.out.println("failed\n");
	}

}
