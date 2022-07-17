package day8;

public class Phone_Demo {

	public static void main(String[] args) {
		
		//creating object
		Phone phone1 = new Phone("iPhone", 1500000, "purple");
		Phone phone2 = new Phone("Samsung", 1300000, "white");
		Phone phone3 = new Phone("Vivo", 100000, "black");
		
		System.out.println("------- Phone 1's Info --------\n");
		System.out.println("Brand: " + phone1.brand);
		System.out.println("Color: " + phone1.color);
		System.out.println("Brand: " + phone1.price + " ks.");
		
		phone1.call();
		phone1.sendSms();
		System.out.println();
		
		System.out.println("------- Phone 2's Info --------\n");
		System.out.println("Brand: " + phone2.brand);
		System.out.println("Color: " + phone2.color);
		System.out.println("Brand: " + phone2.price + " ks.");
		
		phone1.call();
		phone1.sendSms();
		System.out.println();
		
		System.out.println("------- Phone 3's Info --------\n");
		System.out.println("Brand: " + phone3.brand);
		System.out.println("Color: " + phone3.color);
		System.out.println("Brand: " + phone3.price + " ks.");
		
		phone1.call();
		phone1.sendSms();
		
		Phone.shop = "ABC";
		System.out.println("Phone 2's shop name : " + Phone.shop);
	}
	
}
