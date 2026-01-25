package START218;
import java.util.Scanner;

public class Counting_Optimal_Arrays {

    static final long MOD = 998244353L;

    public static int solution(int N, int M) {

        if (N == 1) {
            return (int)((M + 1L) % MOD);
        }
        int p = 64 - Long.numberOfLeadingZeros(M);
        long f = (1L << p) - 1;

        long count = 2L * M - f + 1;
        if (count < 0) count = 0;

        return (int)(count % MOD);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(solution(N, M));
        }
        sc.close();
    }
}
