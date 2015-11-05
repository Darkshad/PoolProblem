package resource;

/**
 * Class CubiclePool from package resource.
 * It represent a resource pool of type cubicle.
 * @author Guyot Clement - Cornaire Francis
 *
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
