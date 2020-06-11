package nstairs;

/**
 * n级楼梯，每次走一步或者两步，走到n级台阶的方法数
 *
 */
public class Test {

    public static int process(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return process(n - 1) + process(n - 2);
    }

    public static int dp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 20;

        int res = process(n);
        System.out.println(res);

        int dp = dp(n);
        System.out.println(dp);
    }

}
