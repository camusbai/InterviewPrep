package com.camusbai.exercise.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LC146_LRUCache {
    public static void main(String[] args) {
        LC146_LRUCache cache = new LC146_LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
    }

    final int capacity;
    final Map<Integer, QRef> map;
    final LRUQueue queue;

    public LC146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LRUQueue();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            QRef ref = map.get(key);
            queue.boost(ref);
            return ref.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            QRef ref = map.get(key);
            ref.value = value;
            queue.boost(ref);
        }else{
            QRef ref = new QRef(key, value);
            map.put(key, ref);
            queue.add(ref);
        }
    }

    class LRUQueue {
        QRef head;
        QRef tail;

        void add(QRef ref){
            if(head==null){
                head = ref;
                tail = ref;
                return;
            }

            ref.next = head;
            head.prev = ref;
            head = ref;
            evict();
        }

        void boost(QRef ref){
            if(map.size()<2||ref==head) {
                return;
            }
            if (ref == tail) {
                tail = ref.prev;
            }
            ref.prev.next = ref.next;
            if(ref.next!=null){
                ref.next.prev = ref.prev;
            }
            head.prev = ref;
            ref.next = head;
            head = ref;
            head.prev=null;
        }

        void evict(){
            if(map.size()>capacity){
                map.remove(tail.key);
                tail = tail.prev;
                tail.next.prev = null;
                tail.next = null;
            }
        }
    }

    class QRef{
        int key;
        int value;
        QRef prev;
        QRef next;
        public QRef(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
