package Programmers;

public class P1831 {
    static int cnt = 0;
    static void dfs(int value, int carry) {
        if (Math.pow(3, carry/2) > value) return;
        if (value == 3) {
            if (carry == 2) cnt++;
            return;
        } else if (value > 3) {
            if (value % 3 == 0 && carry >= 2)
                dfs(value / 3, carry - 2);
            dfs(value - 1, carry + 1);
        }
    }
    public static int solution(int n) {
        dfs(n-2, 2);
        return cnt;
    }
}
