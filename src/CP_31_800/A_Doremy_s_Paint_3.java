package CP_31_800;
import java.util.*;

public class A_Doremy_s_Paint_3 {
    public static boolean solution(int[] arr, int n){
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(m.containsKey(arr[i])) m.put(arr[i], m.get(arr[i]) + 1);
            else m.put(arr[i], 1);
        }
        

        if(m.size() == 1) return true;

        if(m.size() == 2){
            int[] vals = new int[2];
            int k = 0;
            for(int i : m.values()){
                vals[k++] = i;
            }
            if(Math.abs(vals[0] - vals[1]) <= 1) return true;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr, n) ? "Yes" : "No" );
            t--;
        }
        sc.close();
    }
}