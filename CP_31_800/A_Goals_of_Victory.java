package CP_31_800;
import java.util.*;

public class A_Goals_of_Victory {
    public static int solution(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return 0 - sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n-1];
            for (int i = 0; i < n-1; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr, n));
            t--;
        }
        sc.close();
    }

}