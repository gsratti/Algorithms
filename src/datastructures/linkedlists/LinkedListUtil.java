package datastructures.linkedlists;

public class LinkedListUtil {

    public static void traverse(LinkNode head) {
        while(head != null) {
            System.out.print(head.data);
            head = head.next;
            if(head != null)
                System.out.print("->");
        }
    }
    
    public static void main(String args[]) {
        LinkNode node = new LinkNode(2);
        node.next = new LinkNode(3);
        node.next.next = new LinkNode(23);
        node.next.next.next = new LinkNode(45);
        node.next.next.next.next = new LinkNode(12);
        traverse(node);
    }
}
