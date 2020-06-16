package reservoirSampling;


import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Test {

    ListNode head;

    int[] reservoir = new int[1];

    public Test(ListNode head) {
        this.head = head;
        reservoir[0] = head.val;
    }

    public int getRandom() {
        int count = 1;
        ListNode node = head.next;
        while (node != null) {
            int d = new Random().nextInt(count + 1);
            if (d < 1) {
                reservoir[d] = node.val;
            }
            node = node.next;
        }
        return reservoir[0];
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Test solution = new Test(head);
        int random = solution.getRandom();
        System.out.print(random);

    }

}
