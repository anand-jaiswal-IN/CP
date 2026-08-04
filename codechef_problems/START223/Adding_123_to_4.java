package START223;
import java.util.*;

public class Adding_123_to_4 {
    public static int solution(int X, int Y, int Z) {
        return Math.min(X, Z) + Y / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();

            System.out.println(solution(X, Y, Z));
        }
        sc.close();
    }
}