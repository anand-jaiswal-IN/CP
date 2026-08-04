package START249;
import java.util.Scanner;

/**
 * BuyingGpu
 */
public class BuyingGpu {

    public static int solution(int x, int y, int z) {
        if (z - y <= 0) {
            return -1;
        }
        double c = (double)x /(z-y);
        return (int)Math.ceil(c);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            System.out.println(solution(x, y, z));
        }
        sc.close();
    }
}