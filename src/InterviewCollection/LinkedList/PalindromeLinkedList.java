package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
//        ListNode head = new ListNode(1, new ListNode(2));

        System.out.println("Output : " + isPalindrome(head));

    }

    private static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return false;

        Stack<ListNode> stack = new Stack<>();

        var ref = head;

        while (ref != null) {
            stack.push(ref);
            ref = ref.next;
        }
        ref = head;
        while (!stack.empty()) {
            if (stack.pop().val == ref.val) {
                ref = ref.next;
            } else {
                return false;
            }
        }

        return true;
    }

}
