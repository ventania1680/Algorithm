// https://programmers.co.kr/learn/courses/30/lessons/42748
// 20.7.27. ventania1680
// Arrays 클래스의 copyOfRange, sort 메소드 사용
package Programmers;

import java.util.*;

public class Sort01 {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < answer.length; i++) {
			int[] newArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(newArray);
			answer[i] = newArray[commands[i][2]-1];
		}
		return answer;
	}
}
