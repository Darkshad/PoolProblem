package resource;

public class CubiclePool extends ResourcePool<CubicleResource>{
	public CubiclePool(int n) {
		super(n);
	}

	@Override
	protected CubicleResource createResource() {
		return new CubicleResource();
	}

}
