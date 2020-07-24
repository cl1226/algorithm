package divisorGame;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *      先手         后手
 * 0    false       true
 * 1    false       true
 * 2    true        false
 * 3    false       true
 * 4    拿1true
 * 5    拿1false
 * ...
 * 推断出N=0时，爱丽丝败，N>0:N为奇数时，爱丽丝败；N为偶数时，爱丽丝胜
 *
 * 证明：
 * N = 1，N = 2时结论成立
 * N > 2时，假设N <= k时成立，则N = k + 1时：
 *      k为偶数，k+1为奇数，则x比为奇数，奇数减去奇数为偶数，轮到Bob时都是偶数，而假设N <= k时偶数必胜，所以Alice必败
 *      k为奇数，k+1位偶数，x可以为奇数，也可以为偶数，若Alice减去一个奇数，那么k+1-x是一个小于k的奇数，此时Bob先手必败，ALice必胜
 */
public class Test {

    public static boolean p(int N) {
        if (N == 0) {
            return false;
        }
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        int N = 3;
        boolean p = p(N);
        System.out.println(p);
    }

}
