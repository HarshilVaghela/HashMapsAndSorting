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
public class PostalCode implements Comparable<PostalCode> {

    private String code, area, province;
    private double longitude, latitude;

    /**
     *
     * @param c postal code
     * @param a area the postal code belongs to
     * @param p province the postal code belongs to
     * @param la latitude of the corresponding postal code
     * @param lo longitude of the corresponding postal code
     */
    public PostalCode(String c, String a, String p, double la, double lo) {
        code = c;
        area = a;
        province = p;
        longitude = lo;
        latitude = la;
    }

    /**
     *
     */
    public PostalCode() {
        this("None", "None", "None", 0, 0);
    }

    /**
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    @Override
    public int compareTo(PostalCode o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }

    public String toString() {
        return code + " " + area + " " + province + " " + longitude + " " + latitude;
    }

}
