package uniquePaths;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class Test {

    public static int process(int m, int n, int x, int y) {
        if (x == m-1) {
            return 1;
        }
        if (y == n-1) {
            return 1;
        }
        return process(m, n, x+1, y) + process(m, n, x, y+1);
    }

    public static int dp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int m = 7, n = 3;
        int res = process(m, n, 0, 0);
        System.out.println(res);

        int dp = dp(m, n);
        System.out.println(dp);
    }

}
