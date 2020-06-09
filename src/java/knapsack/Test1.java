package knapsack;

/*
   [w1,w2,w3,...,wn]
   [v1,v2,v3,...,vn]
   给定一个背包总容量为k，求能装最大的物品价值是多少
 */
public class Test1 {

    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        // 没有要index位置的物品
        int p1 = process(w, v, index+1, rest);
        // 要了index位置的物品
        int p2 = -1;
        int p2Next = process(w, v, index+1, rest-w[index]);
        if (p2Next != -1) {
            p2 = p2Next + v[index];
        }
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
//        int[] w = new int[]{3,4,2,1,7,4,3,4};
//        int[] v = new int[]{1,4,3,2,5,3,4,6};
        int[] w = new int[]{3,2,4,7};
        int[] v = new int[]{5,6,3,19};
        int k = 11;
        int maxValue = process(w, v, 0, k);
        System.out.println(maxValue);
    }

}
