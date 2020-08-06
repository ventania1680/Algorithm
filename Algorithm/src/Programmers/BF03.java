// https://programmers.co.kr/learn/courses/30/lessons/42842
// 20.8.6. ventania1680
package Programmers;

public class BF03 {
    public static int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        for (int row = 3; row < sum; row++) {
            if (sum % row == 0) {
                int col = sum / row;
                if (row * 2 + col * 2 - 4 == brown) {
                    return new int[] {col, row};
                }
            }
        }
        return null;
    }
}
