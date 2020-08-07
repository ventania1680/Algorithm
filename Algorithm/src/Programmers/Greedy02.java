// https://programmers.co.kr/learn/courses/30/lessons/42883
// 20.8.7. ventania1680
package Programmers;

import java.util.Stack;

public class Greedy02 {
    public static String solution(String number, int k) {
        char[] answer = new char[number.length() - k];
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while(!s.isEmpty() && s.peek() < c && k-- > 0)
                s.pop();
            s.push(c);
        }

        for (int i = 0; i < answer.length; i++)
            answer[i] = s.get(i);

        return new String(answer);
    }
}
