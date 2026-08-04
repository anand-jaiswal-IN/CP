import java.util.ArrayList;

public class MinimumCosttoMergeSortedLists {

    public static int[] merge(int[] a, int[] b) {
        int[] mergedArr = new int[a.length + b.length];

        int i = 0, j = 0, c = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                mergedArr[c++] = a[i++];
            } else {
                mergedArr[c++] = b[j++];
            }
        }

        while (i < a.length) {
            mergedArr[c++] = a[i++];
        }

        while (j < b.length) {
            mergedArr[c++] = b[j++];
        }
        return mergedArr;
    }

    public static long minMergeCost(int[][] lists) {
        ArrayList<int[]> lsts = new ArrayList<>();

        // adding the elements into lsts
        for (int i = 0; i < lists.length; i++) {
            lsts.add(lists[i]);
        }

        long totalCost = 0;
        while (lsts.size() > 1) {

            long minCost = Integer.MAX_VALUE;
            int idx1 = 0, idx2 = 0;

            for (int i = 0; i < lsts.size(); i++) {
                for (int j = 0; j < lsts.size(); j++) {
                    if (i == j)
                        continue;

                    int median_i_idx = (lsts.get(i).length % 2 == 0) ? (lsts.get(i).length / 2) - 1
                            : (lsts.get(i).length / 2);
                    int median_j_idx = (lsts.get(j).length % 2 == 0) ? (lsts.get(j).length / 2) - 1
                            : (lsts.get(j).length / 2);

                    long t = lsts.get(i).length + lsts.get(j).length
                            + Math.abs(lsts.get(i)[median_i_idx] - lsts.get(j)[median_j_idx]);

                    if (minCost > t) {
                        idx1 = i;
                        idx2 = j;
                        minCost = t;
                    }
                }
            }

            totalCost += minCost;
            int[] mergedArr = merge(lsts.get(idx1), lsts.get(idx2));

            lsts.remove(Math.max(idx1, idx2));
            lsts.remove(Math.min(idx1, idx2));
            lsts.add(mergedArr);

        }
        return totalCost;
    }

    public static void main(String[] args) {
        // int[][] lists = new int[][] { { 1, 3, 5 }, { 2, 4 }, { 6, 7, 8 } };
        // int[][] lists = new int[][] { { 1, 1, 5 }, { 1, 4, 7, 8 } };
        // int[][] lists = new int[][] { { 1 }, { 1 } };
        int[][] lists = new int[][] { { 7, 10, 10 }, { 4 }, { 2, 6, 10 } };
        long ans = minMergeCost(lists);
        System.out.println(ans);
    }
}
