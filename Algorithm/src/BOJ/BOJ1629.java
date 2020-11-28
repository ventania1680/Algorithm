package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1629 {
    static int[] arr = new int[3];
    static long power (int cnt, long num) {
        if (cnt == 1)
            return (int)num;
        long ret = power(cnt/2, num);
        if(cnt % 2 == 0)
            return ret * ret % arr[2];
        else
            return ret * ret % arr[2] * arr[0] % arr[2];
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        arr[0] = Integer.parseInt(str[0]);
        arr[1] = Integer.parseInt(str[1]);
        arr[2] = Integer.parseInt(str[2]);

        System.out.println(power(arr[1],arr[0]%arr[2]));
    }
}
