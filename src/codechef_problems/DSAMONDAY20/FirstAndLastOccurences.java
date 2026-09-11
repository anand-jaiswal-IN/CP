package DSAMONDAY20;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastOccurences {
    public static int bs(int[] arr, int key, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (arr[m] < key) {
                s = m + 1;
            } else if (arr[m] > key) {
                e = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] arr, int key) {
        int occ = bs(arr, key, 0, arr.length - 1);
        if (occ == -1)
            return new int[] { -1, -1 };

        int leftmost = occ, rightmost = occ;
        while (leftmost >= 0 && arr[leftmost] == key) {
            leftmost--;
        }
        while (rightmost < arr.length && arr[rightmost] == key) {
            rightmost++;
        }
        return new int[] { ++leftmost, --rightmost };
    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while (t-- > 0) {
        // int N = sc.nextInt();
        // int key = sc.nextInt();

        // int[] nums = new int[N];

        // for(int i = 0; i < N; i++){
        // nums[i] = sc.nextInt();
        // }
        // int[] ans = searchRange(nums, key);
        // System.out.println(ans[0] + " " + ans[1]);
        // }
        // sc.close();

        int[] nums = {1,3,3,5,5,5,7};
        System.out.println(Arrays.toString(searchRange(nums, 5)));

    }
}
