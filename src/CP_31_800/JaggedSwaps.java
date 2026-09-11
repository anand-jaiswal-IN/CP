package CP_31_800;
import java.util.Scanner;

public class JaggedSwaps {
    public static boolean isSorted(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            
            for (int i = 1; i < n-1; i++) {
                if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                    int k = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = k;
                }
            }
            System.out.println(isSorted(nums) ? "YES": "NO");

            t--;
        }

        sc.close();
    }
}
