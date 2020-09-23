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
            answer = (n + k) / 2;
        } else {
            int[] pi = getPi(str);
            //System.out.println(Arrays.toString(pi));
            if (pi[n-1] != 0) {
                if (n-pi[n-1] <= pi[n-1]+k) {
                    answer = n - pi[n - 1];
                    int len = answer;
                    while(pi[n-1]+k >= answer*2+len) {
                        answer += len;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}