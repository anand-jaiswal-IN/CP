package leetcode_contests.Weekly_Contest_494;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumRemovalstoAchieveTargetXOR {
    public int minRemovals(int[] nums, int target) {
        int totalXOR = 0;
        for (int x : nums)
            totalXOR ^= x;

        if (totalXOR == target)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            int totalXORcopy = totalXOR;

            for (int j = 0; j < i; j++) {
                totalXORcopy ^= nums[j];
            }

            for (int j = i; j < nums.length; j++) {
                if ((totalXORcopy ^ nums[j]) == target) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    public static int minRemovals2(int[] nums, int target) {
        ArrayList<int[]> subsets = new ArrayList<>(); // [[xor, number of elements]]
        subsets.add(new int[] { 0, 0 });

        for (int i = 0; i < nums.length; i++) {
            int len = subsets.size();
            for (int j = 0; j < len; j++) {
                int[] s = subsets.get(j);
                subsets.add(new int[] { s[0] ^ nums[i], s[1] + 1 });
            }
        }
        int ans = -1;
        for (int i = 0; i < subsets.size(); i++) {
            int[] s = subsets.get(i);
            if (s[0] == target) {
                ans = Math.max(ans, s[1]);
            }
        }
        return ans == -1 ? -1 : nums.length - ans;
    }


    ArrayList<int[]> subsets = new ArrayList<>();
    public void minRemovals3Helper(int[] nums, int idx){
        if(idx == nums.length) return;
        
        int length = subsets.size();
        for(int i = 0; i < length; i++){
            int[] s = subsets.get(i);
            subsets.add(new int[] {s[0] + 1, s[1] ^ nums[idx]});
        }
        minRemovals3Helper(nums, idx+1);
    }
    
    public int minRemovals3(int[] nums, int target) {
        subsets.add(new int[] {0, 0});
        minRemovals3Helper(nums, 0);

        int len = subsets.size();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            int[] k = subsets.get(len-i-1);
            if(k[1] == target) ans = Math.min(ans, nums.length - k[0]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minRemovals4(int[] nums, int target){
        // using DP
        HashMap<Integer, Integer> map = new HashMap<>(); // map<xor, maximum number of elements>
        map.put(0,0);

        for(int num : nums){
            HashMap<Integer, Integer> newMap = new HashMap<>(map);

            for(Map.Entry<Integer, Integer> e : map.entrySet()){
                int xor = e.getKey() ^ num;
                int size = e.getValue() + 1;

                if(newMap.containsKey(xor)){
                    newMap.put(xor, Math.max(newMap.get(xor), size));
                }else{
                    newMap.put(xor, size);
                }
            }
            map = newMap;
        }

        return map.containsKey(target) ? nums.length - map.get(target) : -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int r = minRemovals2(arr, 2);
        System.out.println(r);
    }
}
