package DSAMONDAY16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestUniqueSubstring {
    public static List<List<Integer>> uniqueSubsets(int[] multiset) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>());
        List<Integer> t = new ArrayList<>();
        t.add(multiset[0]);
        ans.add(t);

        for (int i = 1; i < multiset.length; i++) {
            List<List<Integer>> tempAns = new ArrayList<>();

            for (int j = 0; j < ans.size(); j++) {

                tempAns.add(new ArrayList<>(ans.get(j)));

                List<Integer> k = new ArrayList<>(ans.get(j));
                k.add(multiset[i]);
                tempAns.add(k);
            }

            ans = tempAns;
        }

        HashMap<List<Integer>, Boolean> m = new HashMap<>();

        List<List<Integer>> finalAns = new ArrayList<>();

        for (List<Integer> list : ans) {
            if (!m.containsKey(list)) {
                finalAns.add(list);
            }
            m.put(list, true);
        }

        return finalAns;

    }

    public static List<List<Integer>> uniqueSubsets2(int[] multiset) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int i = 0; i < multiset.length; i++) {
            uniqueSubsets2Helper(multiset[i], ans, ans.size());
        }
        return ans;
    }

    public static void uniqueSubsets2Helper(int n, List<List<Integer>> subsets, int N) {
        for (int i = 0; i < N; i++) {
            List<Integer> t = new ArrayList<>(subsets.get(i));
            t.add(n);

            if(!subsets.contains(t))
                subsets.add(t);
        }
    }

    public static void main(String[] args) {
        int[] multiset = { 1, 2, 2 };
        System.out.println(uniqueSubsets2(multiset));
    }
}
