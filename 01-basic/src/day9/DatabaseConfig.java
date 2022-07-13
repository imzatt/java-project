package day9;

public class DatabaseConfig {

	//2 static field
	static DatabaseConfig config;
	
	//1 private Constructor
	private DatabaseConfig() {
		
	}
	
	//3 static method to return obj
	public static DatabaseConfig getInstance() {
		if(config == null)
			config = new DatabaseConfig();
		return config;
	}
}
