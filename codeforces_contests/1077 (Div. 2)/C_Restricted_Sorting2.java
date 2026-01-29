import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C_Restricted_Sorting2 {
    public static int solution(List<Integer> nums) {
        int size = nums.size();

        int lowVal = (int) 2e9;
        int highVal = (int) -2e9;

        for (int value : nums) {
            if (value < lowVal)
                lowVal = value;
            if (value > highVal)
                highVal = value;
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