package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P42895 {
    public static int solution(int N, int number) {
        ArrayList<Integer>[] list = new ArrayList[9];
        for (int i = 1; i < 9; i++)
            list[i] = new ArrayList<>();

        Map<Integer, Integer> isin = new HashMap<>();

        int tmp = N;
        for (int i = 1; i < 9; i++) {
            isin.put(tmp, i);
            list[i].add(tmp);
            tmp = tmp * 10 + N;
        }
        isin.put(N*N, 2);
        isin.put(N+N, 2);
        list[2].add(N*N);
        list[2].add(N+N);
        if (N != 1) {
            isin.put(1, 2);
            list[2].add(1);
        }
        isin.put(0, 0);

        for (int i = 2; i < 9; i++) {
            for (int j = 1; j+i < 9 && j <= i; j++) {
                int idx = i+j;
                for (int a : list[i]) {
                    for (int b : list[j]) {
                        if (!isin.containsKey(a+b)) {
                            list[idx].add(a+b);
                            isin.put(a+b, idx);
                        } else if (isin.get(a+b) > idx) {
                            list[idx].add(a+b);
                            isin.replace(a+b, idx);
                        }

                        if (!isin.containsKey(a*b)) {
                            list[idx].add(a*b);
                            isin.put(a*b, idx);
                        } else if (isin.get(a*b) > idx) {
                            list[idx].add(a*b);
                            isin.replace(a*b, idx);
                        }

                        if (!isin.containsKey(a/b)) {
                            list[idx].add(a/b);
                            isin.put(a/b, idx);
                        } else if (isin.get(a/b) > idx) {
                            list[idx].add(a/b);
                            isin.replace(a/b, idx);
                        }

                        if (!isin.containsKey(a-b)) {
                            list[idx].add(a-b);
                            isin.put(a-b, idx);
                        } else if (isin.get(a-b) > idx) {
                            list[idx].add(a-b);
                            isin.replace(a-b, idx);
                        }

                        if (!isin.containsKey(b-a)) {
                            list[idx].add(b-a);
                            isin.put(b-a, idx);
                        } else if (isin.get(b-a) > idx) {
                            list[idx].add(b-a);
                            isin.replace(b-a, idx);
                        }
                    }
                }
            }
        }

        if (isin.containsKey(number))
            return isin.get(number);
        return -1;
    }
}
