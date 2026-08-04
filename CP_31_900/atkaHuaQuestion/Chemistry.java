// https://codeforces.com/problemset/problem/1883/B

package CP_31_900.atkaHuaQuestion;
import java.util.*;

public class Chemistry {
    public static boolean solution(String s, int k, int n){
        HashMap<Character, Integer> map = new HashMap<>();
        // int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) +1);
            }else map.put(ch, 1);
        }

        // total odd occurences of letters - k <= 1 => then remaining string make palindrome
        int odd_occurences = 0;

        for(Integer i : map.values()){
            if(i%2==1) odd_occurences += 1;
        }
        if(odd_occurences - k <= 1) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            System.out.println(solution(s, k, n) ? "YES" : "NO");
            t--;
        }
        sc.close();

        // System.out.println(solution("abaac", 3));
    }
}