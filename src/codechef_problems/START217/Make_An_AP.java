package START217;
import java.util.Scanner;

public class Make_An_AP {
    public static int gcd(int a, int b) {
        if (a == b)
            return a;
        else if (a > b)
            return gcd(a - b, b);
        else
            return gcd(a, b - a);
    }

    public static int gcd(int[] nums) {
        int g = gcd(nums[0], nums[1]);
        if (nums.length == 2)
            return g;
        for (int i = 2; i < nums.length; i++) {
            g = gcd(g, nums[i]);
        }
        return g;
    }

    public static int gcd2(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcd2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int g = nums[0];
        for (int i = 1; i < nums.length; i++) {
            g = gcd(g, nums[i]);
            if (g == 1)
                return 1;
        }
        return g;
    }

    public static int solution(int[] arr, int N) {
        if (N <= 2)
            return 0;

        int[] diff = new int[N - 1];
        // int g = 0;

        for (int i = 1; i < N; i++) {
            diff[i - 1] = arr[i] - arr[i - 1];
            // if(i == 1) g = diff[i-1];
            // else g = gcd(g, diff[i-1]);
        }
        int g = gcd2(diff);

        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            if (diff[i] == g)
                continue;
            ans += (diff[i] / g) - 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(solution(arr, N));

            t--;
        }
        sc.close();

        // int[] arr = {1,7,9};
        // int r = solution(arr, arr.length);
        // System.out.println(r);
    }
}