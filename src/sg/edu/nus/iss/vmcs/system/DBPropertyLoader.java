package sg.edu.nus.iss.vmcs.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialize() throws IOException {
		prop = new Properties(System.getProperties());
		FileInputStream stream = new FileInputStream(fileName);
		prop.load(stream);
		stream.close();
	}

	public void saveProperty() throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		prop.store(stream, "");
		stream.close();
	}

	public int getNumOfItems() {
		System.out.print("Inside DBPropertyLoader: getNumOfItems()\n\n");
		String nm = prop.getProperty(PROP_NUM_ITEMS);
		int nmi;
		nmi = Integer.parseInt(nm);
		return nmi;
	}
	
	public void setNumOfItems(int vl) {
		System.out.print("Inside DBPropertyLoader: setNumOfItems(" + String.valueOf(vl) + ")\n\n");
		prop.setProperty(PROP_NUM_ITEMS, String.valueOf(vl));
	}

	abstract public StoreItem getItem(int index);

	abstract public void setItem(int index, StoreItem item) ;
	
	public String getValue(String key) {
		return prop.getProperty(key);
	}
	
	public void setValue(String key, String value) {
		prop.setProperty(key, value);
	}
}
