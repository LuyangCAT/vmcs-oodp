package sg.edu.nus.iss.vmcs.system;

import sg.edu.nus.iss.vmcs.store.CashStoreItem;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.StoreItem;

public class CashDBLoader extends DBPropertyLoader {
	private static final String NAME_LABEL     = "Name";
	private static final String WEIGHT_LABEL   = "Weight";
	private static final String VALUE_LABEL    = "Value";
	private static final String QUANTITY_LABEL = "Quantity";
	
	public CashDBLoader(String filen) {
		super(filen);
	}

	public StoreItem getItem (int index) {
		System.out.print("Inside CashDBLoader: getItem(" + String.valueOf(index) +")\n");
		int idx = index + 1;
		Coin coin = new Coin();

		String name = new String(NAME_LABEL + idx);
		String value = getValue(name);
		coin.setName(value);

		name = new String(WEIGHT_LABEL + idx);
		value = getValue(name);
		coin.setWeight(Double.parseDouble(value));

		name = new String(VALUE_LABEL + idx);
		value = getValue(name);
		coin.setValue(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = getValue(name);
		int qty = Integer.parseInt(value);

		CashStoreItem item = new CashStoreItem(coin, qty);
		return item;
	}

	public void setItem(int index, StoreItem cashItem) {
		System.out.print("Inside CashDBLoader: setItem(" + String.valueOf(index) + ", cashStoreItem)\n");
		int idx = index + 1;

		CashStoreItem item = (CashStoreItem) cashItem;
		Coin cn = (Coin) item.getContent();
		String itn = new String(NAME_LABEL + idx);

		setValue(itn, cn.getName());

		itn = new String(WEIGHT_LABEL + idx);
		setValue(itn, String.valueOf(cn.getWeight()));

		itn = new String(VALUE_LABEL + idx);
		setValue(itn, String.valueOf(cn.getValue()));

		itn = new String(QUANTITY_LABEL + idx);
		setValue(itn, String.valueOf(item.getQuantity()));
	}
}
