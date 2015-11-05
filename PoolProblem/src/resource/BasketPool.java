package resource;

/**
 * Class BasketPool from the package resource
 * A BasketPool is a basket administrator
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class BasketPool extends ResourcePool<BasketResource>{
	
	/**
	 * This method permit to create a BasketPool. 
	 * @param n- The number of basket available.  
	 */
	public BasketPool(int n) {
		super(n);
	}

	/**
	 * This method permit to create a resource of type basket.
	 */
	@Override
	protected BasketResource createResource() {
		return new BasketResource();
	}
	
	/**
	 * This method permit to get the name of the resource.
	 * It will print "basket"
	 */
	@Override
	public String getName() {
		BasketResource b = new BasketResource();
		return b.description();
	}

}
