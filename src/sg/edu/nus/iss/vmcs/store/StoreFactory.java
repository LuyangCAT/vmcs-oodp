package sg.edu.nus.iss.vmcs.store;

public class StoreFactory {
	
	public Store getStore(String type) {
		String typeLower = type.toLowerCase();
		switch (typeLower) {
		case "cash":
			return new CashStore();
		case "drinks":
			return new DrinksStore();
		default:
			return null;
		}
	}

}
