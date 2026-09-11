package leetcode_contests.Weekely_Contest_512;

import java.util.Arrays;

public class MinimumCostPathwithAlternatingDirectionsIII {
    public boolean isValidPos(int[] pos, int[][] penalty) {
        int row = pos[0];
        int col = pos[1];

        if (row >= 0 && col >= 0 && row < penalty.length && col < penalty[0].length)
            return true;
        return false;
    }

    public long minCost(int m, int n, int[][] penalty) {
        return helper(new int[] { 0, 0 }, new int[] { -1, -1 }, 1, 1, penalty);
    }

    public long helper(int[] pos, int[] prev, long cost, int actionNumber, int[][] penalty) {

        // row -> pos[0] | col -> pos[1]

        int i = pos[0];
        int j = pos[1];

        if (i >= penalty.length || j >= penalty[0].length)
            return Long.MAX_VALUE;
        if (i == penalty.length - 1 && j == penalty[0].length - 1)
            return cost;

        // even action number
        // can move left and up

        long same = Long.MAX_VALUE, left = Long.MAX_VALUE, up = Long.MAX_VALUE, right = Long.MAX_VALUE,
                down = Long.MAX_VALUE;

        // move the same
        if (!Arrays.equals(pos, prev) && isValidPos(pos, penalty))
            same = helper(pos, pos, cost + penalty[i][j], actionNumber + 1, penalty);

        int[] newPos;

        if (actionNumber % 2 == 0) {

            // move left
            newPos = new int[] { i, j - 1 };
            if (!Arrays.equals(newPos, prev) && isValidPos(newPos, penalty))
                left = helper(newPos, pos, cost + ((i + 1) * (j)), actionNumber + 1, penalty);

            // move up
            newPos = new int[] { i - 1, j };
            if (!Arrays.equals(newPos, prev) && isValidPos(newPos, penalty))
                up = helper(newPos, pos, cost + ((i) * (j + 1)), actionNumber + 1, penalty);

            // move right
            newPos = new int[] { i, j + 1 };
            if (!Arrays.equals(newPos, prev) && isValidPos(newPos, penalty))
                right = helper(newPos, pos, cost + ((i + 1) * (j + 2)) + penalty[i][j], actionNumber + 1,
                        penalty);

            // move down
            newPos = new int[] { i + 1, j };
            if (!Arrays.equals(newPos, prev) && isValidPos(newPos, penalty))
                down = helper(newPos, pos, cost + ((i + 2) * (j + 1)) + penalty[i][j], actionNumber + 1, penalty);

        } else {
            // move left
            newPos = new int[] { i, j - 1 };
            if (!Arrays.equals(newPos, prev) && isValidPos(newPos, penalty))
                left = helper(newPos, pos, cost + ((i + 1) * (j)) + penalty[i][j], actionNumber + 1, penalty);

            // move up
            newPos = new int[] { i - 1, j };
            if (!Arrays.equals(newPos, prev) && isValidPos(newPos, penalty))
                up = helper(newPos, pos, cost + ((i) * (j + 1)), actionNumber + 1, penalty);

            // move right
            newPos = new int[] { i, j + 1 };
            if (!Arrays.equals(newPos, prev) && isValidPos(newPos, penalty))
                right = helper(newPos, pos, cost + ((i + 1) * (j + 2)), actionNumber + 1,
                        penalty);

            // move down
            newPos = new int[] { i + 1, j };
            if (!Arrays.equals(newPos, prev) && isValidPos(newPos, penalty))
                down = helper(newPos, pos, cost + ((i + 2) * (j + 1)), actionNumber + 1, penalty);
        }

        return Math.min(same, Math.min(left, Math.min(up, Math.min(right, down))));
    }

    public static void main(String[] args) {
        MinimumCostPathwithAlternatingDirectionsIII obj = new MinimumCostPathwithAlternatingDirectionsIII();
        int[][] penalty = { { 5, 3 }, { 1, 4 } };
        long r = obj.minCost(penalty.length, penalty[0].length, penalty);
        System.out.println(r);
    }
}
