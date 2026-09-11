import java.util.Scanner;

public class A_Array_Coloring {

    public static boolean solution(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int s = Math.abs(nums[i] - nums[i-1]);
            if(s % 2 == 0) return false;
        }
        return true;
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

            System.out.println(solution(nums) ? "YES": "NO");
        }
        sc.close();


        // int[] nums = {2,3,4,1};
        // int[] nums = {2,3,1};
        // int[] nums = {3, 4 ,1 ,2 ,5};
        // int[] nums = {3,1,4,2,5};
        // System.out.println(solution(nums));
    }
}