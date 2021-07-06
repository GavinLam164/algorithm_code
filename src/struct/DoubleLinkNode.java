package struct;

public class DoubleLinkNode {
    public DoubleLinkNode prev;
    public DoubleLinkNode next;
    int val;

    public DoubleLinkNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        // 双向链表头节点 1
        DoubleLinkNode head = new DoubleLinkNode(1);

        // 1 -> 2
        head.next = new DoubleLinkNode(2);
        // 1 <-> 2
        head.next.prev = head; // 需要维护prev关系

        // 1 <-> 2 -> 3
        head.next.next = new DoubleLinkNode(3);
        // 1 <-> 2 <-> 3
        head.next.next.prev = head.next; // 需要维护prev关系

        System.out.println("正向遍历");
        DoubleLinkNode tmp = head;
        while(tmp != null) { // 正向遍历 1 -> 2 -> 3
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        System.out.println("反向遍历");
        tmp = head.next.next;
        while(tmp != null) { // 反向遍历 3 -> 2 -> 1
            System.out.println(tmp.val);
            tmp = tmp.prev;
        }
    }

}
