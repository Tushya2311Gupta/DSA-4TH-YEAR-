import java.util.*;

public class linkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode fast = dummy;
            ListNode slow = dummy;

            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < size; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        int n = sc.nextInt();

        Solution sol = new Solution();
        ListNode head = sol.removeNthFromEnd(dummy.next, n);

        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" ");
            }
            head = head.next;
        }

        sc.close();
    }
}