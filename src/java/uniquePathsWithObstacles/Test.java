package uniquePathsWithObstacles;

import utils.Utils;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class Test {

    public static int process(int[][] grid, int x, int y) {
        if (grid[grid.length-1][grid[0].length-1] == 1) {
            return 0;
        }
        if (x == grid.length - 1 && y == grid[0].length -1) {
            return 1;
        }
        if (grid[x][y] == 1) {
            return 0;
        }

        if (x == grid.length - 1) {
            return process(grid, x, y+1);
        } else if (y == grid[0].length - 1) {
            return process(grid, x+1, y);
        }
        int p = 0;
        if (x < grid.length - 1 && y < grid[0].length - 1) {
            p = process(grid, x ,y+1) + process(grid, x+1, y);
        }
        return p;
    }

    public static int dp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        if (grid[m-1][n-1] == 1) {
            dp[m-1][n-1] = 0;
        } else {
            dp[m-1][n-1] = 1;
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >=0 ; j--) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == m-1 && j < n-1) {
                        dp[i][j] = dp[i][j+1];
                    }
                    if (j == n-1 && i < m-1) {
                        dp[i][j] = dp[i+1][j];
                    }
                    if (i < m-1 && j < n-1) {
                        dp[i][j] = dp[i][j+1] + dp[i+1][j];
                    }
                }
            }
        }
        Utils.printDP(dp);
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1},
                {0,0,0},
                {1,0,0}
        };
        int p1 = process(grid, 0, 0);
        System.out.println(p1);

        int dp = dp(grid);
        System.out.println(dp);
    }

}
