package testing;

public class DataBaseConfig {

	// 2 static field
	static DataBaseConfig config;
	
	// 1 private Constructor
	private DataBaseConfig() {
		
	}
	
	// 3 static method to return obj
	public static DataBaseConfig getInstance() {
		if(config == null)
			config = new DataBaseConfig();
		
		return config;
	}
	
	
}
