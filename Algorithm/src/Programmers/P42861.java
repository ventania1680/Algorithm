package Programmers;

import java.util.*;

public class P42861 {
    static int[] p;

    static void union(int a, int b) {
        if (p[a] > p[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        p[a] += p[b];
        p[b] = a;
    }

    static int find(int a) {
        if (p[a] < 0)
            return a;
        return p[a] = find(p[a]);
    }

    public static int solution(int n, int[][]costs) {
        p = new int[n];
        Arrays.fill(p, -1);
        Arrays.sort(costs, (Comparator.comparingInt(o -> o[2])));

        int totalCost = 0;
        for (int[] cost : costs) {
            int a = find(cost[0]);
            int b = find(cost[1]);
            if (a == b)
                continue;
            totalCost += cost[2];
            union(a, b);
        }

        return totalCost;
    }
}
