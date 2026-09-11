package CP_31_900;
import java.util.Scanner;

public class A_Mainak_and_Array {
    public static int solution(int[] nums, int N, int maxIndex) {
        if (N == 1) {
            return 0;
        }
        int leftElem = 0, rightElem = 0, maxElem = nums[maxIndex];

        if (maxIndex == 0) {
            leftElem = nums[N - 1];
            rightElem = nums[1];
        } else if (maxIndex == N - 1) {
            leftElem = nums[N - 2];
            rightElem = nums[0];
        } else {
            leftElem = nums[maxIndex - 1];
            rightElem = nums[maxIndex + 1];
        }

        int a = maxElem - leftElem, b = maxElem - rightElem, c = maxElem-nums[0];

        return Math.max(Math.max(a, b), c);
    }

    public static int solution(int[] nums, int N){
        // take the subarray which contains first and last element
        int max0 = nums[N-1] - nums[0];
        int max1 = 0;
        for (int i = 0; i < N-1; i++) {
            max1 = Math.max(max1, nums[i] - nums[i+1]);
        }

        // take the subarray which doesn't contains first element
        int max2 = 0;
        for (int i = 1; i < N; i++) {
            max2 = Math.max(max2, nums[i] - nums[0]);
        }

        // take the subarray which doesn't contains last element
        int max3 = 0;
        for (int i = 0; i < N-1; i++) {
            max3 = Math.max(max3, nums[N-1] - nums[i]);
        }

        return Math.max(max0, Math.max(max3, Math.max(max1, max2)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            // find max of the array
            int maxIndex = 0;
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }

            System.out.println(solution(nums, N));

            t--;
        }
        sc.close();
    }
}