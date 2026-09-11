package START241;
import java.util.Scanner;

public class No3Equal {
    public static int sol(String s){
        int ans = 0;
        for (int i = 0; i < s.length()-2; i++) {
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i + 1) == s.charAt(i + 2)){
                ans++;
                i+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(sol(s));
        }
        sc.close();
    }
}