// https://programmers.co.kr/learn/courses/30/lessons/43238
// 20.10.22. ventania1680
package Programmers;

public class P43238 {
    public static long solution(int n, int[] times) {
        int max = times[0];
        for (int time : times) {
            max = Math.max(max, time);
        }

        long left = 0;
        long right = (long)max * (long)n;

        while(left < right) {
            long mid = (right - left) / 2 + left;
            long tmp = 0;
            for (int time : times) {
                tmp += mid / time;
            }
            if (tmp >= n)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}
