package START241;
import java.util.*;

public class IncreasingWindows {
    static final int MOD = 998244353;
    static final int MAX = 200005;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];
    static boolean isPrecomputed = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            System.out.println(sol(N, K));
        }
        sc.close();
    }

    public static long sol(int N, int K) {
        if (!isPrecomputed) {
            precompute();
            isPrecomputed = true;
        }

        long ans = 0;
        
        for (int M = 1; M <= K; M++) {
            
            if (N - M < N - K) continue;
            
            long waysFirstK = (power(M, K) - power(M - 1, K) + MOD) % MOD;
            
            long waysRemaining = nCr(N - M, N - K);
            
            long currentWays = (waysFirstK * waysRemaining) % MOD;
            ans = (ans + currentWays) % MOD;
        }
        
        return ans;
    }
    private static void precompute() {
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX - 1] = power(fact[MAX - 1], MOD - 2);
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }
    private static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }
    private static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}