package Programmers;

public class DFSBFS01 {
    static int[] arr = new int[20];
    static int n, t, answer;
    public static void DFS(int num, int pos) {
        if (pos == n - 1) {
            if (num == t)
                answer++;
            return;
        }
        DFS(num + arr[pos], pos + 1);
        DFS(num - arr[pos], pos + 1);
    }
    public static int solution(int[] numbers, int target) {
        n = numbers.length;
        t = target;
        for (int i = 0; i < n; i++)
            arr[i] = numbers[i];

        answer = 0;
        DFS(arr[0], 0);
        DFS(-arr[0], 0);

        return answer;
    }
}
