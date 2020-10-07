// https://www.acmicpc.net/problem/2292
// 20.9.30. ventania1680
package BOJ;

import java.util.Scanner;

public class BOJ2292 {
	public static void solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int answer;
		if (n == 1) answer = 1;
		else {
			answer = 2;
			int diff = 12;
			int section = 7;
			while(section < n) {
				section += diff;
				diff += 6;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
