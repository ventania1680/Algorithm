// For debug
package Programmers;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.print(Arrays.toString(Sort01.solution(array, commands)));
	}
}
