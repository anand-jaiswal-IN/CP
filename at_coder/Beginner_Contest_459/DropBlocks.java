package at_coder.Beginner_Contest_459;
import java.util.*;

public class DropBlocks {
    public static void i(int[] arr, int i) {
        arr[i]++;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] <= 0)
                return;
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j]--;
        }
    }

    public static void p(int[] arr, int p) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= p)
                ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];

        while (q-- > 0) {
            int x = sc.nextInt();
            int s = sc.nextInt();

            if (x == 1) {
                i(arr, s - 1);
            }
            if (x == 2) {
                p(arr, s);
            }
        }
        sc.close();
    }
}