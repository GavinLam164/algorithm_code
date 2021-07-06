package struct;

public class Stack {
    public DoubleLinkNode pointer;

    public void push(int val) {
        if(pointer == null) { // 栈为空，则创建栈底的节点
            pointer = new DoubleLinkNode(val);
            return;
        }
        // 栈不为空，则在栈顶追加新建节点，并将栈指针移动到新加的节点上，即pointer始终指向栈顶
        pointer.next = new DoubleLinkNode(val);
        pointer.next.prev = pointer;
        pointer = pointer.next;
    }

    public int pop() {
        if(isEmpty()) return -1;
        // 栈顶元素
        int val = pointer.val;
        pointer = pointer.prev;
        if(pointer != null) { // 将刚弹出的栈顶元素从链表中删除
            pointer.next.prev = null;
            pointer.next = null;
        }
        return val;
    }

    public boolean isEmpty() {
        return pointer == null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
