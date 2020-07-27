// https://programmers.co.kr/learn/courses/30/lessons/42746
// 20.7.27. ventania1680
package Programmers;

import java.util.*;

public class Sort02 {
	public static String solution(int[] numbers) {
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		};
		
		String[] tmp = new String[numbers.length];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(tmp, comp);
		
		String answer = "";
		for (int i = 0; i < tmp.length; i++) {
			if (answer.compareTo("0") == 0 && tmp[i].compareTo("0") == 0) break; // "00000" 처럼 0이 중복되는 경우 예외처리
			answer += tmp[i];
		}
		return answer;
	}
}
