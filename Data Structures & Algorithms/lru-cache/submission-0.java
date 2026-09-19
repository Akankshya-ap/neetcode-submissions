
class LRUCache {
    class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int cap;
    private Map<Integer, Node> cache;
    private Node head = new Node(0,0), tail = new Node(0,0);
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {

        if(!cache.containsKey(key)) {return -1;}
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) remove(cache.get(key));
        if(cache.size() == cap) remove(tail.prev);
        insert(new Node(key, value));
    }

    private void remove(Node node){
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        cache.put(node.key, node);
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }
}
