package util;

import java.util.Scanner;

public class IoUtils {
	public static int inputNumbers() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	public static String inputString() {
		Scanner scan = new Scanner(System.in);
		String inputString = scan.nextLine();
		return inputString;
	}

	public static void printMsg(String msg) {
		System.out.println(msg);
	}
}
