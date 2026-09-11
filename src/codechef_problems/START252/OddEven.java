package START252;
import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int evens = 0, odds = 0;
            for (int i = 0; i < n; i++) {
                if (sc.nextInt() % 2 == 0)
                    evens++;
                else
                    odds++;
            }
            int ans = -1;
            if (n % 2 == 0) { // n is even
                if (evens == odds)
                    ans = n;
                else
                    ans = 2 * Math.min(odds, evens) + 1;
            } else {
                ans = 2 * Math.min(evens, odds) + 1;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}