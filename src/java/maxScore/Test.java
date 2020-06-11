package maxScore;

/**
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 */
public class Test {

    public static int process(int[] arr, int head, int tail, int rest) {
        if (rest <= 0) {
            return 0;
        }
        if (head >= arr.length) {
            return 0;
        }
        if (head == tail) {
            return arr[head];
        }
        if (rest == 1) {
            return Math.max(arr[head], arr[tail]);
        }
        // 拿了前面的点
        int p1 = arr[head] + process(arr, head+1, tail,rest-1);
        // 拿了后面的点
        int p2 = arr[tail] + process(arr, head, tail-1, rest-1);
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        int k = 3;
        int res = process(arr, 0, arr.length - 1, k);
        System.out.println(res);

    }

}
