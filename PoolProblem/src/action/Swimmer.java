package action;


import resource.BasketResource;
import resource.BasketPool;
import resource.CubicleResource;
import resource.CubiclePool;
import resource.ResourcefulUser;

public class Swimmer extends PersonAction {
	//Attributes
	protected ResourcefulUser<BasketResource> basketRes;
	protected ResourcefulUser<CubicleResource> cubicleRes;
	
	//Constructor
	public Swimmer(String name,BasketPool baskets,CubiclePool cubicles,int nbUndress,int nbSwim,int nbDress) {
		basketRes = new ResourcefulUser<BasketResource>(name);
		cubicleRes = new ResourcefulUser<CubicleResource>(name);
		this.addAction(new FreeResourceAction<BasketResource>(basketRes,baskets));
		this.addAction(new FreeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new ForeseebleAction(nbDress,"dressing"));
		this.addAction(new ForeseebleAction(nbSwim,"swimming"));
		this.addAction(new ForeseebleAction(nbUndress,"undress"));
		this.addAction(new TakeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new TakeResourceAction<BasketResource>(basketRes,baskets));






	}

}
