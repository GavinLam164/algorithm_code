package struct;

public class LinkNode {
    public LinkNode next;
    public int val;

    public LinkNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        // 链表头节点 1
        LinkNode head = new LinkNode(1);
        // 1 -> 2
        head.next = new LinkNode(2);
        // 1 -> 2 -> 3
        head.next.next = new LinkNode(3);

        // 通过头节点遍历链表
        LinkNode tmp = head;
        while(tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next; // 不断的next，将指针挪到下一个节点
        }
    }
}
