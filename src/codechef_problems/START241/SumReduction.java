package START241;
import java.util.ArrayList;
import java.util.Scanner;

public class SumReduction {

    public static boolean sol(ArrayList<Integer> arr){
        if(arr.size() == 1) return true;

        while (arr.size() > 1) {
            int f = -1, s = -1;
            for (int i = 0; i < arr.size(); i++) {
                for (int j = i+1; j < arr.size(); j++) {
                    if((arr.get(i) & arr.get(j)) == 0){
                        f = i;
                        s = j;
                        break;
                    }
                }
                if(f != -1 && s != -1) break;
            }
            
            if(f == -1 && s == -1) return false;

            ArrayList<Integer> arr2 = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if(i == f || i == s) continue;
                arr2.add(arr.get(i));
            }
            arr2.add(arr.get(f) + arr.get(s));
            return sol(arr2);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            System.out.println(sol(arr) ? "Yes" : "No");
        }
        sc.close();
    }
}