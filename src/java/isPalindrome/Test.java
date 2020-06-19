package isPalindrome;

import java.util.Stack;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class Test {

    public static boolean p(String str) {
        if (str == null) {
            return true;
        }
        String s = str.toLowerCase().replaceAll("[^0-9|a-z]", "");
        if (s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean p = p(str);
    }

}
