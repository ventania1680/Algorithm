// https://www.acmicpc.net/problem/1107
// 20.7.16. ventania1680
// Brute-force로 풀 수 있는 문제
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1107 {
	public static void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 목표
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
		
		boolean[] broken = new boolean[10]; // 버튼 고장 여부
		for (int i = 0; i < 10; i++)
			broken[i] = false;
		if (M > 0) { // M이 0인 경우 입력 없음
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				broken[Integer.parseInt(st.nextToken())] = true;
		}
		int answer = Math.abs(N - 100); // +, - 만 이용해서 이동하는 경우
		for (int i = 0; i < 1000001; i++) {
			int pressNum = 0; // 0 ~ 1000000 까지 숫자버튼으로 채널 이동할 수 있을 때 숫자버튼 누르는 횟수
			if (i == 0) { // 0번 채널의 경우 예외처리
				if (broken[0]) 
					pressNum = 0;
				else
					pressNum = 1;
			}
			else {
				int tmp = i;
				while(tmp > 0) { 
					if (broken[tmp%10]) { // 고장난 버튼 있을 경우 숫자버튼으로 채널 이동 불가
						pressNum = 0;
						break;
					}
					pressNum++; // 고장나지 않은 경우 버튼 누르는 횟수 +1
					tmp /= 10; // LSB 부터 MSB까지 확인
				}
			}
			if (pressNum > 0)
				if (answer > pressNum + Math.abs(N - i)) // 현재 채널에서 목표채널로 이동하는 것이 현재까지 최솟값인지 확인
					answer = pressNum + Math.abs(N - i);
		}
		System.out.print(answer);
	}
}
