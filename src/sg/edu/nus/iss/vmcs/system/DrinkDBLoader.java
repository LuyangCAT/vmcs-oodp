package sg.edu.nus.iss.vmcs.system;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.DrinksStoreItem;
import sg.edu.nus.iss.vmcs.store.StoreItem;

public class DrinkDBLoader extends DBPropertyLoader {
	
	private static final String NAME_LABEL     = "Name";
	private static final String PRICE_LABEL    = "Price";
	private static final String QUANTITY_LABEL = "Quantity";
	
	public DrinkDBLoader(String filen) {
		super(filen);
	}

	public StoreItem getItem(int index) {
		System.out.print("Inside DrinkDBLoader: getItem(" + String.valueOf(index) + ")\n");
		int idx = index + 1;
		DrinksBrand brand = new DrinksBrand();

		String name = new String(NAME_LABEL + idx);
		String value = getValue(name);
		brand.setName(value);

		name = new String(PRICE_LABEL + idx);
		value = getValue(name);
		brand.setPrice(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = getValue(name);
		int qty = Integer.parseInt(value);

		DrinksStoreItem item = new DrinksStoreItem(brand, qty);
		return item;

	}

	public void setItem(int index, StoreItem drinksItem) {
		System.out.print("Inside DrinkDBLoader: setItem(" + String.valueOf(index) + ", drinksStoreItem)\n");
		int idx = index + 1;

		DrinksStoreItem item = (DrinksStoreItem) drinksItem;
		DrinksBrand brand = (DrinksBrand) item.getContent();
		String itn = new String(NAME_LABEL + idx);
		setValue(itn, brand.getName());

		itn = new String(PRICE_LABEL + idx);
		setValue(itn, String.valueOf(brand.getPrice()));

		itn = new String(QUANTITY_LABEL + idx);
		setValue(itn, String.valueOf(item.getQuantity()));
	}
}
