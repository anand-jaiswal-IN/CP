package START218;

import java.util.Scanner;

public class Deleting_Array_Again {
    public static int solution(int[] A, int[] C, int N) {
        // int[] smallArr = new int[N];
        
        int least = Integer.MAX_VALUE;

        int cost = 0;
        for (int i = 0; i < N; i++) {
            least = Math.min(least, C[i]);

            cost += A[i] * least;
        }
        return cost;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            int[] C = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                C[i] = sc.nextInt();
            }

            System.out.println(solution(A, C, N));
            t--;
        }
        sc.close();
    }
}