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
public class OrderByFrequency implements Comparator<Entry<String, Integer>> {

    

    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        return o2.getValue() - o1.getValue(); 
    }
}