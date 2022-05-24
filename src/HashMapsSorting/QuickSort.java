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
public class QuickSort {

    public static <K> void quickSortInPlace(K[] S, Comparator<K> comp,
            int a, int b) {
        if (a >= b) {
            return; // subarray is trivially sorted
        }
        int left = a;
        int right = b - 1;
        K pivot = S[b];
        K temp; // temp object used for swapping
        while (left <= right) {  // scan until reaching value equal or larger than pivot (or right marker)
            while (left <= right && comp.compare(S[left], pivot) <= 0) {
                left++;
            }
            // scan until reaching value equal or smaller than pivot (or left marker)
            while (left <= right && comp.compare(S[right], pivot) >= 0) {
                right--;
            }
            if (left <= right) { // indices did not strictly cross
                // so swap values and shrink range
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }  // put pivot into its final place (currently marked by left index)
        temp = S[left];
        S[left] = S[b];
        S[b] = temp;
// make recursive calls
        quickSortInPlace(S, comp, a, left - 1);
        quickSortInPlace(S, comp, left + 1, b);
    }
}
