package jasonv2.Testing;

import java.util.Scanner;

public class firstcse214 {

	public static void main (String[] args) {
		String input;
		try (Scanner some = new Scanner (System.in)) {
			System.out.print("input a number: ");
			input = some.nextLine();
		}
		System.out.print(input);
	}
}
