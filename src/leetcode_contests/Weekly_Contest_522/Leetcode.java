package leetcode_contests.Weekly_Contest_522;
public class Leetcode {

    public int minRotations(String s) {
        int pt = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            int n = s.charAt(i) - '0';
            if(n != pt){
                int a1 = pt + 1 + (9-n);
                int a2 = (9 - pt) + 1 + n; 
                int a3 = Math.abs(pt - n); 
                ans += Math.min(a1, Math.min(a2, a3));
                pt = n;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode obj = new Leetcode();
        String s = "1200210200";
        int r = obj.minRotations(s);
        System.out.println(r);
    }
}