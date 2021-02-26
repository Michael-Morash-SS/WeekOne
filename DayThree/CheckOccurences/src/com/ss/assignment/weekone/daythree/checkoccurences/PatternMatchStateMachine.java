/**
 * 
 */
package com.ss.assignment.weekone.daythree.checkoccurences;

import java.util.HashMap;

/**
 * @author Michael
 *
 */
public class PatternMatchStateMachine {
	//Finite state machine to match string patterns
	private HashMap<Character, Integer> stateIndex;
	final private int wildCardIndex = 0;
	private int indexCount = 0;
	private int[][] stateGraph;
	
	private int currentState = 0;
	private int endState = 0;
	
	public PatternMatchStateMachine(String pattern) {
		endState = pattern.length();
		stateIndex = new HashMap<>();
		
		for (int i = 0; i < pattern.length(); i++) {
			if (!stateIndex.containsKey(pattern.charAt(i))) {
				indexCount += 1;
				stateIndex.put(pattern.charAt(i), indexCount);
			}
		}
		
		stateGraph = new int[pattern.length()][indexCount + 1];
		
		for (int i = 0; i < indexCount + 1; i++) {
			stateGraph[0][i] = 0;
		}
		
		stateGraph[0][stateIndex.get(pattern.charAt(0))] = 1;
		
		for (int i = 1; i < pattern.length(); i++) {
			int tempState = 0;
			
			for (int j = 1; j < i; j++) {
				tempState = stateGraph[tempState][stateIndex.get(pattern.charAt(j))];
			}
			
			for (int j = 0; j < indexCount + 1; j++) {
				stateGraph[i][j] = stateGraph[tempState][j];
			}
			
			stateGraph[i][stateIndex.get(pattern.charAt(i))] = i + 1;
		}
		
		for (int i = 0; i < stateGraph.length; i++) {
			for (int j = 0; j < stateGraph[i].length; j++) {
				System.out.print("" + stateGraph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean step(Character c) {
		if (stateIndex.containsKey(c)) {
			currentState = stateGraph[currentState][stateIndex.get(c)];
		} else {
			currentState = stateGraph[currentState][wildCardIndex];
		}
		
		return currentState == endState;
	}
	
	public void setState(int state) {
		currentState = state;
	}
}
