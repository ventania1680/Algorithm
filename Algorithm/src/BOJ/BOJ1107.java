// https://www.acmicpc.net/problem/1107
// 20.7.16. ventania1680
// Brute-force로 풀 수 있는 문제
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1107 {
	public static void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] broken = new boolean[10];
		for (int i = 0; i < 10; i++)
			broken[i] = false;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			broken[Integer.parseInt(st.nextToken())] = true;
		
		int answer = Math.abs(N - 100);
		for (int i = 0; i < 1000001; i++) {
			int pressNum = 0;
			int tmp = i,len = 0;
			for (int j = 0; j < 6; j++) {
				if (tmp < 10)
					len = j;
				tmp /= 10;
			}
			for (int j = 0; j < len; j++) {
				
			}
		}
		
		System.out.print(answer);
	}
}
