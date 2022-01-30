package InterviewCollection.LinkedList;


public class FlattenMultilevel {

    public static void main(String[] args) {
        Node n1 = new Node(11, new Node(12));
        Node n2 = new Node(7, new Node(8, n1, new Node(9, new Node(10))));
        Node n3 = new Node(1, new Node(2, new Node(3, n2, new Node(4, new Node(5, new Node(6))))));

        print(flatten(n3));
    }

    private static Node flatten(Node head) {

        if (head == null) return head;

        Node current = head;

        while (current != null) {

            if (current.child != null) { // 3

                Node nextNode = current.next; //4
                Node childNode = flatten(current.child); // ChildNode: 7,8,9,10

                current.child = null;
                current.next = childNode;  // 3->7
                childNode.prev = current;

                while (childNode.next != null) { // çocukta sürekli ilerliyoruz. 10. nodu bulduk mu duruyoruz.
                    childNode = childNode.next;
                }
                // current: 10;
                childNode.next = nextNode; // 10-> 4

                if (nextNode != null)
                    nextNode.prev = childNode; // 4-> 10
            }
            current = current.next;
        }

        return head;
    }

    private static void print(Node head) {

        Node ref = head;
        while (ref != null) {
            System.out.print(ref.val + " -> ");
            ref = ref.next;
        }
        System.out.println();
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    Node(int x, Node node) {
        this.val = x;
        this.next = node;
        node.prev = this;
    }

    Node(int x, Node _child, Node node) {
        this.val = x;
        this.next = node;
        this.child = _child;
        node.prev = this;
    }
};
