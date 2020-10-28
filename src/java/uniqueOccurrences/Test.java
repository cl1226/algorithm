package uniqueOccurrences;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return map.values().stream().count() == map.values().stream().distinct().count();

    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3};
        boolean res = uniqueOccurrences(arr);
        System.out.println(res);
    }

}
