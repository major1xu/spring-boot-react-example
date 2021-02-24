package com.uudaddy.SpringBootReact.demo.beer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerReader {

    @PersistenceContext
    private EntityManager entityManager;

    public String findFullName(Long customerID){
        Customer customer = entityManager.find(Customer.class, customerID);
        return customer.getFirstName() +" "+customer.getLastName();
    }

}
