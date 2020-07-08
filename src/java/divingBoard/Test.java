package divingBoard;

import utils.Utils;

import java.util.*;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，
 * 长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列
 */
public class Test {

    public static int[] p(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }

    public static void main(String[] args) {
        int shorter = 1;
        int longer = 2;
        int k = 100000;

        int[] res = p(shorter, longer, k);
        System.out.println(Arrays.toString(res));
    }

}
