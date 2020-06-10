package longestCommonSubsequence;

public class Test {

    public static int process(char[] s1, char[] s2) {
        int[][] dp = new int[s1.length][s2.length];
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;
        for (int i=1; i<s1.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], s1[i] == s2[0] ? 1 : 0);
        }
        for (int j=1; j<s2.length; j++) {
            dp[0][j] = Math.max(dp[0][j-1], s1[0] == s2[j] ? 1: 0);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (s1[i] == s2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        return dp[s1.length-1][s2.length-1];
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        int process = process(s1.toCharArray(), s2.toCharArray());
        System.out.println(process);
    }

}
