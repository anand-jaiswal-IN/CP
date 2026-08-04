package CP_31_800;
import java.util.ArrayList;
import java.util.Scanner;

public class B_Sequence_Game {
    static void solution(int[] nums, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for (int i = 1; i < N; i++) {
            if(nums[i-1] > nums[i]){
                ans.add(nums[i]);
                ans.add(nums[i]);
            }
            else ans.add(nums[i]);
        }

        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
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
            solution(nums, N);
        }
        sc.close();

        // solution(new int[] {1, 2, 2, 1, 1}, 5);
    }
}