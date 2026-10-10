package leetcode_contests.Weekly_Contest_522;
public class Leetcode2 {
    public int minRotations(int n, String s) {
        int a1 = h(s);
        String revS = new StringBuilder(s).reverse().toString();
        int a2 = h(revS);

        int[] prefix = new int[n];

        int pt = 0;
        for(int i = 0; i < n; i++){
            int p = s.charAt(i) - '0';
            prefix[i] = calcMin(pt, p);
            pt = p;
        }

        int[] revix = new int[n];
        int revixTotalSum = 0;
        pt = revS.charAt(0) - '0';

        for(int i = 1; i < n; i++){
            int p = revS.charAt(i) - '0';
            revix[i] = calcMin(pt, p);
            revixTotalSum += revix[i];
            pt = p;
        }

        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int revSum = 0;
        for(int i = 0; i < n; i++){
            sum += prefix[i];
            revSum += revix[n-1-i];
            ans = Math.min(ans, sum + (revixTotalSum - revSum) + calcMin(s.charAt(i) - '0', revS.charAt(0) - '0'));
        }

        return Math.min(a1, Math.min(a2, ans));

    }

    public int h(String s) {
        int pt = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n != pt) {
                ans += calcMin(pt, n);
                pt = n;
            }
        }
        return ans;
    }

    public int calcMin(int pt, int n) {
        int a1 = pt + 1 + (9 - n);
        int a2 = (9 - pt) + 1 + n;
        int a3 = Math.abs(pt - n);
        return Math.min(a1, Math.min(a2, a3));
    }

    public static void main(String[] args) {
        Leetcode2 obj = new Leetcode2();
        int n = 4;
        String s = "2916";
        int r = obj.minRotations(n, s);
        System.out.println(r);
    }
}
