package day4;

import java.util.Arrays;

public class TwoD_array {

	public static void main(String[] args) {
		
		int [][] marks = {
				{65, 73, 86, 84,59},
				{71, 80, 90, 69,95},
				{75, 75, 99, 96, 99}
		};
		
		String[] names = {"Jeon","Yuri","Cherry"};
		
		// output
		for(var r = 0 ; r < 3 ; r++) {
			for(var c = 0 ; c < 5 ; c++) {
				System.out.print(marks[r][c] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("----- for each -----");
		for (int[] row:marks) {
			for(int col:row) {
				System.out.print(col + "\t");
			}
			System.out.println();
		}
		System.out.println(Arrays.deepToString(marks));
		
		int row = marks.length;
		int col = marks[0].length;
		for (var i = 0; i < row; i++) {
			var total = 0;
			for (var j = 0; j < col; j++) {
				total += marks[i][j];
			}
			System.out.println("-----------------");
			System.out.println("Total marks obtained by student " + names[i] + ": " + total);
			System.out.println("Average mark: " + (float)total/5);
		}
	}
}
