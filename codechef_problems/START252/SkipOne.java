package START252;
import java.util.Scanner;

public class SkipOne {
    public static int sol(int[] A, long K) {
        int N = A.length;
        long sum = 0;
        long max = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            if (A[i] > max)
                max = A[i];
            long cost = sum - max;
            if (cost <= K) {
                ans = i + 1;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            long K = sc.nextLong();
            int[] A = new int[N];
            for (int i = 0; i < N; i++)
                A[i] = sc.nextInt();
            System.out.println(sol(A, K));
        }
        sc.close();
    }

}