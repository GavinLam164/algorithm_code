package struct;


public class HashMap {

    class LinkNode {
        String key;
        int val;
        LinkNode next;

        public LinkNode(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    LinkNode[] map;

    public HashMap(int capacity) {
        map = new LinkNode[capacity];
    }

    private int getIndex(String key) {
        return key.hashCode() % map.length;
    }

    public void put(String key, int val) {
        int index = getIndex(key);
        if(map[index] == null) {
            map[index] = new LinkNode(key, val);
        }else {
            LinkNode head = null;
            // 从头节点开始查询，直至为空或等于key值停下
            for(head = map[index]; head != null && !head.key.equals(key); head = head.next);

            if(head == null) { // 没有找到对应key的节点，则创建一个从头部插入
                head = new LinkNode(key, val);
                head.next = map[index];
                map[index] = head;
            }else { // 找到对应key的节点，更新值即可
                head.val = val;
            }
        }
    }

    public int get(String key) {
        int index = getIndex(key);
        LinkNode head = null;
        // 从头节点开始查询，直至为空或等于key值停下
        for(head = map[index]; head != null && !head.key.equals(key); head = head.next);
        return head == null ? -1: head.val;
    }

    public void remove(String key) {
        int index = getIndex(key);
        LinkNode pre = null;
        LinkNode head = null;
        // 从头节点开始查询，直至为空或等于key值停下
        for(head = map[index]; head != null && !head.key.equals(key); pre = head, head = head.next);
        if(head == null) return; // 没有找到对应的key值则直接return
        // 找到了对应的key值，还需要判断删除的是否是头节点
        if(pre == null) { // 删除的是头节点
            map[index] = head.next;
        }else { // 删除的不是头节点
            pre.next = head.next;
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(10);
        hashMap.put("164", 96);
        hashMap.put("165", 95);
        hashMap.put("167", 97);

        System.out.println(hashMap.get("164"));
        System.out.println(hashMap.get("165"));
        System.out.println(hashMap.get("167"));

        hashMap.remove("164");

        System.out.println(hashMap.get("164"));

    }

}
