package START221;
import java.util.HashMap;
import java.util.Scanner;

public class Odd_String {

    public static boolean solution(String s){
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                if(hm.get(ch) == 2) return false;
                hm.put(ch, hm.get(ch) + 1);
            }else{
                hm.put(ch, 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            String s = sc.next();
            System.out.println(solution(s) ? "YES": "NO");
        }
        sc.close();
    }
}