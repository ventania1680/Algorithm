// https://www.acmicpc.net/problem/2231
// 20.9.19. ventania1680
package BOJ;

import java.util.Scanner;

public class BOJ2231 {
	public static void solution() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		for (int i = 1; i < n; i++) {
			int partialSum = i;
			int tmp = i;
			while(tmp > 0) {
				partialSum += tmp%10;
				tmp /= 10;
			}
			if (partialSum == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
