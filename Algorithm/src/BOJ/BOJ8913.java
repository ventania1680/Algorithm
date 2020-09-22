// https://www.acmicpc.net/problem/8913
// 20.9.21. ventania1680
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ8913 {
    static boolean extract(String str) {
        if (str.length() == 1)
            return false;
        int i = 0;
        String newStr;
        for (int j = 1; j < str.length(); j++) {
            if (str.charAt(i) != str.charAt(j)) {
                if(j-i > 1) {
                    if (i == 0)
                        newStr = str.substring(j);
                    else
                        newStr = str.substring(0, i) + str.substring(j);
                    if (extract(newStr))
                        return true;
                }
                i = j;
            }
        }
        if (i == 0)
            return true;
        else
            return false;
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            ArrayList<String> list = new ArrayList<>();
            String str = br.readLine();
            if(extract(str)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}