package leetcode_contests.Weekly_Contest_523;
import java.util.*;

public class Leetcode2 {
    boolean[] primes;

    public void sieve() {
        primes = new boolean[1_000_000 + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                long p = (long) i * i;
                if (p >= primes.length)
                    break;
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    public List<Integer> maxPrimes(int n, int s) {
        if (primes == null)
            sieve();

        List<Integer> ans = new ArrayList<>();
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                sum += i;
                if (sum > s)
                    break;
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode2 obj = new Leetcode2();
        int n = 7, s = 20;
        System.out.println(obj.maxPrimes(n, s));
    }
}
