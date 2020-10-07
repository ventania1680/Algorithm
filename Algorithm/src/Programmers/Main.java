// For debug
package Programmers;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
		System.out.print(Arrays.toString(P60060.solution(words, queries)));
	}
}
