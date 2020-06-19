package reverseList;

import utils.Constants;
import utils.ListNode;

import static utils.Utils.printList;

/**
 * 反转一个单链表。
 */
public class Test {

    public static ListNode p(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode res = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        printList(Constants.head);
        ListNode p = p(Constants.head);
        printList(p);
    }

}
