package InterviewCollection.CollectionsEasy;

import InterviewCollection.ListNode;

public class deleteNode {

    public static void main(String[] args) {

        ListNode root = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));

        ListNode.print(root);
        deleteNode(root, 4);
        ListNode.print(root);
    }

    /*
        Delete Node in a Linked List
        Stack üzerindeki varible adressleri değiştirelemezler.
     */
    private static void deleteNode(ListNode root, int value) {

        if (root.val == value) {
            root = root.next;
            return;
        }

        var ref = root;

        while (ref.next != null) {
            if (ref.next.val == value) {
                ref.next = ref.next.next;
            }
            ref = ref.next;
        }
    }
}
