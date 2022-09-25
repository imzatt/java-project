package com.mmit.controller;

import java.time.LocalDate;
import java.time.Period;

public class Testing {

	public static void main(String[] args) {
		
		LocalDate d1 = LocalDate.parse("2022-09-25");
		LocalDate d2 = LocalDate.parse("2022-10-03");
		
		int days = Period.between(d1, d2).getDays();
		
		if(days <= 7) {
			System.out.println("Under");
		}else {
			System.out.println("Over");
		}
		System.out.println(days);
		
	}
}
