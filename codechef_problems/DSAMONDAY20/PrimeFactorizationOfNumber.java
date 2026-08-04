package DSAMONDAY20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorizationOfNumber {
    public static int maximumOfNumbers(int[] numbers) {
        int ans = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            ans = Math.max(ans, numbers[i]);
        }
        return ans;
    }

    public static List<Integer> primesTill(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        if (n >= 0)
            isPrime[0] = false;
        if (n >= 1)
            isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int mul = p * p; mul <= n; mul += p) {
                    isPrime[mul] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i < n + 1; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        return primes;
    }

    public static List<List<Integer>> primeFactorization(int[] numbers) {
        int maxNumber = maximumOfNumbers(numbers);
        List<Integer> primes = primesTill(maxNumber);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];

            List<Integer> factors = new ArrayList<>();

            int k = 0;

            while (n != 1) {
                int divisor = primes.get(k);

                if (n % divisor == 0) {
                    n /= divisor;
                    factors.add(divisor);
                } else
                    k++;
            }
            ans.add(factors);

        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
