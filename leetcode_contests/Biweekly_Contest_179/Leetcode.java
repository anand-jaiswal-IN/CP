package leetcode_contests.Biweekly_Contest_179;

public class Leetcode {
    static final int MOD = 1_000_000_007;

    public int countVisiblePeople(int n, int pos, int k) {
        int left = pos;
        int right = n - 1 - pos;

        long[] fact = new long[n + 1];
        long[] inv = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i-1] * i % MOD;
        inv[n] = pow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) inv[i] = inv[i+1] * (i+1) % MOD;

        long ans = 0;
        for (int l = 0; l <= Math.min(left, k); l++) {
            int r = k - l;
            if (r > right) continue;
            ans = (ans + c(left, l, fact, inv) * c(right, r, fact, inv)) % MOD;
        }

        return (int)(ans * 2 % MOD);
    }

    long c(int n, int r, long[] fact, long[] inv) {
        if (r < 0 || r > n) return 0;
        return fact[n] % MOD * inv[r] % MOD * inv[n-r] % MOD;
    }

    long pow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}