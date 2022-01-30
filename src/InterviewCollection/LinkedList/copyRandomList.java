package InterviewCollection.LinkedList;


import InterviewCollection.ListNode;

public class copyRandomList {


    public static void main(String[] args) {

        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);

/*        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random
                = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        Node cloned_list = clone(start);
        print(start);*/
    }

    static Node clone(Node start) {

        if (start == null) return null;
        Node current = start;

        // copy
        while (current != null) {

            Node temp = current.next;
            current.next = new Node(current.data);
            current.next.next = temp;

            current = current.next.next;
        }

        current = start;

        // Copy random pointers
        while (current != null) {

            if (current.next != null) {
                current.next.random = current.random != null ? current.random.next : current.random;
            }

            current = current.next.next;
        }

        Node original = start;
        Node copy = start.next;

        current = copy;

        while (original != null) {
            original.next = original.next.next;

            copy.next = (copy.next != null) ? copy.next.next : null;

            original = original.next;
            copy = copy.next;
        }


        return current;
    }


    static void print(Node start) {
        Node ptr = start;
        while (ptr != null) {
//            System.out.println("Data = " + ptr.data);
            System.out.println("Data = " + ptr.data + ", Random = " + ptr.random.data);
            ptr = ptr.next;
        }
    }

    private static class Node {
        int data;
        Node next, random;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

}


