// https://programmers.co.kr/learn/courses/30/lessons/42747
// 20.8.3. ventania1680
// h는 citations의 원소가 아닐 수도 있음
// Ex) citations = {6, 1, 6, 6, 6} 일 때, h = 4
package Programmers;

import java.util.*;

public class Sort03 {
	public static int solution(int[] citations) {
		Arrays.sort(citations);
		int n = citations.length;
		int h = 0;
		int j = 0;
		for (int i = 0; i <= 1000; i++) {
			if (i <= citations[j] && i <= n - j) {
				h = i;
				while(j < n - 1 && citations[j] <= i)
					j++;
			}
		}
		return h;
	}
}
