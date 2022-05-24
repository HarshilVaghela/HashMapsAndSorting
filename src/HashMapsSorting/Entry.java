/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapsSorting;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Dec 9,2020(Assignment-4)
 */
/*
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 */
/**
 * Interface for a key-value pair.
 */
public interface Entry<K, V> {

    /**
     * Returns the key stored in this entry.
     *
     * @return the entry's key
     */
    K getKey();

    /**
     * Returns the value stored in this entry.
     *
     * @return the entry's value
     */
    V getValue();
}
