package struct;

public class Queue {

    public LinkNode head;
    public LinkNode tail;

    // 入队
    public void add(int val) {
        if(head == null) { // 队列为空，新建头节点
            head = new LinkNode(val);
            tail = head;
        }else { // 队列不为空，在尾部追加
            tail.next = new LinkNode(val);
            tail = tail.next;
        }
    }

    // 出队
    public int poll() {
        if(isEmpty()) return -1; // 队列为空，返回-1
        // 取出头节点的值，并将头节点设置为下一个节点
        LinkNode next = head.next;
        int val = head.val;
        head.next = null;
        head = next;
        if(head == null) { // 队列删除后为空，把尾部节点也重置为null
            tail = null;
        }
        return val;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        // 依次往队列中添加元素, 即first int
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // 此时队列元素为 1 -> 2 -> 3

        while(!queue.isEmpty()) { // 队列不为空，则从头部取出元素，即first out
            System.out.println(queue.poll());
        }
    }

}
