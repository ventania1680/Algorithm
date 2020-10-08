// https://programmers.co.kr/learn/courses/30/lessons/17678
// 20.10.8. ventania1680
package Programmers;

import java.util.Arrays;

public class P17678 {
    public static String solution(int n, int t, int m, String[] timetable) {
        int len = timetable.length;
        int[] crew = new int[len];
        for (int i = 0; i < len; i++) {
            String[] str = timetable[i].split(":");
            crew[i] = Integer.parseInt(str[0])*60;
            crew[i] += Integer.parseInt(str[1]);
        }
        Arrays.sort(crew);

        int now = 540;
        int curn = 1, curm = 0, cursor = 0;
        while(true) {
            while (curm < m && cursor < len) {
                if (crew[cursor] > now) break;
                cursor++;
                curm++;
            }
            if (curn == n) break;
            now += t;
            curn++;
            curm = 0;
        }
        int answerInt = 0;
        if (curm < m)
            answerInt = now;
        else
            answerInt = crew[cursor-1]-1;

        String answer = "";
            if (answerInt/60<10)
                answer += '0';
            answer += answerInt/60;
            answer += ':';
            if (answerInt%60<10)
                answer += '0';
            answer += answerInt%60;

        return answer;
    }
}
