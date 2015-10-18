package resource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class ResourcePool from package resource
 * A ResourcePool is a Resource manager
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public abstract class ResourcePool<R extends Resource> {
	//Attributes
	protected List<R> poolFree;
	protected List<R> poolUsed;
	
	//Constructor
	public ResourcePool(int n) {
		this.poolFree = new ArrayList<R> (n);
		this.poolUsed = new ArrayList<R> (n);
		for(int i = 0; i < n ; i++) {
			this.poolFree.add(createResource());
		}
	}
	
	//Methods

	protected abstract R createResource();
	
	/**
	 * Check if the pool have resource available
	 * @return true if the pool have resource available,false if not
	 */
	public boolean hasAvailableResource() {
		return !this.poolFree.isEmpty();
	}

	/**
	 * Provide a resource from the pool if there a resource available
	 * @return the resource provided,and exception if not(no resource available)
	 */
	public R provideResource() {
		if(this.hasAvailableResource()) {
			R resource = poolFree.remove(0);
			this.poolUsed.add(resource);
			return resource;
		}
		else
			throw new NoSuchElementException();
	}
	
	/**
	 * Free the resource in the pool if the resource was provided by the pool,an exception if not
	 * @param resource the resource we are freeing
	 */
	public void freeResource(R resource) {
		int indexResourceUsed = this.poolUsed.indexOf(resource);
		if(indexResourceUsed != -1) {
			this.poolUsed.remove(indexResourceUsed);
			this.poolFree.add(resource);
		}
		else 
			throw new IllegalArgumentException() ;
	}
}
