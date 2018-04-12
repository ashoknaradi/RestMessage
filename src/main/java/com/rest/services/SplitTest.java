package com.rest.services;

public class SplitTest {
	public static void main(String[] args) {
		String num = "25465,2435675,1432567";
		String n[] = num.split(",");
		for (String s : n) {
			System.out.println(s);
		}
	}
}
