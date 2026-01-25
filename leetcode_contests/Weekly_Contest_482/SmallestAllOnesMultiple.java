package leetcode_contests.Weekly_Contest_482;

public class SmallestAllOnesMultiple {
    public static int minAllOneMultiple(int k) {
        String s = "1";
        int i = 1;
        
        while(i <= k){
            if(Long.parseLong(s) % k == 0) return i;
            s += "1";
            i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(minAllOneMultiple(3));
        System.out.println(minAllOneMultiple(7));
        System.out.println(minAllOneMultiple(2));
    }
}
