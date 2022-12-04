package testing4;

public class Demo {

	public static void main(String[] args) {
		
		Button btn1 = new Button("btn-login");
		Button btn2 = new Button("btn-logout");
		
		btn1.display();
		btn1.onClick();
		btn1.onDoubleClick();
		
		System.out.println();
		
		btn2.onClick();
		btn2.onDoubleClick();
	}
}
