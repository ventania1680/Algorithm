package BOJ16171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int kmp(String str, String pattern) {
        int[] pi = getPi(pattern);
        int n = str.length();
        int m = pattern.length();
        int j = 0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for (int i = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = pi[j - 1];
            }
            if (s[i] == p[j]) {
                if (j == m - 1) {
                    return 1;
                } else {
                    j++;
                }
            }
        }
        return 0;
    }

    static int[] getPi(String pattern) {
        int m = pattern.length();
        int j = 0;
        char[] p = pattern.toCharArray();
        int[] pi = new int[m];

        for (int i = 1; i < m; i++) {
            while (j > 0 & p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String newS = new String();
        String key = br.readLine();

        for (int i = 0 ; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                continue;
            newS += str.charAt(i);
        }
        System.out.println(kmp(newS, key));
    }
}
