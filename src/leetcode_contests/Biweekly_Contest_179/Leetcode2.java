package leetcode_contests.Biweekly_Contest_179;

import java.util.ArrayList;

public class Leetcode2 {
    static ArrayList<Integer> possibleXors = new ArrayList<>();

    public static int minCost(int[][] grid) {

        minCostHelper(grid, 0, 0, 0);

        int ans = Integer.MAX_VALUE;
        for (Integer i : possibleXors) {
            ans = Math.min(ans, i);
        }
        return ans;
    }

    private static void minCostHelper(int[][] grid, int row, int col, int xor) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            possibleXors.add(xor ^ grid[row][col]);
            return;
        }
        if (row >= grid.length || col >= grid[0].length)
            return;
        
        minCostHelper(grid, row, col + 1, xor ^ grid[row][col]);
        minCostHelper(grid, row + 1, col, xor ^ grid[row][col]);
    }


    

    public static void main(String[] args) {
        int[][] grid = { { 1, 2 }, { 3, 4 } };
        System.out.println(minCost(grid));
    }
}
