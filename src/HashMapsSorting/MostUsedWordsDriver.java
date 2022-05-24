/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapsSorting;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Dec 9,2020(Assignment-4)
 */
public class MostUsedWordsDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Map<String, Integer> freq = new ProbeHashMap<>(); // or any concrete map
        // scan input for words, using all nonletters as delimiters
        Scanner doc = new Scanner(new File("test/HarryPotter-1.txt")).useDelimiter("[^a-zA-Z]+");
        while (doc.hasNext()) {
            String word = doc.next().toLowerCase(); // convert next word to lowercase
            Integer count = freq.get(word); // get the previous count for this word
            if (count == null) {
                count = 0; // if not in map, previous count is zero
            }
            freq.put(word, 1 + count); // (re)assign new count for this word
        }

        Entry<String, Integer>[] obj = new Entry[freq.size()];// entering the entries from the probehashmap to an array
        int a = 0;
        for (Entry<String, Integer> ent : freq.entrySet()) {
            obj[a] = ent;
            a++;
        }

        MergeSort.mergeSort(obj, new OrderByFrequency());// sorting the array by the frequency of the entries
        for (int i = 0; i < 20; i++) {// printing the 20 most used words from the text
            System.out.println(i + 1 + "." + obj[i].getKey() + ":" + obj[i].getValue());
        }
    }

}
