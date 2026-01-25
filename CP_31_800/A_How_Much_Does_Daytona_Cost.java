package CP_31_800;
import java.util.*;
public class A_How_Much_Does_Daytona_Cost {
    public static boolean solution(int[] arr, int n, int k){
        for (int i = 0; i < n; i++) {
            if(arr[i] == k) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr, n, k) ? "YES" : "NO");
            t--;
        }
        sc.close();
    }
}