import java.util.Scanner;

public class A_Operations_with_Inversions {
    public static int solution(int[] nums, int N){
        int ops = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(nums[j] != -1 && nums[i] > nums[j]){
                    nums[j] = -1;
                    ops++;
                }
            }
        }
        return ops;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) 
                nums[i] = sc.nextInt();
            
            System.out.println(solution(nums, N));
            t--;
        }
        sc.close();
    }
}