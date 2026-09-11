import java.util.*;

public class B_Reverse_a_Permutation2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] p = new int[n + 1];      
            int[] pos = new int[n + 1];   

            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
                pos[p[i]] = i; 
            }

            int l = -1, r = -1;

            for (int i = 1; i <= n; i++) {
                int want = n - i + 1;   
                if (p[i] != want) {
                    l = i;
                    r = pos[want];
                    break;
                }
            }

            if (l != -1) {
                while (l < r) {
                    int temp = p[l];
                    p[l] = p[r];
                    p[r] = temp;
                    l++;
                    r--;
                }
            }

            // printing
            for (int i = 1; i <= n; i++) {
                System.out.print(p[i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
