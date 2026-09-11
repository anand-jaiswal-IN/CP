package CP_31_900;

import java.util.*;

public class B_Permutation_Swap {
    public static int gcd(int a, int b){
        if(a==b) return a;
        else if (a>b) return gcd(a-b, b);
        else return gcd(a, b-a);
    }
    public static int gcd(ArrayList<Integer> nums){
        int g = gcd(nums.get(0), nums.get(1));
        if(nums.size() == 2) return g;
        for(int i = 2; i < nums.size(); i++){
            g = gcd(g, nums.get(i));
        }
        return g;
    }
    public static int gcd2(int a, int b){
        if (b == 0) {
            return a; // Base case: GCD is 'a' when 'b' is 0
        }
        // Recursive call with 'b' and the remainder of 'a' divided by 'b'
        return gcd2(b, a % b);
    }
    public static int solution(int[] nums, int N){
        ArrayList<Integer> ns = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int d = Math.abs((i+1)-nums[i]);
            if(d != 0) ns.add(d);
        }
        return gcd(ns);
    }
    public static int solution2(int[] nums, int N){
        int g = Math.abs(1 - nums[0]);

        for (int i = 1; i < N; i++) {
            g = gcd2(g, Math.abs((i+1) - nums[i]));
        }
        return g;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solution2(nums, N));
            t--;
        }
        sc.close();
        // int[] nums = {1 ,5 ,3 ,4 ,2 ,6};
        // System.out.println(solution2(nums, nums.length));
    }
}