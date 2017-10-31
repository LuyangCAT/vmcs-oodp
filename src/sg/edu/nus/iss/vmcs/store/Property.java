package sg.edu.nus.iss.vmcs.store;

public abstract class Property {
	PropertyLoader propertyLoader;
	
	public  Property(PropertyLoader propertyLoader){
		this.propertyLoader = propertyLoader;
	}
	
	public PropertyLoader getLoader(){
		return propertyLoader;
	}
	
	public void setLoader(PropertyLoader propertyLoader) {
		this.propertyLoader = propertyLoader;
	}
	
	public abstract StoreItem getItem (int index);
	
	public abstract void setItem(int index, StoreItem cashItem);
	
	public abstract int getNumOfItems();
	
	public abstract void setNumOfItems(int numItems);
	
	public abstract void saveProperty();
	
}
