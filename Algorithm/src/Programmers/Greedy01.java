// https://programmers.co.kr/learn/courses/30/lessons/42862
// 20.8.7. ventania1680
package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greedy01 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] res = new boolean[31];
        Arrays.fill(res, false);
        Arrays.sort(lost);
        for (int i = 0; i < reserve.length; i++) {
            res[reserve[i]] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lost.length; i++)
            list.add(lost[i]);

        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            if (res[tmp]) {
                list.remove(i--);
                res[tmp] = false;
                answer++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            if (res[tmp - 1]) {
                res[tmp - 1] = false;
                answer++;
            }
            else if (res[tmp + 1]) {
                res[tmp + 1] = false;
                answer++;
            }
        }
        return answer;
    }
}
