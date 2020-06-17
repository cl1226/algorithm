package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        sort(arr, L, mid);
        sort(arr, mid+1, R);
        merge(arr, L, mid, R);
    }

    public static void main(String[] args) {

        int[] arr = {5,2,1,2,3,4,8,3,9,3};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
