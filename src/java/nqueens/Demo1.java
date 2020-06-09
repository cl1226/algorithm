package nqueens;

import java.util.ArrayList;
import java.util.List;

// n皇后，摆在n*n的棋盘上，要求每个皇后不能共列、共行、共斜线
public class Demo1 {

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            // 之前的某个k行的皇后 k, record[k]   i, j
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static int process(int i, int[] record, int n, List<int[]> list) {
        if (i == n) {
            int[] a = new int[record.length];
            for (int j = 0; j < record.length; j++) {
                a[j] = record[j];
            }
            list.add(a);
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n, list);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int n = 4;
        int[] record = new int[n];
        List<int[]> list = new ArrayList<>();
        process(0, record, n, list);

        List<List<String>> result = new ArrayList<>();
        char[] chars = new char[n];
        for (int i = 0; i < 4; i++) {
            chars[i] = '.';
        }
        for (int[] a : list) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                chars[a[i]] = 'Q';
                temp.add(String.valueOf(chars));
                chars[a[i]] = '.';
            }
            result.add(temp);
        }
        System.out.println(result);

    }

}
