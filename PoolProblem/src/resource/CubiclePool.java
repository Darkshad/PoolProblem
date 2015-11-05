package resource;

/**
 * Class CubicletPool from the package resource
 * A CubiclePool is a cubicle administrator
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class CubiclePool extends ResourcePool<CubicleResource>{
	
	// Constructor
	
	public CubiclePool(int n) {
		super(n);
	}

	// Methods
	
	/**
	 * This method permit to create a CubicleResource.
	 */
	@Override
	protected CubicleResource createResource() {
		return new CubicleResource();
	}

	@Override
	public String getName() {
		CubicleResource c = new CubicleResource();
		return c.description();
	}

}
