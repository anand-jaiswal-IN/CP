import java.util.Scanner;

public class B_Hourglass {

    public static int solution(int s, int k, int m) {
        int f = m / k;
        int ei = m % k;

        int sandStart;
        if (f % 2 == 0) {
            sandStart = s;
        } else {
            sandStart = Math.min(s, k);
        }

        if (ei == 0) {
            return sandStart;
        } else {
            return Math.max(0, sandStart - ei);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int s = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(solution(s, k, m));

        }
        sc.close();
    }
}