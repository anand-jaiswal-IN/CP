package START223;
import java.util.Scanner;

public class School_Trip {

    public static int solution(int N, int X, int K){
        int rem = X%K;
        int toAddStud = K-rem;
        if((N-X) >= toAddStud){
            return Math.min(rem, toAddStud);
        }
        return rem;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            int K = sc.nextInt();

            System.out.println(solution(N, X, K));

        }
        sc.close();
    }
}