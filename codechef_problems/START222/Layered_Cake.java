package START222;
import java.util.Scanner;

public class Layered_Cake {
    public static int solution(int[] A, int[] B){
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(B[j] < A[i]) ans++; 
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            System.out.println(solution(A,B));
        }
        sc.close();
    }
}