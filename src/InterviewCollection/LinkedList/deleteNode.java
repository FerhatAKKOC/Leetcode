package InterviewCollection.LinkedList;


import InterviewCollection.ListNode;

public class deleteNode {


    public static void main(String[] args) {

        ListNode node = new ListNode(88, new ListNode(5, new ListNode(6)));
        ListNode list = new ListNode(8, new ListNode(4, node));
        ListNode.print(list);
        deleteNode(node);
        ListNode.print(list);

    }

    private static void deleteNode(ListNode node) {

        ListNode curr = node;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

