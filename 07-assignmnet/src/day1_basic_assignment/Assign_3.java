package day1_basic_assignment;

import java.util.Scanner;

public class Assign_3 {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int index = -1;
		int indexc = -1;
		double getcost;
		
		String [] brands = {"lenovo","hp","samsung","acer","dell","asus"};
		String [] Cpu = {"core i3","core i5","core i7","core i9"};
		double [][] costs = {
				{230.21, 400.21, 294.2, 693.33, 340.44, 691.99},
				{529.483, 920.483, 676.66, 1594.65, 783.012, 1591.577},
				{552.504, 960.504, 706.08, 1663.99, 817.056, 1660.776},
				{690.63, 1200.63, 882.6, 2079.99, 1021.32, 2075.97}
		};
		
		// output
		for(String value: brands) {
			System.out.print("\t\t" + value);
		}
		System.out.print("\n");
		
		for(var r=0;r<4;r++) {
			System.out.print(Cpu[r] + "\t\t");
			for(var c=0;c<6;c++) {
				System.out.print(costs[r][c] + "\t\t");
			}
			System.out.println();
		}
		System.out.println();
		
		//search item
		System.out.print("Search your brands : ");
		String Sbrand = sc.nextLine();
		for(var c=0;c<6;c++) {
			if(Sbrand.equalsIgnoreCase(brands[c])) {
				index = c;
				break;
			}	
		}	
		
		if(index == -1) {
			System.out.println("does not exist");
		}else {
//			System.out.println("position : " + index);
			System.out.print("Search your CPU : ");
			String Scpu = sc.nextLine();
			for(var r=0;r<4;r++) {
				if(Scpu.equalsIgnoreCase(Cpu[r])) {
					indexc = r;
					break;
				}
			}
			if(indexc == -1) {
				System.out.println("does not exist");
			}else {
//				System.out.println("position : " + indexc);
				
				//search costs
				for(var r=0;r<4;r++) {
					for(var c=0;c<6;c++) {
						if(Sbrand.equals(brands[c]) && Scpu.equals(Cpu[r])) {
							getcost = costs[r][c];
							System.out.println("Getcost : " + getcost);
							
							//current exchange
							System.out.print("Now, Current exchange rate : ");
							double Currex = sc.nextDouble();
							
							//exchange MMK
							double ls = getcost * Currex;
							System.out.println("The total amount of price : " + ls + " MMK");
						}
					}
				}
			}
		}
		
	}
	
}
