/**
 * 
 */
package com.ss.assignment.weekone.daythree.listdir;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Michael
 *
 */
public class DirectoryLister {
	File file;
	int depth = 0;;
	StringBuffer outputBuffer;
	
	public DirectoryLister(String fileLocation) {
		// Create from file location
		file = new File(fileLocation);
		depth = 0;
		outputBuffer = new StringBuffer();
	}
	
	public DirectoryLister(File file) {
		// Create from file object
		this.file = file;
		depth = 0;
		outputBuffer = new StringBuffer();
	}
	
	public DirectoryLister(File file, int depth) {
		// Initialize with depth to indent for child directories
		this.file = file;
		this.depth = depth;
		//Generate the string that represents the tree structure
		outputBuffer = new StringBuffer();
		
		if (depth > 0) {
			for (int i = 1; i < depth; i++) {
				outputBuffer.append("|   ");
			}
			
			outputBuffer.append("|-- ");
		}
	}
	
	public void print() {
		// Print out the file and recursively print child directories
		DirectoryLister childPrinter;
		String output = outputBuffer.append(file.getName()).toString();
		
		System.out.println(output);
		
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				childPrinter = new DirectoryLister(f, depth + 1);
				childPrinter.print();
			}
		}
	}
}
