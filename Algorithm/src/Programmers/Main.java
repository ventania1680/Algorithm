// For debug
package Programmers;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		System.out.print(Arrays.toString(P43164.solution(tickets)));
	}
}
