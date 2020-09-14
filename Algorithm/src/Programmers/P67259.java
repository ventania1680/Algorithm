package Programmers;

import java.util.Arrays;

public class P67259 {
    static int[][] visited = new int[25][25];
    static int[][] newBoard = new int[25][25];
    static int n;

    public static void dfs(int x, int y, int cost, int dir) {
        if (visited[y][x] < cost)
            return;
        visited[y][x] = cost;

        if (x < n - 1 && newBoard[y][x+1] == 0 && dir != 4) {
            if (dir == 6 || dir == 0)
                dfs(x+1, y, cost+100, 6);
            else
                dfs(x+1, y, cost+600, 6);
        }
        if (y < n - 1 && newBoard[y+1][x] == 0 && dir != 8) {
            if (dir == 2 || dir == 0)
                dfs(x, y+1, cost+100, 2);
            else
                dfs(x, y+1, cost+600, 2);
        }
        if (x > 0 && newBoard[y][x-1] == 0 && dir != 6) {
            if (dir == 4 || dir == 0)
                dfs(x-1, y, cost+100, 4);
            else
                dfs(x-1, y, cost+600, 4);
        }
        if (y > 0 && newBoard[y-1][x] == 0 && dir != 2) {
            if (dir == 8 || dir == 0)
                dfs(x, y-1, cost+100, 8);
            else
                dfs(x, y-1, cost+600, 8);
        }
    }

    public static int solution(int[][] board) {
        n = board.length;
        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], 10000000);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        dfs(0, 0, 0, 0);
        return visited[n-1][n-1];
    }
}
