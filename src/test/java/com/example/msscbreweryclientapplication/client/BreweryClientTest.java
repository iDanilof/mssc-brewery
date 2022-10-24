package com.example.msscbreweryclientapplication.client;

import java.net.URI;
import java.util.UUID;

import com.example.msscbreweryclientapplication.model.BeerDto;
import com.example.msscbreweryclientapplication.model.CustomerDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void createNewBeer() {
        URI uri = breweryClient.createNewBeer(BeerDto.builder().beerName("New beer").beerStyle("IPA").price("12").upc("122").build());

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        breweryClient.updateNewBeer(beerDto.getId(), beerDto);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomer() {
        CustomerDto customerDto = breweryClient.getCustomer(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void createNewCustomer() {
        URI uri = breweryClient.createCustomer(CustomerDto.builder().name("new Customer").build());

        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = breweryClient.getCustomer(UUID.randomUUID());
        breweryClient.updateCustomer(UUID.randomUUID() ,customerDto);
    }

    @Test
    void deleteCustomer(){
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}