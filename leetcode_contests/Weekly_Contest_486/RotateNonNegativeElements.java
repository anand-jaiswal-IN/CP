package leetcode_contests.Weekly_Contest_486;
// https://leetcode.com/contest/weekly-contest-486/problems/rotate-non-negative-elements/
import java.util.*;

public class RotateNonNegativeElements {

    public static void leftRotate(List<Integer> arr, int k) {
        k %= arr.size();
        List<Integer> ans = new ArrayList<>();

        for(int i = k; i < arr.size(); i++){
            ans.add(arr.get(i));
        }
        for(int i = 0; i < k; i++){
            ans.add(arr.get(i));
        }
        for(int i = 0; i < ans.size(); i++){
            arr.set(i, ans.get(i));
        }
    }

    public static int[] rotateElements(int[] nums, int k) {
        List<Integer> nonNeg = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nonNeg.add(nums[i]);
            }
        }

        if(nonNeg.size() == 0) return nums;

        leftRotate(nonNeg, k);

        int[] ans = new int[nums.length];
        int c = 0;
        for (int i = 0; i < ans.length; i++) {
            if (nums[i] >= 0) {
                ans[i] = nonNeg.get(c++);
            } else {
                ans[i] = nums[i];
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        // int[] nums ={1,-2,3,-4};
        // int k = 3;
        int[] nums ={-3,-2,7};
        int k = 1;
        // int[] nums ={5,4,-9,6};
        // int k = 2;
        // int[] nums ={-6,-2};
        // int k = 18866;
        System.out.println(Arrays.toString(rotateElements(nums, k)));
    }   
}