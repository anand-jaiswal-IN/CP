package START225;
import java.util.Scanner;

public class Plus_Minus_Split {
    static boolean solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean temp_ans = true;

            for (int j = i; j < arr.length; j++) {
                if (arr[i] - arr[j] != 0) {
                    temp_ans = false;
                    break;
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] + arr[j] != 0) {
                    temp_ans = false;
                    break;
                }
            }

            if (temp_ans)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr) ? "Yes" : "No");
        }
        sc.close();
    }
}