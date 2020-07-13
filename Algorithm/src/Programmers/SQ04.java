// https://programmers.co.kr/learn/courses/30/lessons/42585
// 20.7.13. ventania1680
package Programmers;

public class SQ04 {
	public static int solution(String arrangement) {
		int size = 0;
		char[] arr = arrangement.toCharArray();
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				size++;
			}
			else {
				size--;
				if (arr[i-1] == '(')
					answer += size;
				else
					answer++;
			}
		}
		return answer;
	}
}
