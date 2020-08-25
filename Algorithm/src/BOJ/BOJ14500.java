package BOJ;

import java.util.*;
import java.io.*;

public class BOJ14500 {
    static int n, m, max = 0;
    static int[][] table;
    final static int[][][] shape = {
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // ㅁ
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // ㅡ
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}}, {{0, 2}, {1, 0}, {1, 1}, {1, 2}}, {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // ㄱ
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, {{0, 0}, {0, 1}, {1, 0}, {2, 0}}, {{0, 1}, {1, 1}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, {{0, 1}, {1, 0}, {1, 1}, {2, 0}}, {{0, 1}, {0, 2}, {1, 0}, {1, 1}}, {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // N
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, {{0, 1}, {1, 0}, {1, 1}, {1, 2}}, {{0, 1}, {1, 0}, {1, 1}, {2, 1}}, {{0, 0}, {1, 0}, {1, 1}, {2, 0}} // ㅗ
    };

    public static void tetromino(int y, int x) {
        for (int i = 0; i < 19; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int ty = y + shape[i][j][1];
                int tx = x + shape[i][j][0];
                if (ty < n && tx < m)
                    sum += table[ty][tx];
            }
            if (max < sum)
                max = sum;
        }
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        table = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tetromino(i, j);
            }
        }
        System.out.print(max);
    }
}
