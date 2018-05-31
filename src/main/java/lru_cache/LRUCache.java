package lru_cache;

import java.util.*;

// https://leetcode.com/problems/lru-cache/description/
class LRUCache {

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        c.get(1);
        c.put(3, 3);
        c.get(2);
    }

    // implements doubly linked list
    static class Node {
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        int val;
        int key;
        Node prev;
        Node next;
    }

    private Node cacheHead = null;
    private Node cacheTail = null;
    private final Map<Integer, Node> key2node = new HashMap<>();
    private int size = 0;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = key2node.get(key);
        if (n == null) return -1;
        removeNode(n);
        append(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node n = key2node.get(key);
        if (n == null && size == capacity) {
            evictLRU();
            size--;
        }
        if (n != null) {
            n.val = value;
            removeNode(n);
        } else {
            n = new Node(key, value);
            key2node.put(key, n);
            size++;
        }
        append(n);
    }

    private void evictLRU() {
        Node lru = cacheHead;
        key2node.remove(lru.key);
        removeNode(lru);
    }

    private void removeNode(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        if (cacheHead == n) cacheHead = n.next;
        if (cacheTail == n) cacheTail = n.prev;
    }

    private void append(Node n) {
        n.next = null;
        if (cacheTail == null) {
            cacheHead = cacheTail = n;
            n.prev = null;
        } else {
            cacheTail.next = n;
            n.prev = cacheTail;
            cacheTail = n;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
