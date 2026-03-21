package START230;
import java.util.Scanner;
import java.util.ArrayList;

public class Reselling_Items {

    public static int solution(ArrayList<Integer> nums, int k) {
        nums.sort((a, b) -> b-a);

        int profit = 0;
        int c = 0;

        while (k > 0) {
            int p = nums.get(c++) - 5;
            if(p < 0) return profit;
            profit += p;
            k--;
        }
        while (c < nums.size()) {
            int p = nums.get(c++) - 10;
            if(p < 0) return profit;
            profit += p;
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();

            ArrayList<Integer> nums = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                nums.add(sc.nextInt());
            }

            System.out.println(solution(nums, k));
        }
        sc.close();
    }
}