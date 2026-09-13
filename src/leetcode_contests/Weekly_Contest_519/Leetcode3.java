package leetcode_contests.Weekly_Contest_519;

import java.util.Stack;

public class Leetcode3 {
    public long shadowPairs(int[] nums) {
        Stack<int[]> st = new Stack<>(); // new int[] {number, frequency}
        long sum = 0;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (st.size() > 0) {
                int[] top = st.peek();
                if (top[0] == x) {
                    top[1]++;
                    sum++;
                    ans += (sum - top[1]);
                } else if (x > top[0]) {
                    st.add(new int[] { x, 1 });
                    ans += sum;
                    sum++;
                } else {
                    while (st.size() > 0 && x < st.peek()[0]) {
                        sum -= st.pop()[1];
                    }
                    if (st.size() > 0 && x == st.peek()[0]) {
                        st.peek()[1]++;
                        sum++;
                        ans += (sum - st.peek()[1]);
                    } else {
                        st.add(new int[] { x, 1 });
                        ans += sum;
                        sum++;
                    }
                }
            } else {
                st.add(new int[] { x, 1 });
                sum++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode3 obj = new Leetcode3();
        System.out.println(obj.shadowPairs(new int[] { 3, 1, 4, 1, 5 }));
        System.out.println(obj.shadowPairs(new int[] { 6, 7, 6, 6, 7 }));
        System.out.println(obj.shadowPairs(new int[] { 1, 2, 3, 4 }));
    }
}
