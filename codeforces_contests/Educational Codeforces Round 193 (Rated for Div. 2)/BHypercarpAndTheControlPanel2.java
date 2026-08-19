import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BHypercarpAndTheControlPanel2 {

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
        List<List<Integer>> reduced = reduce(nums);

        // int[] idx = {-1, -1};
        int gain = 0;

        for(int i = 1; i < reduced.size(); i++){
            List<Integer> prev = reduced.get(i-1);
            List<Integer> curr = reduced.get(i);

            if(prev.size() == 2 && curr.size() == 2){
                gain = 2;
            }else if(prev.size() == 1 && curr.size() == 2 || prev.size() == 2 && curr.size() == 1){
                if(gain < 2){
                    if(i + 1 < reduced.size()){
                        List<Integer> next = reduced.get(i+1);
                        if(next.size() == 2 && prev.get(0) == next.get(0)){
                            i++;
                            continue;
                        }
                    }

                    gain = 1;
                }
            }
        }
        return reduced.size() + gain;
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