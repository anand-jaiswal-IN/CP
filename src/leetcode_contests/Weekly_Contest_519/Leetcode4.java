package leetcode_contests.Weekly_Contest_519;

public class Leetcode4 {
    public int shadowPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    if (k != -1) {
                        if (nums[j] < nums[k])
                            k = j;
                    } else {
                        k = j;
                    }
                }

                if (((k == j || k == -1) && nums[i] < nums[j]) ||
                        (k != -1 && !(nums[i] < nums[k] && nums[k] < nums[j]) && nums[i] < nums[j]))
                    ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode4 obj = new Leetcode4();
        System.out.println(obj.shadowPairs(new int[] { 3, 1, 4, 2, 5 }));
        System.out.println(obj.shadowPairs(new int[] { 6, 7, 8, 9 }));
    }
}
