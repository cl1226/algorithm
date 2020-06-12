package minPathSum;

import utils.Utils;

public class Test {

    public static int process(int[][] grid, int m, int n, int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return grid[x][y];
        }
        if (x == m - 1) {
            return grid[x][y] + process(grid, m, n, x, y+1);
        }
        if (y == n - 1) {
            return grid[x][y] + process(grid, m, n, x+1, y);
        }

        return Math.min(grid[x][y] + process(grid, m, n, x, y+1),
                grid[x][y] + process(grid, m, n, x+1, y));
    }

    public static int dp(int[][] grid, int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j < n-1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }
                if (j == n-1 && i < m-1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }
                if (i < m-1 && j < n-1) {
                    dp[i][j] = Math.min(grid[i][j] +dp[i][j+1], grid[i][j] + dp[i+1][j]);
                }
            }
        }
        Utils.printDP(dp);
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int m = grid.length;
        int n = grid[0].length;
        int p = process(grid, m, n, 0, 0);
        System.out.println(p);

        int dp = dp(grid, m, n);
        System.out.println(dp);
    }

}
