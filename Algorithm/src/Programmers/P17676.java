// https://programmers.co.kr/learn/courses/30/lessons/17676
// 20.10.24. ventania1680
package Programmers;

import java.util.Arrays;
import java.util.StringTokenizer;

public class P17676 {
    static int lineToInt(String complete, String process) {
        int i;
        StringTokenizer st = new StringTokenizer(complete);
        i = Integer.parseInt(st.nextToken(":")) * 3600000;
        i += Integer.parseInt(st.nextToken(":")) * 60000;
        i += Integer.parseInt(st.nextToken(":.")) * 1000;
        i += Integer.parseInt(st.nextToken(":."));
        if (process != null) {
            process = process.substring(0, process.length()-1);
            i -= (int)(Double.parseDouble(process)*1000);
            i += 1;
        }
        return i;
    }
    public static int solution(String[] lines) {
        int n = lines.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            String complete = lines[i].substring(11, 23);
            String process = lines[i].substring(24);
            start[i] = lineToInt(complete, process);
            end[i] = lineToInt(complete, null);
        }
        Arrays.sort(start);

        int answer = 0;
        int traffic = 0;
        int i = 0, j = 0;
        while(i < n) {
            if (start[i] > end[j]) {
                while (i < n && start[i] < end[j]+1000) {
                    ++traffic;
                    ++i;
                }
                answer = Math.max(answer, traffic);
                --traffic;
                ++j;
            } else {
                ++traffic;
                ++i;
            }
        }
        answer = Math.max(answer, traffic);
        return answer;
    }
}
