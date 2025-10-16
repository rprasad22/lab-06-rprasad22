package com.example.listycity;

/**
 * Represents a city with a name and province
 */
public class City implements Comparable<City> {

    private String city;
    private String province;

    /**
     * Builds a City in the format "city", "province" with a given city and province
     * @param city
     *          a string type, named city
     * @param province
     *          a string type, named province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * getter for CityName
     * @return
     *      returns the city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * getter for ProvinceName
     * @return
     *      returns the province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * This method compares City objects based on their city name field.
     * @param o the object to be compared.
     * @return 0, <1, or >1 if two values are equal a<b, or a>b
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }
}

