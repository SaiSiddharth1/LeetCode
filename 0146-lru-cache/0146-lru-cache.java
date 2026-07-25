class LRUCache {
    CDLL dll;
    Map<Integer,CDLLNode> map= new HashMap<>();
    int cap;
    int sz;
    public LRUCache(int capacity) {
        dll = new CDLL();
        cap = capacity;
        sz = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        CDLLNode node = map.get(key);
        dll.moveToFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CDLLNode node = map.get(key);
            node.val = value;
            dll.moveToFirst(node);
            return;
        }

        if(sz < cap){
            CDLLNode node = dll.insertBeginning(key,value);
            map.put(key,node);
            sz++;
        }else{
            int rem = dll.removeLast();
            map.remove(rem);
            CDLLNode node = dll.insertBeginning(key,value);
            map.put(key,node);
        }
    }
}


class CDLLNode{
    int key,val;
    CDLLNode prev,next;
    CDLLNode(int key,int val){
        this.key = key;
        this.val = val;
        prev = this;
        next = this;
    }
}



class CDLL{
    CDLLNode head;
    CDLL(){
        head = null;
    }

    int removeLast(){
        if(head == null) return -1;
        CDLLNode node = head.prev;
        if(node == head){
            head = null;
            return node.key;
        }
        head.prev = node.prev;
        head.prev.next = head;
        return node.key;
    }

    CDLLNode insertBeginning(int key,int val){
        CDLLNode node = new CDLLNode(key,val);
        if(head == null){
            head = node;
            return node;
        }
        node.prev = head.prev;
        head.prev.next = node;
        node.next = head;
        head.prev = node;
        head = node;
        return node;
    }

    void moveToFirst(CDLLNode node){
        if(head == node) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        head = node;

    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */