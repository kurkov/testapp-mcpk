package com.carano.testapp.service;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component
public class ZipServiceFromFileImpl implements ZipService {

    @Override
    public List<String> getAllZipCodes() {
        // read the zipCodePerCity.txt and return an unique, sorted ascendent list of all the zip codes
        Set<Integer> zipCodesSet = new TreeSet<>();
        try {
            File file = ResourceUtils.getFile("classpath:zipCodePerCity.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                zipCodesSet.add(Integer.valueOf(values[0]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // converting sorted set of integers to list of strings
        List<String> zipCodes = new ArrayList<>(zipCodesSet.size());
        for (Integer value : zipCodesSet) {
            zipCodes.add(String.valueOf(value));
        }

        return zipCodes;
    }

    @Override
    public List<String> getAllCitiesByZipCode(String zipCode) {
        // read the zipCodePerCity.txt and return an unique, sorted ascendent list of all the cities matching this zip code
        if (zipCode == null || zipCode.equals("")) {
            return Collections.emptyList();
        }

        Multimap<String, String> map = TreeMultimap.create();
        try {
            File file = ResourceUtils.getFile("classpath:zipCodePerCity.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                map.put(values[0], values[1]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collection<String> collection = map.get(zipCode);
        return new ArrayList<>(collection);
    }

    @Override
    public List<String> getAllZipCodesThatShareACity() {
        // read the zipCodePerCity.txt and find all the zipCodes that belong to more than one city.
        // for instance, you can find in the file small cities that share the same zip code:
        // 1990;Großkmehlen
        // 1990;Frauendorf
        // 1990;Ortrand
        // we want the list of this kind of zip codes.

        List<String> checkList = new ArrayList<>();  // this list is for checking if zip code has more than one city
        Set<Integer> zipCodesSet = new TreeSet<>();  // this set is for storing sorted result
        try {
            File file = ResourceUtils.getFile("classpath:zipCodePerCity.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                String zipCode = values[0];
                if (checkList.isEmpty()) {
                    checkList.add(zipCode);
                } else {
                    if (checkList.contains(zipCode)) {
                        zipCodesSet.add(Integer.valueOf(zipCode));
                    } else {
                        checkList.add(zipCode);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // converting sorted set of integers to list of strings
        List<String> zipCodes = new ArrayList<>(zipCodesSet.size());
        for (Integer value : zipCodesSet) {
            zipCodes.add(String.valueOf(value));
        }

        return zipCodes;
    }

}
