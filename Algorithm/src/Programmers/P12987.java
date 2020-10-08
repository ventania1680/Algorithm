// https://programmers.co.kr/learn/courses/30/lessons/12987
// 20.10.8. ventania1680
package Programmers;

import java.util.Arrays;

public class P12987 {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        int i = 0, j = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        while(j < B.length) {
            if (A[i] < B[j]) {
                i++;
                answer++;
            }
            j++;
        }
        return answer;
    }
}
