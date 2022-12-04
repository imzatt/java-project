package testing3;

public class Abstraction {

	public static void main(String[] args) {
		
		DatabaseUtli db_utli = new ProductService();
		
		db_utli.insert();
		
		ProductService p_service = new ProductService();
		
		p_service.connectDatabase();
		p_service.insert();
		p_service.update();
		p_service.delete(1001);
		p_service.findById(1002);
			
	}
}
