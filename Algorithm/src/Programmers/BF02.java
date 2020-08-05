// https://programmers.co.kr/learn/courses/30/lessons/42839
// 20.8.5. ventania1680

package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BF02 {
    public static int[] ints;
    public static List<Integer> list = new ArrayList<>();

    public static void DFS(int n, int cnt, int num, boolean[] contains) {
        if (cnt == n) {
            if (!list.contains(num))
                list.add(num);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!contains[i]) {
                contains[i] = true;
                DFS(n, cnt + 1, num * 10 + ints[i], contains);
                contains[i] = false;
            }
        }
        DFS(n, cnt + 1, num, contains);
    }

    public static boolean isPrime(int num) {
        int i;
        if (num < 2) return false;
        for (i = 2; i * i < num; i++) {
            if (num % i == 0) return false;
        }
        if (num % (i*i) == 0) return false;
        return true;
    }

    public static int solution(String numbers) {
        ints = new int[numbers.length()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = numbers.charAt(i) - '0';
        }
        boolean[] contains = new boolean[ints.length];
        Arrays.fill(contains, false);
        DFS(ints.length, 0, 0, contains);
        int answer = 0;
        for (int num : list) {
            if (isPrime(num))
                answer++;
        }
        return answer;
    }
}
