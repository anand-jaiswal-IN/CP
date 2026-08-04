package START222;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Prefixes {
    public static int solution(int[] nums){
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                ans = nums[i];
                Arrays.sort(nums, 0, i+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(solution(nums));
        }
        sc.close();
    }
}