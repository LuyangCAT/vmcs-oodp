package sg.edu.nus.iss.vmcs.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import sg.edu.nus.iss.vmcs.store.PropertyLoader;
import sg.edu.nus.iss.vmcs.store.StoreItem;

/*
 * DBPropertyLoader -  The class is abstract for further implementation. Currently the persistent values are from Files, 
 * could be alternatively implemented by DB SQL Queries
 */
public abstract class DBPropertyLoader implements PropertyLoader {
	private static final String PROP_NUM_ITEMS = "NumOfItems";

	private Properties prop;
	private String fileName;
	
	public DBPropertyLoader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void initialize() throws IOException {
		prop = new Properties(System.getProperties());
		FileInputStream stream = new FileInputStream(fileName);
		prop.load(stream);
		stream.close();
	}

	@Override
	public void saveProperty() throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		prop.store(stream, "");
		stream.close();
	}

	@Override
	public int getNumOfItems() {
		System.out.print("Inside DBPropertyLoader: getNumOfItems()\n");
		String nm = prop.getProperty(PROP_NUM_ITEMS);
		int nmi;
		nmi = Integer.parseInt(nm);
		return nmi;
	}
	

	@Override
	public void setNumOfItems(int vl) {
		System.out.print("Inside DBPropertyLoader: setNumOfItems(" + String.valueOf(vl) + ")\n");
		prop.setProperty(PROP_NUM_ITEMS, String.valueOf(vl));
	}

	@Override
	abstract public StoreItem getItem(int index);

	@Override
	abstract public void setItem(int index, StoreItem item) ;
	
	public String getValue(String key) {
		return prop.getProperty(key);
	}
	
	public void setValue(String key, String value) {
		prop.setProperty(key, value);
	}
}
