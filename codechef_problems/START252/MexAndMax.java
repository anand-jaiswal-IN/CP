package START252;
import java.util.Scanner;

public class MexAndMax {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] count = new int[N + 2];

           
            for (int i = 0; i < N; i++) {
                int val = sc.nextInt();
                if (val <= N + 1) {
                    count[val]++;
                }
            }

            
            long[] p = new long[N + 2];
            for (int i = 0; i <= N + 1; i++) {
                p[i] = (power(2, count[i]) - 1 + MOD) % MOD;
            }

            
            long[] prefixProd = new long[N + 2];
            prefixProd[0] = p[0];
            for (int i = 1; i <= N + 1; i++) {
                prefixProd[i] = (prefixProd[i - 1] * p[i]) % MOD;
            }

            long totalValidSubsequences = 0;

            for (int M = 0; M <= N; M++) {
                
                long waysCase1 = prefixProd[M];
                totalValidSubsequences = (totalValidSubsequences + waysCase1) % MOD;

                if (M >= 1) {
                    long waysCase2 = p[M];
                    if (M >= 2) {
                        waysCase2 = (waysCase2 * prefixProd[M - 2]) % MOD;
                    }
                    totalValidSubsequences = (totalValidSubsequences + waysCase2) % MOD;
                }
            }

            System.out.println(totalValidSubsequences);
        }
        sc.close();
    }

    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) != 0)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}