package day4;

import java.util.Arrays;

public class Array_Testing {

	public static void main(String[] args) {
		
		int[] arr1 = {100,20,200,40,90};
		
		//print
		for(var num:arr1) 
			System.out.print(num + " ");
		
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println("\nAfter copying, arr2 : " + Arrays.toString(arr2));
		
		var arr3 = Arrays.copyOfRange(arr1, 1, 3); // 1 -> 2
		System.out.println("After range arr3 : " + Arrays.toString(arr3));
		
		System.out.println("arr1 == arr2: " + Arrays.equals(arr1, arr2));
		System.out.println("arr1 == arr3: " + Arrays.equals(arr1, arr3));
		
		Arrays.sort(arr1);
		System.out.println("After sorting, arr1 : " + Arrays.toString(arr1));
		
		System.out.println("Is 90 in array : " + Arrays.binarySearch(arr1, 90));
		System.out.println("Is 50 in array : " + Arrays.binarySearch(arr1, 50));
		
//		Arrays.fill(arr1, 7);
//		System.out.println("After filling: " + Arrays.toString(arr1));
		
		int total = Arrays.stream(arr1).sum();
		System.out.println("Total: " + total);
		int max = Arrays.stream(arr1).max().getAsInt();
		System.out.println("Max value: " + max);
		System.out.println("Max value: " + Arrays.stream(arr1).min().getAsInt());
		
//		System.out.println(arr1[5]);
		
		changeValue(arr1);
		System.out.println("After calling method, arr1: " + Arrays.toString(arr1));
		
		Student s = new Student();
		s.rno =20;
		System.out.println("Before, rno: " + s.rno);
		changeRno(s);
		System.out.println("After, rno: " + s.rno);
		
		int num = 100;
		System.out.println("Before, num : " + num);
		change(num);
		System.out.println("After, num : " + num);
	}

	private static void change(int a) { // a = 100
		a = 500;
		System.out.println("inside, a : " + 500);
	}

	private static void changeRno(Student s1) { // s1 = s 
		s1.rno = 1;
	}

	private static void changeValue(int[] data) {
		data[0] = 1000;
	}
}

class Student {
	int rno;
}
