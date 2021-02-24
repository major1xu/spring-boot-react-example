package com.uudaddy.SpringBootReact.demo;

import com.uudaddy.SpringBootReact.demo.beer.Customer;
import com.uudaddy.SpringBootReact.demo.beer.CustomerReader;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
// https://semaphoreci.com/community/tutorials/stubbing-and-mocking-with-mockito-2-and-junit
public class CustomerReaderTest {

    //Class to be tested
    private CustomerReader customerReader;

    //Dependencies
    private EntityManager entityManager;


    @Before
    public void setup(){
        customerReader = new CustomerReader();

        entityManager = mock(EntityManager.class);
        customerReader.setEntityManager(entityManager);
    }

    @Test
    public void happyPathScenario(){
        Customer sampleCustomer = new Customer();
        sampleCustomer.setFirstName("Susan");
        sampleCustomer.setLastName("Ivanova");

        when(entityManager.find(Customer.class,1L)).thenReturn(sampleCustomer);

        String fullName = customerReader.findFullName(1L);
        assertEquals("Susan Ivanova",fullName);
    }
/* need some work
    @Test
    public void customerNotPresentInDb(){
        when(entityManager.find(Customer.class,1L)).thenReturn(null);

        String fullName = customerReader.findFullName(1L);
        assertEquals("",fullName);
    }

 */
}
