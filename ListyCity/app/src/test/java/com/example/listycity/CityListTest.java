package com.example.listycity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Just FYI, some people might have false positive tests because the app-level Gradle code was wrong;
// see app-level gradle, very bottom, for more details!
public class CityListTest {
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException(){
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
    // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
    // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
    // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
    // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCities(){
        CityList cityList = mockCityList();
        City city = new City("Calgary","AB");

        // City is not in cityList yet, should return FALSE
        assertFalse(cityList.hasCity(city));

        // City added to cityList and now it should return TRUE
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDeleteCity(){
        CityList cityList = mockCityList();
        City city = new City("Prince Rupert","BC");
        cityList.add(city);

        // First check to see that the city is included in cityList
        assertEquals(2,cityList.getCities().size());

        // Delete and assert that City city is not in the list, then check cityList's size
        cityList.delete(city);
        assertFalse(cityList.getCities().contains(city));
        assertEquals(1,cityList.getCities().size());

        // test to see if the program throws an exception
        City city2 = new City("Whitehorse","YT");
        assertThrows(IllegalArgumentException.class, () ->{
            // city2 is NOT in cityList so this should throw an exception on request for deletion
            cityList.delete(city2);
        });
    }

    @Test
    void testCitiesCount(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City cityA = new City("Calgary", "AB");
        cityList.add(cityA);
        assertEquals(2, cityList.countCities());

        City cityB = new City("Vancouver", "BC");
        cityList.add(cityB);
        assertEquals(3, cityList.countCities());


        City cityC = new City("Montreal", "QC");
        cityList.add(cityC);
        assertEquals(4, cityList.countCities());
    }
}
