package START223;

import java.util.Scanner;

public class Add_to_First {

    public static int find(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target)  return i;
        }
        return -1;
    }
    public static boolean solution(int[] A, int[] B){
        int N = A.length;
        for (int i = 0; i < N; i++) {
            if(A[i] > B[i]) return false;

            if(A[i] < B[i]){
                int idx = find(A, A[i]);
                if(idx != i) return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                B[i] = sc.nextInt();
            }

            System.out.println(solution(A, B) ? "Yes" : "No");
        }
        sc.close();

        // int[] A = {1,2};
        // int[] B = {2,3};
        // System.out.println(solution(A, B));
    }
}