import java.util.*;
/**
 * ARiptide
 */
public class ARiptide {
    public static int solution(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        while(!(nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])){
            nums[0]++;
            nums[2]--;
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] nums = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            System.out.println(solution(nums));
        }
        sc.close();
    }
}