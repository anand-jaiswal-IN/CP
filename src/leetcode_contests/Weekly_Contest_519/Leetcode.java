package leetcode_contests.Weekly_Contest_519;

import java.util.*;

public class Leetcode {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        List<List<Integer>> mat = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            List<Integer> t = new ArrayList<>();
            for(int j = 0; j < n; j++){
                t.add(grid[i][j]);
            }
            mat.add(t);
        }

        // rowShift
        for(int i = 0; i < n; i++){
            rowSh(mat, i, rowShift[i]%n);
        }
        // colShift
        for(int i = 0; i < n; i++){
            colSh(mat, i, colShift[i]%n);
        }
        int[][] ans = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = mat.get(i).get(j);
            }
        }
        return ans;
    }
    public void rowSh(List<List<Integer>> mat, int rowIdx, int v){
        List<Integer> r = mat.get(rowIdx);
        while(v-- > 0){
            r.add(r.get(0));
            r.remove(0);
        }
    }
    public void colSh(List<List<Integer>> mat, int colIdx, int v){
        List<Integer> cols = new ArrayList<>();
        int n = mat.size();
        
        for(int i = 0; i < n; i++){
            cols.add(mat.get(i).get(colIdx));
        }
        while(v-- > 0){
            cols.add(cols.get(0));
            cols.remove(0);
        }
        for(int i = 0; i < n; i++){
            mat.get(i).set(colIdx, cols.get(i));
        }
    }
    
    
    
    public static void main(String[] args) {
        Leetcode obj = new Leetcode();
        int n = 3;
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int[] rowShift = {1,2,0};
        int[] colShift = {2,2,1};
        int[][] r = obj.cyclicShift(n, grid, rowShift, colShift);
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(r[i]));
        }
    }
}