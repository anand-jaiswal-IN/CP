package CP_31_900;
import java.util.*;

public class D_Odd_Queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            int[] nums = new int[N];

            int totalSum = 0;
            int[] prefixSum = new int[N+1];
            prefixSum[0] = 0;

            for (int i = 0; i < N; i++){
                nums[i] = sc.nextInt();
                totalSum += nums[i];
                prefixSum[i+1] = prefixSum[i] + nums[i];
            }

            for (int i = 0; i < Q; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();
                
                int L = (r-l)+1;
                int rangeSum = prefixSum[r] - prefixSum[l-1];

                int ans = (totalSum - rangeSum) + (L*k);
                System.out.println(ans % 2 != 0 ? "YES" : "NO");
            }
            
            t--;
        }
        sc.close();
    }
}