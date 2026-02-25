import java.util.Scanner;

public class A_Parkour_Design2 {
    static boolean solution2(int x, int y) {
        for (int c = 0; c <= x / 4; c++) {
            int a = y + c;
            if (a < 0)
                continue; // a must be non-negative

            if ((x - 2 * y - 6 * c) % 3 != 0)
                continue;
            int b = (x - 2 * y - 6 * c) / 3;

            if (b >= 0 && 2 * a + 3 * b + 4 * c == x) {
                return true;
            }
        }
        return false;
    }

    static boolean solution(long x, long y) {
        if ((x - 2 * y) % 3 != 0) {
            return false;
        }

        return  (y >= 0) ? (x >= 2 * y) : (x >= -4 * y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(solution((long)x, (long)y) ? "YES" : "NO");
        }
        sc.close();
    }
}