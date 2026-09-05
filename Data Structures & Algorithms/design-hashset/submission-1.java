class ListNode{
    int key;
    ListNode next;
    ListNode(int key){
        this.key = key;
    }
}
class MyHashSet {
    ListNode[] set;
    public MyHashSet() {
        set = new ListNode[10000];
        for(int i=0; i<10000; i++){
            set[i] = new ListNode(-1);
        }
    }
    
    public void add(int key) {
        int ind = key % 10000;
        ListNode temp = set[ind];
        while(temp.next != null){
            if(temp.next.key == key){
                return;
            }
            temp = temp.next;
        }
        temp.next = new ListNode(key);
    }
    
    public void remove(int key) {
        int ind = key % 10000;
        ListNode temp = set[ind];
        while(temp.next != null){
            if(temp.next.key == key){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    
    public boolean contains(int key) {
        int ind = key % 10000;
        ListNode temp = set[ind];
        while(temp != null){
            if(temp.key == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */