// For debug
package Programmers;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		System.out.print(Arrays.toString(Heap04.solution(operations)));
	}
}
