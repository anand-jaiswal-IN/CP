package leetcode_contests.Weekly_Contest_486;
// https://leetcode.com/contest/weekly-contest-486/problems/find-nth-smallest-integer-with-k-one-bits/description/
import java.util.Arrays;

public class FindNthSmallestIntegerWithKOneBits {
    public static long noOfBits(long n) {
        long count = 0;
        while (n > 0) {
            long p = n & 1;
            if (p == 1)
                count++;
            n >>= 1;
        }
        return count;
    }


    public static long nthSmallest(long n, int k){
        long ans = (long)Math.pow(2, k)-1;
        while (ans <= (long) Math.pow(2, 50) && n > 0) {
            if (noOfBits(ans) == k) {
                n--;
            }
            ans++;
        }
        return ans-1;
    }


    public static void noOf1Bit(long n1, long n2){
        for(long i = n1; i <= n2; i++){
            System.out.println(i + " -> " + noOfBits(i));
        }
    }


    static long[][] C = new long[55][55];
    static void buildComb() {
        for (int i = 0; i <= 50; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }
    }
    public static long nthSmallest2(long n, long k){
        buildComb();
        
        for (int i = 0; i < 55; i++) {
            System.out.println(Arrays.toString(C[i]));
        }

        long ans = 0;
        int remaining = (int)k;

        for (int bit = 50; bit >= 0 && remaining > 0; bit--) {

            // If we put 0 here, how many numbers possible?
            long countWithZero = C[bit][remaining];

            if (n > countWithZero) {
                // skip all those starting with 0 here
                n -= countWithZero;

                // place 1 at this bit
                ans |= (1L << bit);
                remaining--;
            }
            // else: keep bit = 0 and continue
        }

        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(nthSmallest2(10, 21));
        // System.out.println(nthSmallest2(8, 22));

        // System.out.println(nthSmallest(10, 21));
        System.out.println(nthSmallest2(8, 22));
        
        // noOf1Bit((long)Math.pow(2, 5), (long)Math.pow(2, 6));
    }
}
