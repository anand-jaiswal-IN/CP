import java.util.Scanner;

public class B_MEX_Reordering {
    public static boolean solution(int[] nums){
        int count0 = 0, count1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) count0++;
            if(nums[i] == 1) count1++;
        }

        if(count0 == 0) return false;
        else if(count0 > 1 && count1 == 0) return false;
        else return true;
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
            System.out.println(solution(nums) ? "YES" : "NO");
        }
        sc.close();
    }
}