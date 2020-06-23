package addBinary;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Test {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;
        int n = Math.max(len1, len2);
        char[] res = new char[n+1];
        int carry = 0;

        for (int i = 0; i < n; i++) {
            char x = i > len1-1 ? '0' : chars1[len1-i-1];
            char y = i > len2-1 ? '0' : chars2[len2-i-1];

            if (x == '1' && y == '1') {
                if (carry == 1) {
                    res[n-i] = '1';
                } else {
                    res[n-i] = '0';
                    carry = 1;
                }
                continue;
            }
            if (x == '0' && y == '0') {
                if (carry == 1) {
                    res[n-i] = '1';
                    carry = 0;
                } else {
                    res[n-i] = '0';
                }
                continue;
            }
            if (carry == 1) {
                res[n-i] = '0';
            } else {
                res[n-i] = '1';
            }
        }
        if (carry == 1) {
            res[0] = '1';
            System.out.println(String.valueOf(res));
        } else {
            System.out.println(String.valueOf(res).substring(1));
        }
    }

}
