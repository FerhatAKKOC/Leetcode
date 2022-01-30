package InterviewCollection.CollectionsEasy;

import InterviewCollection.ListNode;

import java.util.Stack;

public class palindromeLinkedList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
//        ListNode head = new ListNode(1, new ListNode(2));

        System.out.println("Output : " + isPalindrome(head));
    }

    /*
     Palindrome Linked List

     */
    private static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return false;

        Stack<ListNode> stack = new Stack<>();

        var ref = head;
        while (ref != null) {
            stack.add(ref);
            ref = ref.next;
        }

        ref = head;
        while (!stack.isEmpty() || ref != null) {

            if (stack.pop().val != ref.val)
                return false;
            ref = ref.next;
        }

        return true;
    }
}
