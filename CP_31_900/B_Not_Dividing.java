// https://codeforces.com/problemset/problem/1794/B
package CP_31_900;
import java.util.Scanner;

public class B_Not_Dividing {

    public static void solution(int[] nums, int N){
        if(nums[0] == 1) nums[0]++;
        for (int i = 1; i < N; i++) {
            if(nums[i] == 1) {
                nums[i]++;
            }
            while(nums[i] % nums[i-1] == 0){
                nums[i]++;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int i = 0; i < N; i++)
                nums[i] = sc.nextInt();
            
            solution(nums, N);
            t--;
        }
        sc.close();

        // int[] nums = {1 ,2 ,3};
        // solution(nums, nums.length);
    }
}