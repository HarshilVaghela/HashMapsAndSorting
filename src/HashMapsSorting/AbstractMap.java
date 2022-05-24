/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapsSorting;

import java.util.Iterator;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Dec 9,2020(Assignment-4)
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    public boolean isEmpty() {
        return size() == 0;
    }

    //---------------- nested MapEntry class ----------------
    protected static class MapEntry<K, V> implements Entry<K, V> {

        private K k; // key
        private V v; // value

        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        // public methods of the Entry interface
        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            k = key;
        }

        protected V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }

    } //----------- end of nested MapEntry class -----------

    // Support for public keySet method...
    private class KeyIterator implements Iterator<K> {

        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public K next() {
            return entries.next().getKey();
        } // return key!

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private class KeyIterable implements Iterable<K> {

        public Iterator<K> iterator() {
            return new KeyIterator();
        }

    }

    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    // Support for public values method...
    private class ValueIterator implements Iterator<V> {

        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public V next() {
            return entries.next().getValue();
        } // return value!

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private class ValueIterable implements Iterable<V> {

        public Iterator<V> iterator() {
            return new ValueIterator();
        }

    }

    public Iterable<V> values() {
        return new ValueIterable();
    }
}
