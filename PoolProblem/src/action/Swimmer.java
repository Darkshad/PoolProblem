package action;


import resource.BasketResource;
import resource.BasketPool;
import resource.CubicleResource;
import resource.CubiclePool;
import resource.ResourcefulUser;

public class Swimmer extends SequentialScheduler {
	//Attributes
	protected ResourcefulUser<BasketResource> basketRes;
	protected ResourcefulUser<CubicleResource> cubicleRes;
	
	//Constructor
	public Swimmer(String name,BasketPool baskets,CubiclePool cubicles,int nbUndress,int nbSwim,int nbDress) {
		basketRes = new ResourcefulUser<BasketResource>(name);
		cubicleRes = new ResourcefulUser<CubicleResource>(name);
		this.addAction(new TakeResourceAction<BasketResource>(basketRes,baskets));
		this.addAction(new TakeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new ForeseebleAction(nbUndress,"undress",name));
		this.addAction(new FreeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new ForeseebleAction(nbSwim,"swimming",name));
		this.addAction(new TakeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new ForeseebleAction(nbDress,"dressing",name));
		this.addAction(new FreeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new FreeResourceAction<BasketResource>(basketRes,baskets));
	}
	
	public String getName() {
		return this.basketRes.getName();
	}

}
