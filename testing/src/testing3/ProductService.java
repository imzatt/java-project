package testing3;

public class ProductService extends DatabaseUtli{

	@Override
	public void insert() {
		System.out.println("insert into product");
		
	}

	@Override
	public void update() {
		System.out.println("update product update");
		
	}

	@Override
	public boolean delete(int id) {
		System.out.println("delete from product where id = " + id);
		return false;
	}

	@Override
	public Object findById(int id) {
		System.out.println("select * from product wher id = " + id);
		return null;
	}

	
}
