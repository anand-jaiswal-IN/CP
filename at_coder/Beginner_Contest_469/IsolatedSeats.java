package at_coder.Beginner_Contest_469;
import java.util.Scanner;

/**
 * IsolatedSeats
 */
public class IsolatedSeats {

    public static int solution(String s){
        if(s.length() == 1){
            if(s.charAt(0) == 'x') return 1;
            return 0;
        }

        int ans = 0;

        if(s.charAt(0) == 'x' && s.charAt(1) == 'x') ans++;
        if(s.charAt(s.length()-1) == 'x' && s.charAt(s.length()-2) == 'x') ans++;

        for (int i = 1; i < s.length()-1; i++) {
            char c = s.charAt(i);
            char c_left = s.charAt(i-1);
            char c_right = s.charAt(i+1);
            
            if(c == 'x' && c_left == 'x' && c_right == 'x'){
                ans++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(solution(s));
        sc.close();
    }
}