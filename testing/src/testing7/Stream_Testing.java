package testing7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Stream_Testing {

	public static void main(String[] args) {
		
		//without_stream_api();
		with_stream_api();
		
	}

	private static void with_stream_api() {
		
		int [] prices = {1700,3500,3800,2200,5000,13500,500,1500,1000};
		
		// create stream
		IntStream streams = Arrays.stream(prices);
		
		streams.filter(p -> p > 1500) // inter op1
			.sorted() // inter op2
			.forEach(p -> System.out.println(p)); // terminal op 
		
	}

	private static void without_stream_api() {
		
		int [] prices = {1700,3500,3800,2200,5000,13500,500,1500,1000};
		
		List<Integer> list = new ArrayList<>();
		
		// filer
		for(var p : prices) {
			if(p > 1500) 
				list.add(p);
		}
		
		// sorts
		Collections.sort(list);
		
		// display
		for(var p : list)
			System.out.println(p);
		
	}
	
	
}
