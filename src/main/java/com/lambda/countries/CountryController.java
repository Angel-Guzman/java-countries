package com.lambda.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;

@RestController
@RequestMapping("names")
public class CountryController
{
    // http://localhost:2019/names/all
    @GetMapping(value = "/all",
    produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.ourCountryList.countryList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

//    @GetMapping(value = "start/{letter}",
//    produces = {"application/json"})
//    public ResponseEntity<?> getAllCountries()
//    {
//
//    }
}
