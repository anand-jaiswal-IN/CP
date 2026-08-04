package leetcode_contests.Biweekly_Contest_176;
public class Leetcode {
    public static String mapWordWeights(String[] words, int[] weights) {
        int[] wordWeight = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int totalWeight = 0;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                totalWeight += weights[ch-'a'];
            }
            wordWeight[i] = totalWeight%26;
        }
        String temp = "zyxwvutsrqponmlkjihgfedcba";
        String ans = "";

        for (int i = 0; i < wordWeight.length; i++) {
            ans += temp.charAt(wordWeight[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = {"a","b","c"};
        int[] weights = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(mapWordWeights(words, weights));
    }
}
