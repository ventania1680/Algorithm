package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2593 {
    static int n;
    static boolean check(int[] a, int[] b) {
        int i = a[0], j = b[0];
        while(i <= n && j <= n) {
            if (i > j)
                j += b[1];
            else if (i < j)
                i += a[1];
            else return true;
        }
        return false;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] el = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            el[i][0] = Integer.parseInt(st.nextToken());
            el[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 환승 가능한 엘리베이터
        ArrayList<Integer>[] ch = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++)
            ch[i] = new ArrayList<>();
        for (int i = 1; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                if (check(el[i], el[j])) {
                    ch[i].add(j);
                    ch[j].add(i);
                }
            }
        }

        boolean[] start = new boolean[m + 1];
        Queue<Integer> queue = new LinkedList<>();
        int[] visitedE = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            if (b - el[i][0] >= 0 && (b - el[i][0]) % el[i][1] == 0) {
                queue.offer(i);
                visitedE[i] = -1;
            }
            if (a - el[i][0] >= 0 && (a - el[i][0]) % el[i][1] == 0)
                start[i] = true;
        }

        StringBuilder answer = new StringBuilder();

        while (!queue.isEmpty()) {
            int curE = queue.poll();
            if (start[curE]) {
                while (curE != -1) {
                    answer.append(curE).append('\n');
                    curE = visitedE[curE];
                }
                break;
            }
            for (int i : ch[curE]) {
                if (visitedE[i] != 0)
                    continue;
                visitedE[i] = curE;
                queue.offer(i);
            }
        }

        if (answer.length() == 0)
            System.out.println(-1);
        else {
            System.out.println(answer.length() / 2);
            System.out.print(answer);
        }
    }
}
