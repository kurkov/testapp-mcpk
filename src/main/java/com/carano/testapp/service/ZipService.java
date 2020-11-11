package com.carano.testapp.service;

import java.util.List;

public interface ZipService
{
  public List<String> getAllZipCodes();
  
  public List<String> getAllCitiesByZipCode( String zipCode );

  public List<String> getAllZipCodesThatShareACity();
}
