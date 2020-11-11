package com.carano.testapp.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipServiceFromFileImplTest {


    @Autowired
    private ZipService zipService;

    @Test
    public void testGetAllZipCodes() {
        // when
        final List<String> codes = zipService.getAllZipCodes();
        // then
        assertNotNull(codes);
        assertFalse(codes.isEmpty());
        assertTrue(codes.contains("10559"));
    }

    @Test
    public void testGetAllCitiesByZipCodeWithANullParam() {
        // given
        final String nullAsParameter = null;
        // when
        final List<String> cities = zipService.getAllCitiesByZipCode(nullAsParameter);
        // then
        List<String> expectedCities = Collections.emptyList();
        Assert.assertEquals(expectedCities, cities);
    }

    // test what happen once no zip code given
    @Test
    public void testGetAllCitiesByZipCodeWithNoZipCodeGiven() {
        // given
        final String zipCode = "";
        // when
        final List<String> cities = zipService.getAllCitiesByZipCode(zipCode);
        // then
        List<String> expectedCities = Collections.emptyList();
        Assert.assertEquals(expectedCities, cities);
    }

    @Test
    public void testGetAllCitiesByZipCodeWithAZipCodeWichIsNotInTheFile() {
        // given
        final String nonExistingZipCode = "999999";
        // when
        final List<String> cities = zipService.getAllCitiesByZipCode(nonExistingZipCode);
        // then
        List<String> expectedCities = Collections.emptyList();
        Assert.assertEquals(expectedCities, cities);
    }

    @Test
    public void testGetAllCitiesByZipCodeWithAValidZipCode() {
        // given
        final String existingZipCode = "1990";
        // when
        final List<String> cities = zipService.getAllCitiesByZipCode(existingZipCode);
        //then
        List<String> expectedCities = Arrays.asList("Frauendorf", "Gro�kmehlen", "Ortrand");
        Assert.assertEquals(expectedCities, cities);
    }

    @Test
    public void testGetAllZipCodesThatShareACity() {
        final List<String> codes = zipService.getAllZipCodesThatShareACity();
        assertNotNull(codes);
        assertFalse(codes.isEmpty());
        assertTrue(codes.contains("1990"));
    }
}
