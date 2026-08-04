package START249;
import java.util.*;

public class ProductExceed {

    public static int solution(int x, int y, int p) {
        int ans = 0;
        while (x*y < p) {
            int tempX = x + 1;
            int tempY = y + 1;
            
            if (tempX * y >= x * tempY) x++;
            else y++;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int p = sc.nextInt();
            System.out.println(solution(x, y, p));
        }
        sc.close();
    }
}