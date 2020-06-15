import java.util.Arrays;

public class Test {

    public static int maxNumberOfBalloons(String text) {
        int[] temp = new int[5];
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'b') {
                temp[0]++;
            }
            if (chars[i] == 'a') {
                temp[1]++;
            }
            if (chars[i] == 'l') {
                temp[2]++;
            }
            if (chars[i] == 'o') {
                temp[3]++;
            }
            if (chars[i] == 'n') {
                temp[4]++;
            }
        }
        temp[2] /= 2;
        temp[3] /= 2;
        Arrays.sort(temp);
        return temp[0];
    }

    public static void main(String[] args) {
        String str = "leetcode";
//        System.out.println(maxNumberOfBalloons(str));
        int x = 120;
        if (x < 0) {
            System.out.println(-1);
            return;
        }
        int bak = x;
        int temp = 0;
        while (x > 0) {
            int mod = x % 10;
            temp = temp * 10 + mod;
            x /= 10;
        }
        if (bak == temp) {
            System.out.println(1);
        }
        System.out.println(-1);
    }

}
