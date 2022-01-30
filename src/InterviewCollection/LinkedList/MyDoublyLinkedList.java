package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class MyDoublyLinkedList {

    public static void main(String[] args) {

        var obj = new MyDoublyLinkedList();
        obj.addAtHead(1);
        obj.addAtHead(2);
        obj.addAtTail(67);
        obj.addAtHead(3);
        obj.addAtTail(98);
        ListNode.print(obj.head);
        obj.addAtIndex(3, 44);
        ListNode.print(obj.head);
        obj.deleteAtIndex(5);
        ListNode.print(obj.head);
    }

    ListNode head;

    public MyDoublyLinkedList() {
        this.head = null;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            var node = new ListNode(val, null, head);
            head.prev = node;
            head = node;
        }
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            var ref = head;
            while (ref.next != null)
                ref = ref.next;

            var node = new ListNode(val, ref, null);
            ref.next = node;
        }
    }

    public void addAtIndex(int index, int val) {

        if (index == 0) {
            addAtHead(val);
            return;
        }

        var ref = head;
        int cnt = 0;
        while (ref != null) {
            ref = ref.next;
            cnt++;
        }
        if (index > cnt)
            return;
        else if (index == cnt)
            addAtTail(val);
        else {
            ref = head;

            for (int i = 1; ref.next != null; i++) {
                if (i == index) {
                    var node = new ListNode(val, ref, ref.next);
                    ref.next.prev = node;
                    ref.next = node;
                    break;
                }
                ref = ref.next;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (head == null && (head.next == null && index == 0)) {
            head = null;
            return;
        }

        var ref = head;
        int cnt = 0;
        while (ref.next != null) {
            ref = ref.next;
            cnt++;   // 6  index: 0...5
        }

        if (cnt > index)
            return;
        else if (cnt == index) {
            ref.prev.next = null;
        } else {

            ref = head;

            for (int i = 0; ref.next != null; i++) {

                if(i == index){
                    ref.next.next.prev = ref;
                    ref.next = ref.next.next;
                    break;
                }
                ref = ref.next;
            }
        }
    }

}
