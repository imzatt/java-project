package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Stream_testing {

	public static void main(String[] args) {
		
//		without_stream_api();
		with_stream_api();
			
	}


	private static void with_stream_api() {
		int[] price = {1700,1000,4200,1900,2800,2500,1500};
		
		//create stream
		IntStream streams = Arrays.stream(price);
		
		streams.filter(p -> p > 1500) //inter op1
				.sorted() // inter op2
				.forEach(p -> System.out.println(p)); // terminal op
		
	}
	
	private static void without_stream_api() {
			
		int[] price = {1700,1000,4200,1900,2800,2500,1500};
		List<Integer> list = new ArrayList<>();	
		
		//filter
		for(var p : price) {
				if(p > 1500)
					list.add(p);
			}
					
		//sorts
		Collections.sort(list);
					
		//display
		for(var p : list) {
			System.out.println(p);
			}
		
	}
}
