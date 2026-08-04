package START231;
import java.util.Scanner;
import java.util.Arrays;

public class Double_Discount {
    public static int givingDiscountedPrice(int a, int b){
        if(a >= b){
            int smallerDiscount = ((int)(a*0.5) < 100) ? (int)(a*0.5) : 100;
            return (a - smallerDiscount) + b;
        }else{
            int smallerDiscount = ((int)(b*0.5) < 100) ? (int)(b*0.5) : 100;
            return (b - smallerDiscount) + a;
        }
    }
    public static int solution(int n, int k, int[] rupees, int[] tastiness){
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = tastiness[i];
            arr[i][1] = rupees[i];
        }
        // sorting according to tastiness
        Arrays.sort(arr, (int[] a, int[] b) -> b[0] - a[0]);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] item1 = arr[i];
                int[] item2 = arr[j];

                if (givingDiscountedPrice(item1[1], item2[1]) <= k) ans = Math.max(ans, item1[0] + item2[0]);
            }
        }
        return ans;

    }
    public static int solution2(int n, int k, int[] rupees, int[] tastiness){
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                if (givingDiscountedPrice(rupees[i], rupees[j]) <= k) ans = Math.max(ans, tastiness[i] + tastiness[j]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] rupees = new int[n];
            for (int i = 0; i < n; i++) {
                rupees[i] = sc.nextInt();
            }
            int[] tastiness = new int[n];
            for (int i = 0; i < n; i++) {
                tastiness[i] = sc.nextInt();
            }

            System.out.println(solution2(n, k, rupees, tastiness));
        }
        sc.close();
    }
}