package InterviewCollection.Recursions;

import InterviewCollection.ListNode;

public class swapPairs {

    public static void main(String[] args) {

        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode.print(root);
        var output = swapPairs(root);
        ListNode.print(output);

    }


    private static ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        else
        {

            var p1 = head;          // p1
            var p2 = head.next;     // p2
            var p3 = head.next.next;// p3
            p1.next = p3;
            p2.next = p1;


           if(p3 != null ){
                var res = swapPairs(p3);
                p2.next.next = res;
           }

            return p2;
        }



    }

}
