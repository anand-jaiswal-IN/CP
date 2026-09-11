package leetcode_contests.Weekly_Contest_483;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class WordsSquare2 {
    public static List<List<String>> wordSquares(String[] words) {
        int N = words.length;

        List<List<String>> topLeft = new ArrayList<>();
        List<List<String>> rightBottom = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;

                if (words[i].charAt(0) == words[j].charAt(0)) {
                    topLeft.add(new ArrayList<>(Arrays.asList(words[i], words[j])));
                }
                if (words[i].charAt(3) == words[j].charAt(3)) {
                    rightBottom.add(new ArrayList<>(Arrays.asList(words[i], words[j])));
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> s1 : topLeft) {
            for (List<String> s2 : rightBottom) {
                if (s1.get(0).charAt(3) == s2.get(0).charAt(0) && s1.get(1).charAt(3) == s2.get(1).charAt(0)) {
                    ans.add(new ArrayList<>(Arrays.asList(s1.get(0), s1.get(1), s2.get(0), s2.get(1))));
                }
            }
        }

        // sorting lexicographically
        ans.sort((a, b) -> {
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0)
                    return cmp;
            }
            return Integer.compare(a.size(), b.size());
        });

        // remove duplicates
        int i = 0;
        while (i < ans.size() - 1) {
            if (ans.get(i).equals(ans.get(i + 1))) {
                ans.remove(i);
            }
            i++;
        }

        // remove the elements which has double or more than one element
        i = 0;
        while (i < ans.size()) {
            HashSet<String> setStr = new HashSet<String>();
            setStr.add(ans.get(i).get(0));
            setStr.add(ans.get(i).get(1));
            setStr.add(ans.get(i).get(2));
            setStr.add(ans.get(i).get(3));

            if (setStr.size() < 4) {
                ans.remove(i);
                continue;
            }
            i++;
        }

        return ans;

    }

    public static void main(String[] args) {
        // String[] words = {"aaay","dgzy","rrrh","aiir","yiih"};
        String[] words = { "kkkj", "jnnj", "kiik", "kbbj" };
        // String[] words = { "ryyr", "rrrr", "ihhr", "illr" };

        System.out.println(wordSquares(words));
    }
}
