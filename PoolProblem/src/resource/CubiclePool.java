package resource;

public class CubiclePool extends ResourcePool<CubicleResource>{
	public CubiclePool(int n) {
		super(n);
	}

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
