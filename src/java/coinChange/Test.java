package coinChange;

public class Test {

    public static int way1(int[] coins, int index, int amount) {
        if (index == coins.length) {
            return amount == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int i=0; i*coins[index] <= amount; i++) {
            ways += way1(coins, index + 1, amount - i * coins[index]);

        }
        return ways;
    }

    public static int way2(int[] coins, int index, int amount, int[][] dp) {
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        if (index == coins.length) {
            dp[index][amount] = amount == 0 ? 1 : 0;
            return dp[index][amount];
        }
        int ways = 0;
        for (int i=0; i*coins[index] <= amount; i++) {
            ways += way2(coins, index + 1, amount - i * coins[index], dp);

        }
        dp[index][amount] = ways;
        return ways;
    }

    public static int way3(int[] coins, int amount, int[][] dp) {
        int n = coins.length;
        dp[n][0] = 1;
        for(int index = n - 1; index >= 0; index--) {
            for(int rest = 0; rest <= amount; rest++) {
                int ways = 0;
                for(int zhang = 0;  zhang * coins[index] <= rest ;zhang++) {
                    ways += dp[index + 1] [rest -  (zhang * coins[index])];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int[][] dp1 = new int[coins.length+1][amount+1];
        for (int i = 0; i < dp1.length; i++) {
            for (int j = 0; j < dp1[i].length; j++) {
                dp1[i][j] = -1;
            }
        }
        // 递归
        System.out.println(way1(coins, 0, amount));
        // 记忆化搜索
        System.out.println(way2(coins, 0, amount, dp1));
        // 经典动态规划
        System.out.println(way3(coins, amount, dp1));
    }

}
