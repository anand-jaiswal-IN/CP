package START217;
import java.util.Scanner;

public class Add_to_make_Positive {

    public static int solution(long sum, int N) {
        if (sum >= 0) {
            return 0;
        }

        if ((-1 * sum) % N != 0) {
            return (int) (-1 * sum) / N + 1;
        } else {
            return (int) (-1 * sum) / N;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            long sum = 0;

            for (int i = 0; i < N; i++) {
                sum += sc.nextInt();
            }

            System.out.println(solution(sum, N));

            t--;
        }
        sc.close();
    }
}