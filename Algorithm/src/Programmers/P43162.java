package Programmers;

import java.util.*;

public class P43162 {
    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            q.offer(i);
            visited[i] = true;
            answer++;
            while(!q.isEmpty()) {
                int cur = q.poll();
                for (int j = 0; j < n; j++) {
                    if (visited[j] || computers[cur][j] == 0) continue;
                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
        return answer;
    }
}
