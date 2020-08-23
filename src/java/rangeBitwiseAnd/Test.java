package rangeBitwiseAnd;

/**
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 解法：
 * 假设求[6, 10]
 * [0 0 0 0 0 1 1 0]
 * [0 0 0 0 0 1 1 1]
 * [0 0 0 0 1 0 0 0]
 * [0 0 0 0 1 0 0 1]
 * [0 0 0 0 1 0 1 0]
 *
 * 与运算: 全1为1
 * 由于m->n是连续的，则从第五位开始与运算必为0，也就是求最长公共前缀，再左移step位，则为结果
 */
public class Test {

    public static void main(String[] args) {
        int m = 6;
        int n = 10;

        int step = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            step++;
        }
        int res = m << step;

        System.out.println(res);
    }

}
