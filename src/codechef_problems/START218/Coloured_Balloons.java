package START218;

import java.util.Scanner;

public class Coloured_Balloons {
    public static int solution(int[] nums, int N){
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (i+1)*nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solution(nums, N));
            t--;
        }
        sc.close();
    }
}