import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C_Restricted_Sorting {

    public static int solution3(List<Integer> arr) {
        int n = arr.size();
        List<Integer> arr_copy = new ArrayList<>(arr);
        arr_copy.sort((Integer a, Integer b) -> a.compareTo(b));

        int k = 0;
        for (int i = 0; i < n; i++) {
            int p = Math.abs(arr.get(i) - arr_copy.get(i));
            k = Math.max(k, p);
        }
        return k == 0 ? -1 : k;
    }

    public static int find(List<Integer> arr, int startIdx, int target) {
        for (int i = startIdx; i < arr.size(); i++) {
            if (arr.get(i) == target)
                return i;
        }
        return -1;
    }

    public static int solution2(List<Integer> arr, int min, int max) {
        int n = arr.size();
        int k = max - min;

        List<Integer> arr_copy = new ArrayList<>(arr);
        arr_copy.sort((Integer a, Integer b) -> a.compareTo(b));

        for (int j = k; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (Math.abs(arr.get(i) - arr_copy.get(i)) != j) {
                    break;
                }
            }
        }
        return -1;

    }

    public static int solution4(List<Integer> arr) {
        int n = arr.size();

        int x = (int) 2e9;
        int y = (int) -2e9;

        // find min and max
        for (int val : arr) {
            if (val < x)
                x = val;
            if (val > y)
                y = val;
        }

        // check if already sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return -1;
        }

        // create sorted copy
        List<Integer> b = new ArrayList<>(arr);
        Collections.sort(b);

        int l = 1, r = 1_000_000_000;
        int k = 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            long u = (long) y - m;
            long v = (long) x + m;

            boolean possible = true;

            if (u < v) {
                for (int i = 0; i < n; i++) {
                    int ai = arr.get(i);
                    if (ai > u && ai < v) {
                        if (ai != b.get(i)) {
                            possible = false;
                            break;
                        }
                    }
                }
            }

            if (possible) {
                k = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return k;
    }

    // private static boolean aiEqualsSorted(int a, int b) {
    // return a == b;
    // }

    public static int solution(List<Integer> nums) {
    int size = nums.size();

    int lowVal = (int) 2e9;
    int highVal = (int) -2e9;

    for (int value : nums) {
        if (value < lowVal) lowVal = value;
        if (value > highVal) highVal = value;
    }

    boolean ordered = true;
    for (int idx = 0; idx < size - 1; idx++) {
        if (nums.get(idx) > nums.get(idx + 1)) {
            ordered = false;
            break;
        }
    }

    if (ordered) {
        return -1;
    }

    List<Integer> target = new ArrayList<>(nums);
    Collections.sort(target);

    int left = 1, right = 1_000_000_000;
    int answer = 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        long upper = (long) highVal - mid;
        long lower = (long) lowVal + mid;

        boolean valid = true;

        if (upper < lower) {
            for (int pos = 0; pos < size; pos++) {
                int cur = nums.get(pos);
                if (cur > upper && cur < lower) {
                    if (cur != target.get(pos)) {
                        valid = false;
                        break;
                    }
                }
            }
        }

        if (valid) {
            answer = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return answer;
}



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            System.out.println(solution(arr));
        }
        sc.close();
    }
}