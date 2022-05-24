/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapsSorting;

import java.util.Comparator;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Dec 9,2020(Assignment-4)
 */
public class DefaultComparator implements Comparator<Entry<String, PostalCode>> {

    public int compare(Entry<String, PostalCode> o1, Entry<String, PostalCode> o2) {

        return o1.getKey().compareTo(o2.getKey()); //To change body of generated methods, choose Tools | Templates.
    }
}
