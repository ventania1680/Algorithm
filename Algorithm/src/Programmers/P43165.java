package Programmers;

import java.util.Queue;
import java.util.LinkedList;

public class P43165 {
    public static int solution(int[] numbers, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        int answer = 0;
        int n = numbers.length;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n) {
                if (cur[1] == target) {
                    answer++;
                }
                continue;
            }
            queue.offer(new int[] {cur[0]+1, cur[1]+numbers[cur[0]]});
            queue.offer(new int[] {cur[0]+1, cur[1]-numbers[cur[0]]});
        }

        return answer;
    }
}
