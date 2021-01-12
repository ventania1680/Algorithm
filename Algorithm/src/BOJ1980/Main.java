package BOJ1980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] arr = new int[t+1];
        for (int i = 0; n * i <= t; i++) {
            arr[i] = t - n * i;
        }

        int berger = 0, coke = 0;
        if (t % n == 0) berger = t / n;
        if (t % m == 0) berger = Math.max(t / m, berger);
        for (int i = 0; i < t; i++) {
            for (int j = 0; j <= t; j++) {
                if (arr[j] == 0) break;
                if ((arr[j] - i) % m == 0)
                {
                    berger = Math.max(j + (arr[j] - i) / m, berger);
                    coke = i;
                }
            }
            if (berger != 0) break;
        }
        if (berger == 0) coke = t;
        System.out.println(berger + " " + coke);
    }
}
