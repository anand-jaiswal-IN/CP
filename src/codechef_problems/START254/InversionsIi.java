package codechef_problems.START254;
import java.util.*;

public class InversionsIi {
    static final int MOD = 998244353;
    static final int MAX = 200005;

    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];
    static long[] pow2 = new long[MAX];
    static long[] invPow2 = new long[MAX];

    static long[] doubleFact = new long[MAX];
    static long[] invDoubleFact = new long[MAX];

    static long[] prefE = new long[MAX];
    static long[] prefA = new long[MAX / 2 + 5];
    static long[] prefB = new long[MAX / 2 + 5];

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

    static long modInverse(long n) {
        return power(n, MOD - 2);
    }

    static void precompute() {
        fact[0] = 1;
        invFact[0] = 1;
        pow2[0] = 1;
        invPow2[0] = 1;

        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        long inv2 = modInverse(2);
        for (int i = 1; i < MAX; i++) {
            invPow2[i] = (invPow2[i - 1] * inv2) % MOD;
        }

        doubleFact[1] = 1;
        for (int i = 3; i < MAX; i += 2) {
            doubleFact[i] = (doubleFact[i - 2] * i) % MOD;
        }

        invDoubleFact[1] = 1;
        for (int i = 3; i < MAX; i += 2) {
            invDoubleFact[i] = modInverse(doubleFact[i]);
        }

        long[] e = new long[MAX];
        e[0] = 1;
        for (int K = 1; K < MAX; K++) {
            if (K % 2 == 0) {
                int k = K / 2;
                e[K] = doubleFact[2 * k - 1];
            } else {
                int k = (K + 1) / 2;
                e[K] = (pow2[k - 1] * fact[k - 1]) % MOD;
            }
        }

        prefE[0] = e[0];
        for (int i = 1; i < MAX; i++) {
            prefE[i] = (prefE[i - 1] + e[i]) % MOD;
        }

        int limitD = (MAX - 2) / 2;
        for (int d = 1; d <= limitD; d++) {
            long termA = invDoubleFact[2 * d + 1];
            prefA[d] = (prefA[d - 1] + termA) % MOD;

            long termB = (invPow2[d] * invFact[d]) % MOD;
            prefB[d] = (prefB[d - 1] + termB) % MOD;
        }
    }

    public static int sol(int n) {
        long part1 = prefE[n];

        int maxDa = (n - 2) / 2;
        int maxDb = (n - 1) / 2;
        long sumAB = (prefA[maxDa] + prefB[maxDb]) % MOD;
        long part2 = (fact[n] * sumAB) % MOD;

        long totalE = (part1 + part2) % MOD;
        long totalSum = (((2L * n - 1) % MOD) * fact[n]) % MOD;

        long ans = (totalSum - totalE + MOD) % MOD;
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






