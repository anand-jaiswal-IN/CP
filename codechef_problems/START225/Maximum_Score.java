package START225;
import java.util.Scanner;

public class Maximum_Score {
    // static long solve(int n) {
    //     Scanner sc = new Scanner(System.in);

    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] A = new int[n];

            long ans = 0;

            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
                ans += A[i];
            }

            int[] B = new int[n];
            int minDiff = Integer.MAX_VALUE;

            int minDiffIdx = 0;
            for (int i = 0; i < n; i++) {
                B[i] = sc.nextInt();
                if (A[i] - B[i] < minDiff) {
                    minDiff = A[i] - B[i];
                    minDiffIdx = i;
                }
            }

           System.out.println(ans - A[minDiffIdx] + B[minDiffIdx]);

        }
        sc.close();
    }
}