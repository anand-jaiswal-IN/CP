import java.util.*;

class BHypercarpAndTheControlPanel1 {
    public static List<List<Integer>> reduce(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(nums[0]);
        ans.add(t);

        for (int i = 1; i < nums.length; i++) {
            List<Integer> lastArr = ans.getLast();

            if (lastArr.get(0) == nums[i]) {
                if (lastArr.size() < 2)
                    lastArr.add(nums[i]);
            } else {
                List<Integer> t1 = new ArrayList<>();
                t1.add(nums[i]);
                ans.add(t1);
            }
        }
        return ans;
    }

    public static int solv(int[] nums) {
        List<List<Integer>> rArr = reduce(nums);

        int gain = 0;

        for (int i = 1; i < rArr.size(); i++) {
            List<Integer> prev = rArr.get(i - 1);
            List<Integer> curr = rArr.get(i);
            List<Integer> next = rArr.get(i + 1);

            if (prev.size() == 2 && curr.size() == 2) {
                // size
                gain = Math.max(gain, 2);
            } else if (curr.size() == 2 && next.size() == 2) {
                // size
                gain = Math.max(gain, 2);
            } else if (prev.size() == 1 && curr.size() == 2 && next.size() == 1) {
                // size
                gain = Math.max(gain, 1);
            } else if (prev.size() == 2 && next.size() == 2) {

                if (prev.get(0) != next.get(0)) {
                    // size - 1
                    gain = Math.max(gain, 1);
                } else {
                    // size - 2
                    gain = Math.max(gain, 0);
                }
            } else if (prev.size() == 2 && curr.size() == 1 && next.size() == 1) {
                gain = Math.max(gain, 1);
            } else if (prev.size() == 1 && curr.size() == 1 && next.size() == 2) {
                gain = Math.max(gain, 1);
            }

            if (prev.size() == 2 && curr.size() == 1) {
                gain = Math.max(gain, 1);
            } else if (prev.size() == 1 && curr.size() == 2) {

            } else if (prev.size() == 2 && curr.size() == 2) {

            }

        }

        return rArr.size() + gain;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            System.out.println(solv(nums));
        }
        sc.close();
    }
}
