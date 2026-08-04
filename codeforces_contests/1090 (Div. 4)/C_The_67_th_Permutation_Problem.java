// import java.util.ArrayList;
import java.util.Scanner;

public class C_The_67_th_Permutation_Problem {
    public static void solution(int n){
        int[] medians = new int[n];
        medians[0] = n+1;
        for (int i = 1; i < n; i++) {
            medians[i] = medians[i-1] + 2;
        }
        int mi = 0;
        int lesser = n;

        for (int i = 0; i < n; i++) {
            System.out.print(medians[mi] + " " + (medians[mi++] + 1) + " " + lesser-- + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            solution(n);
        }
        sc.close();
    }
}