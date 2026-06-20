static class Node{
    int key, val;
    Node prev, next;
    Node(int key, int val){
        this.key = key; this.val = val;
    }
}
class LRUCache {
    HashMap<Integer,Node> cache;
    int cap;
    Node left, right;
    public LRUCache(int capacity){
        cache = new HashMap<>();
        cap = capacity;
        left = new Node(0,0); right = new Node(0,0);
        left.next = right; right.prev = left;
    }

    public void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after; after.prev = before;
    }

    //Insert at the back
    public void insert(Node node){
        Node before = right.prev, after = right;
        before.next = node; after.prev = node;
        node.prev = before; node.next = after;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key,value);
        insert(newNode);
        cache.put(key,newNode);
        if(cache.size() > cap){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
