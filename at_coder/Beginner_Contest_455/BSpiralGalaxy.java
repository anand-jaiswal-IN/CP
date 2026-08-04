package at_coder.Beginner_Contest_455;
import java.util.*;

public class BSpiralGalaxy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int H = sc.nextInt();
        int W = sc.nextInt();
        sc.nextLine();
        
        char[][] grid = new char[H + 1][W + 1]; // 1-indexed
        
        for (int i = 1; i <= H; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= W; j++) {
                grid[i][j] = line.charAt(j - 1);
            }
        }
        
        
        int count = 0;
        
        for (int h1 = 1; h1 <= H; h1++) {
            for (int h2 = h1; h2 <= H; h2++) {
                for (int w1 = 1; w1 <= W; w1++) {
                    for (int w2 = w1; w2 <= W; w2++) {
                        if (isPointSymmetric(grid, h1, h2, w1, w2)) {
                            count++;
                        }
                    }
                }
            }
        }
        
        System.out.println(count);
        sc.close();
    }
    
    private static boolean isPointSymmetric(char[][] grid, int h1, int h2, int w1, int w2) {
        for (int i = h1; i <= h2; i++) {
            for (int j = w1; j <= w2; j++) {
                int oppositeI = h1 + h2 - i;
                int oppositeJ = w1 + w2 - j;
                
                if (grid[i][j] != grid[oppositeI][oppositeJ]) {
                    return false;
                }
            }
        }
        return true;
    }
}