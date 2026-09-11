// https://leetcode.com/problems/count-robot-groups/

public class Leetcode {

    public int countGroups(int[] position, int[] speed, int distance) {
        int n = speed.length;
        int ans = n;
        int mn = speed[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (speed[i] > mn || position[i + 1] - position[i] <= distance) {
                ans--;
            } else {
                mn = speed[i];
            }
        }
        return ans;
    }

    static void main(String[] args) {
        int[] position = { 162, 432, 535 };
        int[] speed = { 68, 560, 409 };
        int distance = 103;

        Leetcode obj = new Leetcode();
        System.out.println(obj.countGroups(position, speed, distance));
    }
}
