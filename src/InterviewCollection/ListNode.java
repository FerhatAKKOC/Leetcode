package InterviewCollection;

public class ListNode {

    public int val = 0;

    public ListNode next = null;
    public ListNode prev = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public static void print(ListNode head) {
        int i = 0;
        var ref = head;
        while (ref != null) {
            System.out.print(ref.val + " -> ");
            ref = ref.next;
            if (++i > 20) break; // prevent cycle print
        }
        System.out.println();
    }
}
