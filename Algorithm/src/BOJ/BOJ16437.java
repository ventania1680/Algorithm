package BOJ;

import java.util.*;
import java.io.*;

public class BOJ16437 {
    static long[] sheep = new long[123457];
    static ArrayList<Integer>[] al = new ArrayList[123457];
    static void dfs(int pos, int prev) {
        for (int i = 0; i < al[pos].size(); i++)
            dfs(al[pos].get(i), pos);
        if (sheep[pos] > 0)
            sheep[prev] += sheep[pos];
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= n; i++)
            al[i] = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().compareTo("S") == 0)
                sheep[i] = Long.parseLong(st.nextToken());
            else
                sheep[i] = -Long.parseLong(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            al[p].add(i);
        }
        dfs(1, 0);
        System.out.print(sheep[1]);
    }
}
