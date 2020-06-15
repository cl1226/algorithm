package addBinary;

public class Test {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        char[] m = a.toCharArray();
        char[] n = b.toCharArray();
        int maxLength = Math.max(m.length, n.length);
        int minLength = Math.min(m.length, n.length);
        int d = 0;

        char[] res = new char[maxLength + 1];
        int index = maxLength;
        for (int i = minLength - 1; i >= 0; i--) {
            if (m[i] == 1 && n[i] == 1) {
                d = 1;
            } else {
                d = 0;
            }
            index--;

        }
        for (int i = minLength; i < m.length; i++) {
            res[--index] = String.valueOf(m[i] ^ d).toCharArray()[0];
            if ((m[i] ^ d) == 1) {
                d = 1;
            } else {
                d = 0;
            }
        }
        for (int i = minLength; i < n.length; i++) {
            res[--index] = String.valueOf(n[i] ^ d).toCharArray()[0];
            if ((n[i] ^ d) == 1) {
                d = 1;
            } else {
                d = 0;
            }
        }

        System.out.println(Integer.toBinaryString(Integer.valueOf(String.valueOf(res))));
    }

}
