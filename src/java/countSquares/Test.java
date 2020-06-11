package countSquares;

/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class Test {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1,1},
                {1,1,1,0},
                {1,1,1,1},
                {1,0,1,1}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = matrix[m-1][i] == 1 ? 1 : 0;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = matrix[i][n-1] == 1 ? 1 : 0;
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if ((dp[i][j] = matrix[i][j]) == 0) {
                    continue;
                }
                dp[i][j] = 1;
                if (dp[i+1][j+1] > 0 && dp[i+1][j] > 0 && dp[i][j+1] > 0) {
                    dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1])) + 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                sum += dp[i][j];
            }
        }
        System.out.println(sum);
    }

}
