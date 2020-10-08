// https://programmers.co.kr/learn/courses/30/lessons/42884
// 20.10.8. ventania1680
package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class P42884 {
    public static int solution(int[][] routes) {
        int answer = 0, left = routes.length;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int last = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (last < route[0]) {
                answer++;
                last = route[1];
            }
        }
        return answer;
    }
}
