package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class MySinglyLinkedList {

    public static void main(String[] args) {
        MySinglyLinkedList obj = new MySinglyLinkedList();

        obj.addAtHead(3);
        obj.addAtHead(78);
        obj.addAtHead(4);
        obj.addAtHead(11);
        obj.print();
        obj.addAtTail(55);
        obj.print();
        obj.addAtIndex(2, 43);
        obj.deleteAtIndex(0);
        obj.print();

        //        int param_1 = obj.get(1);
//        obj.addAtIndex(2, 43);
//        obj.deleteAtIndex(2);
    }

    private ListNode head;

    /**
     * Initialize your data structure here.
     */
    public MySinglyLinkedList() {
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {

        if (head == null) return -1;
        var tempRef = head;

        for (int i = 0; i <= index; i++) {

            if (i == index) {
                return tempRef != null ? tempRef.val : -1;
            } else {
                if (tempRef.next != null) {
                    tempRef = tempRef.next;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        var node = new ListNode(val, head);
        head = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        var ref = head;
        while (ref.next != null)
            ref = ref.next;
        ref.next = new ListNode(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index == 0) {
            addAtHead(val);
            return;
        }
        var ref = head;
        for (int i = 0; i <= index; i++) {      // length : 10, index: 3
            if (i == index - 1) {
                var node = new ListNode(val, ref.next);
                ref.next = node;
            } else if (ref.next != null) {
                ref = ref.next;
            } else {
                break;
            }
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (head == null) return;
        if (index == 0) {
            head = head.next;
            return;
        }


        var ref = head;

        for (int i = 0; i <= index; i++) {

            if (i == index - 1) {

                if (ref.next.next != null)
                    ref.next = ref.next.next;
                else {
                    ref.next = null;
                }

            } else if (ref.next != null) {
                ref = ref.next;
            } else {
                break;
            }
        }

    }

    public void print() {
        var ref = head;
        while (ref != null) {
            System.out.print(ref.val + " -> ");
            ref = ref.next;
        }
        System.out.println();
    }
}
