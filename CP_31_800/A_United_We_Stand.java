package CP_31_800;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class A_United_We_Stand {
    static void solution(int[] nums, int N) {
        Arrays.sort(nums);
        boolean isAllEqual = true;
        for (int i = 1; i < N; i++) {
            if (nums[i - 1] != nums[i]) {
                isAllEqual = false;
                break;
            }
        }
        if (isAllEqual) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        b.add(nums[0]);

        int i = 1;
        while (i < N) {
            if (nums[i - 1] == nums[i]) {
                b.add(nums[i]);
            } else
                break;
            i++;
        }

        while (i < N) {
            c.add(nums[i]);

            i++;
        }

        System.out.println(b.size() + " " + c.size());

        for (int j = 0; j < b.size(); j++) {
            System.out.print(b.get(j) + " ");
        }
        System.out.println();

        for (int j = 0; j < c.size(); j++) {
            System.out.print(c.get(j) + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            solution(nums, N);
        }
        sc.close();
    }
}