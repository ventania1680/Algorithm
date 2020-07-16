// https://www.acmicpc.net/problem/1107
// 20.7.16. ventania1680
// Brute-force�� Ǯ �� �ִ� ����
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1107 {
	public static void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ��ǥ
		int M = Integer.parseInt(br.readLine()); // ���峭 ��ư ����
		
		boolean[] broken = new boolean[10]; // ��ư ���� ����
		for (int i = 0; i < 10; i++)
			broken[i] = false;
		if (M > 0) { // M�� 0�� ��� �Է� ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				broken[Integer.parseInt(st.nextToken())] = true;
		}
		int answer = Math.abs(N - 100); // +, - �� �̿��ؼ� �̵��ϴ� ���
		for (int i = 0; i < 1000001; i++) {
			int pressNum = 0; // 0 ~ 1000000 ���� ���ڹ�ư���� ä�� �̵��� �� ���� �� ���ڹ�ư ������ Ƚ��
			if (i == 0) { // 0�� ä���� ��� ����ó��
				if (broken[0]) 
					pressNum = 0;
				else
					pressNum = 1;
			}
			else {
				int tmp = i;
				while(tmp > 0) { 
					if (broken[tmp%10]) { // ���峭 ��ư ���� ��� ���ڹ�ư���� ä�� �̵� �Ұ�
						pressNum = 0;
						break;
					}
					pressNum++; // ���峪�� ���� ��� ��ư ������ Ƚ�� +1
					tmp /= 10; // LSB ���� MSB���� Ȯ��
				}
			}
			if (pressNum > 0)
				if (answer > pressNum + Math.abs(N - i)) // ���� ä�ο��� ��ǥä�η� �̵��ϴ� ���� ������� �ּڰ����� Ȯ��
					answer = pressNum + Math.abs(N - i);
		}
		System.out.print(answer);
	}
}
