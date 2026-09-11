// https://leetcode.com/problems/minimum-cost-path-with-at-most-k-turns

import java.util.*;

public class Leetcode2 {
    int ans;
    public int minCost(int[][] grid, int k) {
        ans = Integer.MAX_VALUE;
        g(grid, k, new int[] {-1,-1}, new int[] {0,0}, 0, -1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public boolean correctNewCell(int[][] grid, int[] cell){
        int row = cell[0], col = cell[1];
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) return  true;
        return false;
    }
    public boolean g(int[][] grid, int k, int[] prevCell, int[] currCell, int pathSum, int prevDir){
        if(k < 0) return false;
        
        if(currCell[0] == grid.length - 1 && currCell[1] == grid[0].length-1 && k >= 0){
            pathSum += grid[currCell[0]][currCell[1]];
            ans = Math.min(ans, pathSum);
            return true;
        }

        int[][] dirToMove = {{0,1}, {0,-1},{1,0},{-1,0}}; // R, L, D, U

        for(int i = 0; i < dirToMove.length; i++){
            int[] newCellToMove = new int[] {currCell[0]+ dirToMove[i][0], currCell[1] + dirToMove[i][1]};
            if(correctNewCell(grid, newCellToMove) && !Arrays.equals(newCellToMove, prevCell)){
                if(prevDir == i || prevDir == -1){
                    g(grid, k, currCell, newCellToMove, pathSum + grid[currCell[0]][currCell[1]], i);
                }else{
                    g(grid, k-1, currCell, newCellToMove, pathSum + grid[currCell[0]][currCell[1]], i);
                }
            }
        }

        return false;
    }
    static void main(String[] args) {
        int[][] grid = {{1,9},{3,4}};
        int k = 0;
        Leetcode2 obj = new Leetcode2();

        int r = obj.minCost(grid, k);
        System.out.println(r);
    }
}
