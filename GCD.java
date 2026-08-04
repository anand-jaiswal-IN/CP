public class GCD {
    public static int gcd(int a, int b){
        if(a==b) return a;
        else if (a>b) return gcd(a-b, b);
        else return gcd(a, b-a);
    }
    public static int gcd(int[] nums){
        int g = gcd(nums[0], nums[1]);
        if(nums.length == 2) return g;
        for(int i = 2; i < nums.length; i++){
            g = gcd(g, nums[i]);
        }
        return g;
    }
    public static void main(String[] args) {
        int[] nums = {20,28, 32, 36};
        System.out.println(gcd(nums));
    }
}
