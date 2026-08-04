package START241;
import java.io.*;
import java.util.*;

public class IncreasingWindows2 {
    static final int MOD = 998244353;
    static final int MAX = 200005;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    public static void main(String[] args) throws IOException {
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        precompute();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] tokens = br.readLine().trim().split("\\s+");
            int N = Integer.parseInt(tokens[0]);
            int K = Integer.parseInt(tokens[1]);

            long ans = 0;
            
            // M can go from 1 up to K
            for (int M = 1; M <= K; M++) {
                if (N - M < N - K) continue; // Not enough elements remaining
                
                // Ways to have max exactly M in first K elements: M^K - (M-1)^K
                long waysFirstK = (power(M, K) - power(M - 1, K) + MOD) % MOD;
                
                // Ways to pick the remaining N-K strictly increasing elements
                long waysRemaining = nCr(N - M, N - K);
                
                long currentWays = (waysFirstK * waysRemaining) % MOD;
                ans = (ans + currentWays) % MOD;
            }
            
            out.println(ans);
        }
        out.flush();
    }

    // Precompute factorials and inverse factorials for combinations
    static void precompute() {
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

    // O(1) Combinations calculation
    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    // Binary Exponentiation O(log power)
    static long power(long base, long exp) {
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