// https://programmers.co.kr/learn/courses/30/lessons/42840
// 20.8.5. ventania1680

package Programmers;

public class BF01 {
    public static int[] solution(int[] answers) {
        int[] first = new int[10000];
        int[] second = new int[10000];
        int[] third = new int[10000];
        int[] count = {0, 0, 0};

        for (int i = 0; i < 10000; i+=5) {
            first[i] = 1; first[i+1] = 2; first[i+2] = 3; first[i+3] = 4; first[i+4] = 5;
        }
        for (int i = 0; i < 10000; i+=8) {
            second[i] = second[i+2] = second[i+4] = second[i+6] = 2;
            second[i+1] = 1; second[i+3] = 3; second[i+5] = 4; second[i+7] = 5;
        }
        for (int i = 0; i < 10000; i+=10) {
            third[i] = third[i+1] = 3;
            third[i+2] = third[i+3] = 1;
            third[i+4] = third[i+5] = 2;
            third[i+6] = third[i+7] = 4;
            third[i+8] = third[i+9] = 5;
        }
        for (int i = 0; i < answers.length; i++) {
            if (first[i] == answers[i]) count[0]++;
            if (second[i] == answers[i]) count[1]++;
            if (third[i] == answers[i]) count[2]++;
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (max < count[i])
                max = count[i];
        }

        if (max == count[0] && max == count[1] && max ==  count[2])
            return new int[] {1, 2, 3};
        else if (max == count[0] && max == count[1])
            return new int[] {1, 2};
        else if (max == count[0] && max == count[2])
            return new int[] {1, 3};
        else if (max == count[1] && max == count[2])
            return new int[] {2, 3};
        else {
            for (int i = 0; i < 3; i++) {
                if (max == count[i])
                    return new int[] {i+1};
            }
        }
        return new int[] {-1};
    }
}