// https://codeforces.com/problemset/problem/1855/B

package CP_31_900;

import java.util.*;
public class B_Longest_Divisors_Interval {
    public static long solution(long n){
        int i = 1;
        while(n%i == 0) {
            i++;
        }
        return i-1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
        System.out.println(solution(sc.nextLong()));
        t--;
        }
        sc.close();
    }
}