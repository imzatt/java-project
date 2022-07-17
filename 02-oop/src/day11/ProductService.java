package day11;

public class ProductService extends DatabaseUtil{

	@Override
	public void insert() {
		System.out.println("insert into product");
		
	}

	@Override
	public void update() {
		System.out.println("update product table");
		
	}

	@Override
	public boolean delete(int id) {
		System.out.println("delete from product where id = " + id);
		return false;
	}

	@Override
	public Object findById(int id) {
		System.out.println("select * from product where id = " + id);
		return null;
	}

}
