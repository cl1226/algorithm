package longestCommonPrefix;

/**
 * 字符串数组的最长公共前缀
 */
public class Test {

    public static String process(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs[0].length() == 0) {
            return "";
        }
        char[] base = strs[0].toCharArray();
        int index = 1;
        boolean flag = true;
        while (index <= base.length) {
            String s = strs[0].substring(0, index);
            for (int i=1; i<strs.length; i++) {
                if (!strs[i].startsWith(s)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            index++;
        }
        return strs[0].substring(0, index-1);
    }

    public static void main(String[] args) {
        String[] strs = {"c", "c"};
        String res = process(strs);
        System.out.println(res);
    }

}
