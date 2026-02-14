package leetcode_contests.Weekly_Contest_488;
import java.util.*;

class Pair {
    long first, second;
    Pair(long first, long second){
        this.first = first;
        this.second = second;
    }
    
    boolean isIndicesSame(Object o){
        if(!(o instanceof Pair)) return false;
        Pair p = (Pair)o;
        return first == p.first || second == p.second;
    }
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

public class Leetcode3 {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        // <new int[] {i, j, nums[i]*nums[j]}
        PriorityQueue<long[]> pq = new PriorityQueue<>((long[] a, long[] b) -> Long.compare(b[2], a[2]));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new long[] { i, j, (long)nums1[i] * nums2[j] });
            }
        }

        ArrayList<long[]> arr = new ArrayList<>();

        while (!pq.isEmpty()) {
            arr.add(pq.poll());
        }

        long ans = 0;

        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Pair> pairs = new ArrayList<>();
            pairs.add(new Pair(arr.get(i)[0], arr.get(i)[1]));
            int k_copy = k-1;
            long temp_ans = arr.get(i)[2];

            for (int j = i+1; j < arr.size(); j++) {
                if(k_copy == 0) break;
                // checking that if the pair exists or not
                boolean isExists = false;
                for (Pair pair : pairs) {
                    if(pair.isIndicesSame(new Pair(arr.get(j)[0], arr.get(j)[1]))){
                        isExists = true;
                        break;
                    }
                }
                if(!isExists){
                    pairs.add(new Pair(arr.get(j)[0], arr.get(j)[1]));
                    k_copy--;
                    temp_ans += arr.get(j)[2];
                }
            }
            ans = Math.max(ans, temp_ans);
        }
        return ans;
    }
}
