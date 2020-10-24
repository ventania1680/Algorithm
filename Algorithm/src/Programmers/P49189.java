// https://programmers.co.kr/learn/courses/30/lessons/49189
// 20.10.25. ventania1680
package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class P49189 {
    static ArrayList<Integer>[] al;
    static int[] distance;

    static void dfs(int node, int dist) {
        for (int n : al[node]) {
            if (distance[n] > dist) {
                distance[n] = dist;
                dfs(n, dist+1);
            }
        }
    }

    public static int solution(int n, int[][] edge) {
        al = new ArrayList[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++)
            al[i] = new ArrayList<>();
        for (int[] e : edge) {
            al[e[0]].add(e[1]);
            al[e[1]].add(e[0]);
        }
        distance[0] = 0;
        distance[1] = 0;
        dfs(1, 1);

        int max = 0;
        for (int i : distance) {
            max = Math.max(max, i);
        }

        int answer = 0;
        for (int i : distance) {
            if (i == max)
                answer++;
        }
        return answer;
    }
}
