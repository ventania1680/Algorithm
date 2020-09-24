// https://www.acmicpc.net/problem/16229
// 20.9.23. ventania1680
package BOJ;

import java.util.*;
import java.io.*;

public class BOJ16229 {
    static int[] getPi(String str) {
        int len = str.length();
        int[] pi = new int[len];
        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j))
                pi[i] = ++j;
        }
        return pi;
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        int answer = 0;
        if (n <= k) {
            answer = n;
        } else {
            int pLen = 0, pCnt;
            int[] pi = getPi(str);
            int cur = n-1;
            while(true) {
                pLen = n - pi[cur];
                pCnt = (n + k) / pLen;
                if(pCnt >= 2 && pLen*pCnt >= n)
                    answer = Math.max(answer, pLen);
                if (2*pi[cur] <= cur+1) break;
                cur = pi[cur]-1;
            }
        }
        System.out.println(answer);
    }
}