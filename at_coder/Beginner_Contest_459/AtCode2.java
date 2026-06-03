package at_coder.Beginner_Contest_459;
import java.util.Scanner;

public class AtCode2 {
    public static int f(char ch){
        if('a' <= ch && ch <= 'c'){
            return 2;
        }
        else if('d' <= ch && ch <= 'f'){
            return 3;
        }
        else if('g' <= ch && ch <= 'i'){
            return 4;
        }
        else if('j' <= ch && ch <= 'l'){
            return 5;
        }
        else if('m' <= ch && ch <= 'o'){
            return 6;
        }
        else if('p' <= ch && ch <= 's'){
            return 7;
        }
        else if('t' <= ch && ch <= 'v'){
            return 8;
        }
        else if('w' <= ch && ch <= 'z'){
            return 9;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String ans = "";
        while (t-- > 0) {
            String s = sc.next();
            ans += f(s.charAt(0));
        }
        System.out.println(ans);
        sc.close();
    }
}
