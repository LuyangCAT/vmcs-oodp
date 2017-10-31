package sg.edu.nus.iss.vmcs.store;

public class CashProperty extends Property {
	
	public CashProperty(PropertyLoader propertyLoader){
		super(propertyLoader);
	}
	
	public StoreItem getItem (int index) {
		System.out.print("Inside cashProperty: getItem(" + String.valueOf(index) +")\t");
		StoreItem storeItem = propertyLoader.getItem(index);
		return storeItem;
	}
	
	public void setItem(int index, StoreItem cashItem) {
		System.out.print("Inside cashProperty: setItem(" + String.valueOf(index) + ")\t");
		propertyLoader.setItem(index, cashItem);
	}
	
	public int getNumOfItems() {
		System.out.print("\nInside cashProperty: getNumOfItems()\t");
		int noOfItems = propertyLoader.getNumOfItems();
		return noOfItems;
	}
	
	public void setNumOfItems(int numItems){
		System.out.print("\nInside cashProperty: setNumOfItems(" + String.valueOf(numItems) + ")\t");
		propertyLoader.setNumOfItems(numItems);
	}
	
	public void saveProperty(){
		try{
			System.out.print("\nInside cashProperty: saveProperty()\t");
			propertyLoader.saveProperty();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
