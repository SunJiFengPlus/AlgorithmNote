package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// leetcode 146
public class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node dummyHead, dummyTail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        dummyHead = new Node(-1,-1);
        dummyTail = new Node(-1,-1);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (Objects.isNull(node)) {
            return -1;
        }
        
        remove(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node existNode = map.get(key);
        Node node = new Node(key, value);
        if (Objects.isNull(existNode)) {
            // 驱逐
            if (capacity <= map.size()) {
                int removedKey = removeLast();
                map.remove(removedKey);
            }
            addFirst(node);
        } else {
            remove(existNode);
            addFirst(node);
        }
        map.put(key, node);
    }
    
    // a - b - tail
    private int removeLast() {
        int removedKey = dummyTail.pre.key;
        Node a = dummyTail.pre.pre;
        a.next = dummyTail;
        dummyTail.pre = a;
        return removedKey;
    }

    // head - node - a
    private void addFirst(Node node) {
        Node a = dummyHead.next;
        dummyHead.next = node;
        
        node.pre = dummyHead;
        node.next = a;
        
        a.pre = node;
    }

    // a - node - c
    private void remove(Node node) {
        Node a = node.pre;
        Node c = node.next;
        a.next = c;
        c.pre = a;
    }

    public static class Node {
        int key, value;
        Node pre, next;
        
        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
}
