// https://codeforces.com/problemset/problem/1878/C
package CP_31_900.atkaHuaQuestion;

import java.util.*;

public class C_Vasilije_in_Cacak {

    public static boolean solution(int n, int k, long x) {
        if (k > n)
            return false;

        long smallest_sum = (long) k * (k + 1) / 2;
        long total_sum = (long) n * (n + 1) / 2;
        long toSub = (long) (n-k) * ((n-k) + 1) /2;
        long largest_sum = total_sum-toSub;
        return smallest_sum <= x && x <= largest_sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long x = sc.nextLong();

            System.out.println(solution(n, k, x) ? "YES" : "NO");
            t--;
        }
        sc.close();
    }
}