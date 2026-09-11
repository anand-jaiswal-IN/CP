import java.util.Scanner;

public class A_Parkour_Design {

    static boolean solution(int x, int y) {
        int offset = Math.abs(y);
        int[][] dp = new int[x + 1][2 * offset + 1];

        return helper(0, 0, x, y, dp, offset);
    }

    static boolean helper(int ix, int iy, int x, int y, int[][] dp, int offset) {
        if (ix == x && iy == y)
            return true;
        if (ix > x || Math.abs(iy) > Math.abs(y))
            return false;

        if (dp[ix][iy + offset] == 1)
            return true;
        if (dp[ix][iy + offset] == -1)
            return false;

        boolean res = helper(ix + 2, iy + 1, x, y, dp, offset) ||
                helper(ix + 3, iy, x, y, dp, offset) ||
                helper(ix + 4, iy - 1, x, y, dp, offset);
                
        dp[ix][iy + offset] = res == true ? 1 : -1;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(solution(x, y) ? "YES" : "NO");
        }
        sc.close();
    }
}