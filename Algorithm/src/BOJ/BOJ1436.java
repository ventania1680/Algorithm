// https://www.acmicpc.net/problem/1436
// 20.8.8. ventania1680
// 브루트포스로 해결 가능

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1436 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int doom = 666;
        List<Integer> list = new ArrayList<>();
        list.add(doom);
        int tmp;
        for (int i = 1666; i < 3000000; i++) {
            tmp = i;
            while (tmp >= 666) {
                if ((tmp - doom) % 1000 == 0) {
                    list.add(i);
                    break;
                }
                tmp /= 10;
            }
        }
        System.out.println(list.get(n - 1));
    }
}
