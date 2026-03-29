package B1947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long MOD = 1000000000L;

        if (n == 1) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[n + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD;
        }

        System.out.println(dp[n]);
    }
}
