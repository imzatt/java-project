package day3_string_assignment;

public class Assign_1 {

	public static void main(String[] args) {
			
		String paragraph = "NLP techniques are becoming widely popular scientific research areas as well as Information Technology industry . Languages technology together with Information Technology can enhance the lives of people with different capabilities . This system implements voice command mobile phone dialer application . The strength of the system is that it can make phone call to the contact name written in either English scripts or Myanmar scripts .";
		
		//count sentences
		String [] data = paragraph.split(" . "); 
		System.out.println("the number of sentence : " + data.length);
		
		//count words
		String [] data1 = paragraph.split(" "); 
		System.out.println("Total words : " + data1.length);
	}
}
