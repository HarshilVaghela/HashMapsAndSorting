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
public class OrderByLongitude implements Comparator<Entry<String, PostalCode>> {

    @Override
    public int compare(Entry<String, PostalCode> o1, Entry<String, PostalCode> o2) {int i=0;
        if(o1.getValue().getLongitude()-o2.getValue().getLongitude()<0){
            i=-1;
        }else if(o1.getValue().getLongitude()-o2.getValue().getLongitude()>0){i=1;}
    
    return  i; //To change body of generated methods, choose Tools | Templates.
    }
    
}
