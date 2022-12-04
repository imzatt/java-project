package testing4;

import java.time.LocalDate;

public class Has_A_RS_2 {

	public static void main(String[] args) {
		
		SaleRecord[] data = new SaleRecord[3];
		
		var p1 = new Product ("Coffee", 3500);
		var p2 = new Product ("Juice", 2500);
		
		data[0] = new SaleRecord(10001, 10, LocalDate.now(), p1);
		data[1] = new SaleRecord(10002, 5, LocalDate.now(), p2);
		data[2] = new SaleRecord(10003, 9, LocalDate.now(), p1);
		
		System.out.println("No \tSaleDate \tProduct \tPrice Qty \tSub Total");
		System.out.println("---------------------------------");
		for(var i=0; i<data.length; i++) {
			data[i].showData();
		}
	}
}

class Product {
	
	String name;
	int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

class SaleRecord {
	
	int id;
	int saleQty;
	LocalDate saleDate;
	Product product;
	
	public SaleRecord(int id, int saleQty, LocalDate saleDate, Product product) {
		this.id = id;
		this.saleQty = saleQty;
		this.saleDate = saleDate;
		this.product = product;
	}
	
	void showData() {
		System.out.print(id + "\t");
		System.out.print(saleDate + "\t");
		System.out.print(product.name + "\t");
		System.out.print(product.price + "ks.\t");
		System.out.print(saleQty + "\t");
		System.out.print((product.price * saleQty) + "ks.\n");
	}
	
	
}