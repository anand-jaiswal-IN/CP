package START231;
import java.util.HashSet;
import java.util.Scanner;

public class Target_Temperature {
    public static boolean solution(int[] nums, int maxVal){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num < maxVal){
                if(set.contains(num)){
                    return false;
                }
                set.add(num);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                maxVal = Math.max(maxVal, nums[i]);
            }

            System.out.println(solution(nums, maxVal) ? "Yes" : "No");
        }
        sc.close();
    }
}