package Programmers;

public class nqueen {
    static int[] queen = new int[20];
    static int[] nqueen = new int[20];
    static boolean promising(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (queen[i] == queen[j] || Math.abs(i - j) == Math.abs(queen[i] - queen[j]))
                    return false;
            }
        }
        return true;
    }
    static void backTracking(int n, int idx) {
        if (!promising(idx-1))
            return;
        else if (idx > n) {
            nqueen[n]++;
            return;
        }
        if (idx == 1) {
            for (int i = 1; i <= n / 2; i++) {
                queen[idx] = i;
                backTracking(n, idx + 1);
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                queen[idx] = i;
                backTracking(n, idx + 1);
            }
        }
    }
    public static int solution(int n) {
        nqueen[1] = 1;
        if (n > 3) {
            backTracking(n, 1);
            nqueen[n] *= 2;
            if (n % 2 == 1) {
                queen[1] = n / 2 + 1;
                backTracking(n, 2);
            }
        }
        return nqueen[n];
    }
}
