package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds the City type objects in a list
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * This method adds a city object to the cities list
     * @param city
     *          This is a City object we want to add to the list
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city))
            throw new IllegalArgumentException();
        cities.add(city);
    }

    /**
     * his returns a sorted City list
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * returns whether a city is in the list
     * @param city
     *      This is the city object that is being checked to see if it belongs in the
     *      list
     * @return
     *      Returns boolean value for whether the city exists
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This method deletes a city object from the cities list
     * @param city
     *          This is the city object that is being deleted from the list
     *@throws IllegalArgumentException if the city already does not exist in the list
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method checks the total count of cities in the list
     * @return
     *      Returns how many cities are in the list
     */
    public int countCities() {
        return cities.size();
    }
}
