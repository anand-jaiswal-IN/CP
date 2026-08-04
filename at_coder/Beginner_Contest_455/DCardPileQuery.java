package at_coder.Beginner_Contest_455;

import java.util.*;

public class DCardPileQuery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Stack<Integer>> stacks = new ArrayList<>();
        HashMap<Integer, Integer> knowTheNLoc = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Stack<Integer> s = new Stack<>();
            s.push(i);
            stacks.add(s);
            knowTheNLoc.put(i, i);
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int q1 = sc.nextInt() - 1;
            int q2 = sc.nextInt() - 1;

            Stack<Integer> s1 = stacks.get(knowTheNLoc.get(q1));
            Stack<Integer> s2 = stacks.get(knowTheNLoc.get(q2));

            arrange(q1, q2, s1, s2, knowTheNLoc);

        }
        for (int i = 0; i < n; i++) {
            System.out.print(stacks.get(i).size() + " ");
        }
        System.out.println();
        sc.close();
    }

    private static void arrange(int q1, int q2, Stack<Integer> s1, Stack<Integer> s2,
            HashMap<Integer, Integer> knowTheNLoc) {
        Stack<Integer> temp1 = new Stack<>();

        while (s1.peek() != q1) {
            int popped = s1.pop();
            temp1.push(popped);
            knowTheNLoc.put(popped, knowTheNLoc.get(q2));
        }
        temp1.push(s1.pop());
        knowTheNLoc.put(q1, knowTheNLoc.get(q2));

        Stack<Integer> temp2 = new Stack<>();
        while (s2.peek() != q2) {
            int popped = s2.pop();
            temp2.push(popped);
        }
        while (!temp1.isEmpty()) {
            s2.push(temp1.pop());
        }
        while (!temp2.isEmpty()) {
            s2.push(temp2.pop());
        }

    }
}