package leetcode_contests.Weekly_Contest_482;

public class MinimumCosttoAcquireRequiredItems {
    public static long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long minimumCost = Math.min(cost1 + cost2, costBoth);
        if(need1 == 0 && need2 == 0) return 0;
        if(need1 == 0) return Math.min(minimumCost, cost2) * need2;
        if(need2 == 0) return Math.min(minimumCost, cost1) * need1;

        long ans = 0; 
        
        int minimumNeed = Math.min(need1, need2);
    
        ans += (minimumCost * minimumNeed);
    
        ans += ((need1-minimumNeed) * Math.min(minimumCost, cost1));
        ans += ((need2-minimumNeed) * Math.min(minimumCost, cost2));

        return ans;
    }
    public static void main(String[] args) {
        // System.out.println(minimumCost(5, 4, 15, 2, 3));
        System.out.println(minimumCost(388168, 988887, 336014, 50411, 252237));
    }
}
