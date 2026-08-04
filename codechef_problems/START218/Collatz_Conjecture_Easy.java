package START218;
import java.util.Scanner;

public class Collatz_Conjecture_Easy {
    public static boolean solution(long N) {
        if (N % 4 == 0) {
            return true;
        }
        if (N == 1 || N == 2 || N == 3 || N == 6) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long N = sc.nextLong();

            System.out.println(solution(N) ? "Yes" : "No");

            t--;
        }
        sc.close();
    }
}