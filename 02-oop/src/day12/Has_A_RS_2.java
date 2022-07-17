package day12;

import java.time.LocalDate;

public class Has_A_RS_2 {

	public static void main(String[] args) {
		SaleRecord[] records = new SaleRecord[3];
		Product prod1 = new Product("Coffee", 3700);
		Product prod2 = new Product("Juice", 1500);
		
		records[0] = new SaleRecord(1001, prod1, 10);
		records[1] = new SaleRecord(1002, prod2, 5);
		records[2] = new SaleRecord(1003, prod1, 6);
		
		System.out.println("No.\tSale Date\tProduct\tPrice\tQty\tSubTotal");
		System.out.println("---------------------------------");
		for(SaleRecord rec : records)
			rec.showData();
	}
}

class Product{
	String name;
	int price;
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}

class SaleRecord{
	int id;
	int saleQty;
	LocalDate saleDate;
	Product product;
	public SaleRecord(int id, Product prod,int qty) {
		this.id = id;
		this.product = prod;
		this.saleQty = qty;
		this.saleDate = LocalDate.now();
	}
	void showData() {
		System.out.print(id + "\t" + saleDate + "\t");
		System.out.print(product.name + "\t" + product.price + "\t");
		System.out.print(saleQty + "\t" + (saleQty * product.price));
		System.out.println();
	}
	
}
