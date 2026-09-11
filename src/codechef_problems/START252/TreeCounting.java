package START252;
import java.util.Scanner;

public class TreeCounting {
    public static int sol(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;

        int MOD = 998244353;
        int[][] dp = new int[n + 1][2 * n + 1];
        int offset = n;
        dp[0][offset] = 1;

        for (int i = 0; i < n; i++) {
            int val = nums[i] - 1;

            for (int size = i; size >= 0; size--) {
                for (int s = 0; s <= 2 * n; s++) {
                    if (dp[size][s] > 0) {
                        int nextS = s + val;
                        if (nextS >= 0 && nextS <= 2 * n) {
                            dp[size + 1][nextS] = (dp[size + 1][nextS] + dp[size][s]) % MOD;
                        }
                    }
                }
            }
        }

        long totalGoodTrees = 0;

        for (int k = 1; k < n; k++) {
            long ways = dp[k][offset];
            if (ways > 0) {
                long trees = (power(k, n - k - 1, MOD) * power(n - k, k - 1, MOD)) % MOD;
                long contribution = (ways * trees) % MOD;
                totalGoodTrees = (totalGoodTrees + contribution) % MOD;
            }
        }

        long inv2 = 499122177;
        totalGoodTrees = (totalGoodTrees * inv2) % MOD;

        return (int) totalGoodTrees;
    }

    private static long power(long base, long exp, int mod) {
        if (exp <= 0)
            return 1;
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) != 0)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(sol(nums));
        }
        sc.close();
    }

}