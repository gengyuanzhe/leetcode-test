package learning.leetcode;

public class Q0647CountSubstrings {

    // 中心向两边扩展
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countSubstringsWithCenter(s, i, i);
            result += countSubstringsWithCenter(s, i, i + 1);
        }
        return result;
    }

    private static int countSubstringsWithCenter(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }

    // 动态规划，其实没必要
    public int countSubstrings1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // 是否不满足回文条件

        int res = n;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (!dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    res++;
                } else {
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }
}
