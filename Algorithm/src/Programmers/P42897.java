// https://programmers.co.kr/learn/courses/30/lessons/42897
// 20.9.10. ventania1680
package Programmers;

public class P42897 {
    public static int solution(int[] money) {
        int size = money.length;

        if (size == 3) {
            int max = money[0] > money[1] ? money[0] : money[1];
            return max > money[2] ? max : money[2];
        }

        int[] dp1 = new int[size + 1];
        int[] dp2 = new int[size + 1];

        for (int i = 0; i < size; i++)
            dp1[i + 1] = dp2[i + 1] = money[i];
        dp1[1] = 0;
        dp2[1] = dp2[2] = 0;

        for (int i = 2; i < size; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + dp1[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + dp2[i]);
        }

        return Math.max(dp1[size - 2] + money[size - 1], dp2[size - 1] + money[0]);
    }
}
