package kthSmallest;

import utils.Utils;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5},
                {6,7,12},
                {11,14,14}
        };
        int k = 1;
        int n = matrix.length;
        int[] temp = new int[n*n];
        int index = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                temp[index++] = matrix[i][j];
            }
        }
        Arrays.sort(temp);
        System.out.println(temp[k-1]);
    }

}
