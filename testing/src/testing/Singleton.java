package testing;

import java.sql.DatabaseMetaData;

public class Singleton {

	public static void main(String[] args) {
		DataBaseConfig obj = DataBaseConfig.getInstance();
		System.out.println(obj);
		
		DataBaseConfig obj2 = DataBaseConfig.getInstance();
		System.out.println(obj2);
	}
}
