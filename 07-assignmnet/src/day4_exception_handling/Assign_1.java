package day4_exception_handling;

public class Assign_1 {
	
	public static void main(String[] args) {

		try {
			String[] numbers = {"10","56","1","150","9"};
			int total=0;
			int count=0;
			
//			var data = numbers[5];
//			System.out.println(data);
			
			
			for(var c=0;c<5;c++) {
				int num = Integer.parseInt(numbers[c]);
				System.out.print(num + "\t");
				total += num;
				count++; 
				
			}
			float avg = total/count;
			System.out.println("\nAverage : " + avg); 
			
			int[] values = new int[numbers.length];
			for(var i=0;i<numbers.length;i++) {
				values[i] = Integer.parseInt(numbers[i]);
			}
//			System.out.println(Arrays.toString(values));
			
			int min = values[0];
			int max = values[0];
			
			for(var x=0;x<5;x++) {
				if(values[x] < min) min = values[x];
				if(values[x] > max) max = values[x];
			}
				System.out.println("Min : " + min);
				System.out.println("Max : " + max);
					
		}
		catch(NumberFormatException obj){
			System.err.println("Input is not a number");
		}
		catch(ArithmeticException obj) {
			System.err.println("Divisor must not be zero");
		}
		catch(ArrayIndexOutOfBoundsException obj){
			System.err.println(obj.getMessage());
		}
		System.out.println("Outside try catch block");
	}
}
