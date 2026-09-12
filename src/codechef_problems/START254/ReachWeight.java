package codechef_problems.START254;
import java.util.*;

public class ReachWeight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n % 2 == 0) {
                System.out.println((n / 2) * 30);
            } else {
                System.out.println((((n - 1) / 2) * 30) + 20);
            }
        }
        sc.close();
    }
}