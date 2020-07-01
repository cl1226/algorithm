package findLength;

import javafx.scene.control.Alert;
import utils.Utils;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class Test {

    public static int p(int[] A, int[] B) {
        int ALength = A.length;
        int BLength = B.length;
        int[][] dp = new int[ALength+1][BLength+1];
        int max = 0;
        for (int i = 1; i <= ALength; i++) {
            for (int j = 1; j <= BLength; j++) {
                dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        Utils.printDP(dp);
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        int res = p(A, B);
        System.out.println(res);
    }

}
