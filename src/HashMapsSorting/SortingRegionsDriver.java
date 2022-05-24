/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapsSorting;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Dec 9,2020(Assignment-4)
 */
public class SortingRegionsDriver {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedChainHashMap<String, PostalCode> map = new LinkedChainHashMap<>();// ProbeHashMap<String,PostalCode> map=new ProbeHashMap<>();
        Scanner doc = new Scanner(new File("test/CanadaPostalCodes.txt"));
        while (doc.hasNext()) {// entering the lines from the document to the LinkedChainHashMap
            String line = doc.nextLine();
            Scanner lineScan = new Scanner(line).useDelimiter(",");
            String code = lineScan.next();
            String area = lineScan.next();
            String province = lineScan.next();
            double lon = lineScan.nextDouble();
            double lat = lineScan.nextDouble();
            map.put(code, new PostalCode(code, area, province, lon, lat));
        }
        Entry<String, PostalCode>[] obj = new Entry[map.size()];
        int a = 0;
        for (Entry<String, PostalCode> ent : map.entrySet()) // entering the entries from the LinkedChainHashMap to an array
        {
            obj[a] = ent;
            a++;
        }
        System.out.println("Total : " + map.size());
        System.out.println("Number of Collisions :" + map.getCollisions());
        System.out.println("Enter C to display by code or enter L to display by longitude (any other key to quit)");
        Scanner input = new Scanner(System.in);
        String in = input.next().toUpperCase();// this is to ask the user what they want the data to be sorted as
        switch (in) {
            case "C":
                QuickSort.quickSortInPlace(obj, new DefaultComparator(), 0, obj.length - 1);// sorting the array by code
                break;
            case "L":
                QuickSort.quickSortInPlace(obj, new OrderByLongitude(), 0, obj.length - 1);// sorting the array by longitude
                break;
            default:
                System.out.println("End of the program");
                break;
        }
        //QuickSort.quickSortInPlace(obj,new OrderByLongitude(),0,obj.length-1);
        if (in.equals("L") || in.equals("C")) {
            for (Entry<String, PostalCode> obj1 : obj) {
                System.out.println(obj1.getKey() + ": " + obj1.getValue());
            }
        }
    }
}
