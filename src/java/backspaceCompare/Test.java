package backspaceCompare;

import java.util.Stack;

public class Test {

    public static boolean process(String S, String T) {
        char[] c1 = S.toCharArray();
        char[] c2 = T.toCharArray();
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == '#') {
                if (!s1.empty())
                    s1.pop();
            } else {
                s1.push(c1[i]);
            }
        }
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < c2.length; i++) {
            if (c2[i] == '#') {
                if (!s2.empty())
                    s2.pop();
            } else {
                s2.push(c2[i]);
            }
        }
        return s1.toString().equals(s2.toString());
    }

    public static void main(String[] args) {
        boolean res = process("a##c", "#a#c");
        System.out.println(res);
    }

}
