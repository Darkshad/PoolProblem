package resource;

public class ResourcefulUser<R extends Resource> {
	//Attribute
	protected R resource;
	
	//Methods
	public R getResource() {
		return this.resource;
	}

	public void setResource(R resource) {
		this.resource = resource;
	}
	
	public void resetResource() {
		this.resource = null;
	}
}
