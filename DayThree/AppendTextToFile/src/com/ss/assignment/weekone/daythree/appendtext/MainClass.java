package com.ss.assignment.weekone.daythree.appendtext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("File name: ");
		String fileName = input.nextLine();
		System.out.print("Write: ");
		String output = input.nextLine();
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(fileName, true);
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
