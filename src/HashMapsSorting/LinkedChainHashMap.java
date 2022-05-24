/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapsSorting;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Dec 9,2020(Assignment-4)
 */
public class LinkedChainHashMap<K, V> extends AbstractHashMap<K, V> {  // a fixed capacity array of UnsortedTableMap that serve as buckets

    private LinkedList<MapEntry<K, V>>[] table; // initialized within createTable

    private int puttingCount;
    private int bucketCount;

    public LinkedChainHashMap() {
        super();
    }

    public LinkedChainHashMap(int cap) {
        super(cap);
    }

    public LinkedChainHashMap(int cap, int p) {
        super(cap, p);
    }

    /**
     * Creates an empty table having length equal to current capacity.
     */
    protected void createTable() {
        table = (LinkedList<MapEntry<K, V>>[]) new LinkedList[capacity];
        bucketCount = 0;
    }

    /**
     * Returns value associated with key k in bucket with hash value h, or else
     * null.
     */
    protected V bucketGet(int h, K k) {
        LinkedList<MapEntry<K, V>> bucket = table[h];
        if (bucket == null) {
            return null;
        }
        V val = null;
        for (MapEntry<K, V> ent : bucket) {
            if (ent.getKey() == k) {
                val = ent.getValue();
            }
        }
        return val;
    }

    /**
     * Associates key k with value v in bucket with hash value h; returns old
     * value.
     */
    protected V bucketPut(int h, K k, V v) {
        LinkedList<MapEntry<K, V>> bucket = table[h];

        if (bucket == null) {
            bucket = table[h] = new LinkedList<>();
            bucketCount++;
        }
        int oldSize = bucket.size();
        MapEntry<K, V> answer
                = new MapEntry<>(k, v);
        bucket.addLast(answer);
        n += (bucket.size() - oldSize); // size may have increased
        return answer.getValue();
    }

    public int getCollisions() {//whenever a new bucket is made it is counted in bucketPut()(count++).
        //This is basically returning the total number of entries minus number of buckets(Because when a new element is added to existing bucket it is counted as collision)
        //So the number of the first entries in each bucket is subtracted(as bucketCount) from the total number of entries.
        //every entry after the first entry to the same hash value is a collision, that is why I am doing this.
        return n - bucketCount;
    }

    /**
     * Removes entry having key k from bucket with hash value h (if any).
     */
    protected V bucketRemove(int h, K k) {
        LinkedList<MapEntry<K, V>> bucket = table[h];
        if (bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        V val = null;
        for (MapEntry<K, V> ent : bucket) {
            if (ent.getKey() == k) {
                val = ent.getValue();
                bucket.remove(ent);
            }
        }
        n -= (oldSize - bucket.size()); // size may have decreased
        return val;
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     */
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (table[h] != null) {
                for (Entry<K, V> entry : table[h]) {
                    buffer.add(entry);
                }
            }
        }
        return buffer;
    }
}
