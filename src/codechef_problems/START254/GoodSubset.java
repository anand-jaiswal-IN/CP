package codechef_problems.START254;
import java.util.*;

public class GoodSubset {
    static final int MOD = 998244353;
    static final int MAX = 200005;

    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];
    static long[] pow2 = new long[MAX];

    static void precompute() {
        fact[0] = 1;
        invFact[0] = 1;
        pow2[0] = 1;

        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        invFact[MAX - 1] = power(fact[MAX - 1], MOD - 2);
        for (int i = MAX - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

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

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public static int sol(int n) {
        List<Integer> blocks = new ArrayList<>();
        int cur = 1;
        int remaining = n;
        int maxS = 0;

        while (remaining > 0) {
            int blockSize = Math.min(remaining, cur);
            blocks.add(blockSize);
            maxS = Math.max(maxS, blockSize);
            remaining -= blockSize;
            cur <<= 1;
        }

        int m = blocks.size();
        int[] s = new int[m];
        for (int i = 0; i < m; i++) {
            s[i] = blocks.get(i);
        }

        long[] A = new long[m];
        for (int i = 0; i < m; i++) {
            A[i] = 1; 
        }

        long totalW = 0;

        for (int k = 1; k <= maxS; k++) {
            long W = 1;
            for (int i = 0; i < m; i++) {
                W = (W * A[i]) % MOD;
            }
            totalW = (totalW + W) % MOD;

            for (int i = 0; i < m; i++) {
                if (k <= s[i]) {
                    A[i] = (A[i] + nCr(s[i], k)) % MOD;
                }
            }
        }

        long ans = ((long) maxS * pow2[n] - totalW) % MOD;
        if (ans < 0) {
            ans += MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        precompute();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(sol(n));
        }

        sc.close();
    }

}