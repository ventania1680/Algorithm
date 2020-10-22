// https://programmers.co.kr/learn/courses/30/lessons/68646
// 20.10.22. ventania1680
package Programmers;

public class P68646 {
    public static int solution(int[] a) {
        int n = a.length;
        int[] r = new int[n];
        int[] l = new int[n];

        for (int i = 1; i < n; i++) {
            if (a[i] > a[i-1]) {
                l[i] = l[i-1];
            } else {
                if (a[i] > a[l[i-1]]) {
                    l[i] = l[i-1];
                } else {
                    l[i] = i;
                }
            }
        }

        r[n-1] = n-1;
        int minIdx = l[n-1];
        for (int i = n-2; i > minIdx; i--) {
            if (a[i] > a[i+1]) {
                r[i] = r[i+1];
            } else {
                if (a[i] > a[r[i+1]]) {
                    r[i] = r[i+1];
                } else {
                    r[i] = i;
                }
            }
        }

        int answer = 1;
        for (int i = 0; i < minIdx; i++) {
            if (l[i] == i) answer++;
        }
        for (int i = n-1; i > minIdx; i--) {
            if (r[i] == i) answer++;
        }

        return answer;
    }
}
