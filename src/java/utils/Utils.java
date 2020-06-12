package utils;

public class Utils {

    public static void printDP(int[][] dp) {
        int m = dp.length;
        int n = dp[0].length;
        System.out.println("---------------------------");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

}
