package sg.edu.nus.iss.vmcs.store;

public class DrinkProperty extends Property {

	public DrinkProperty(PropertyLoader propertyLoader){
		super(propertyLoader);
	}
	
	public StoreItem getItem (int index) {
		System.out.print("Inside DrinkProperty: getItem(" + String.valueOf(index) + ")\t");
		StoreItem storeItem = propertyLoader.getItem(index);
		return storeItem;
	}
	
	public void setItem(int index, StoreItem drinkItem) {
		System.out.print("Inside DrinkProperty: setItem(" + String.valueOf(index) + ", drinkItem)\t");
		propertyLoader.setItem(index, drinkItem);
	}
	
	public int getNumOfItems() {
		System.out.print("\nInside DrinkProperty: getNumOfItems()\t");
		int noOfItems = propertyLoader.getNumOfItems();
		return noOfItems;
	}
	
	public void setNumOfItems(int numItems){
		System.out.print("\nInside DrinkProperty: setNumOfItems(" + String.valueOf(numItems) + ")\t");
		propertyLoader.setNumOfItems(numItems);
	}
	
	public void saveProperty(){
		System.out.print("\nInside DrinkProperty: saveProperty()\t");
		try{
			propertyLoader.saveProperty();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
