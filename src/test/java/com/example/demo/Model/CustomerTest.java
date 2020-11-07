package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    String str = "2020-01-01";
    Date dateTest = Date.valueOf(str);
    private Customer customer = new Customer("firstNameTest", "lastNameTest", dateTest,
            "phoneNumberTest", "addressTest", "cityTest", "countryTest");

    @Test
    void getId() {
        assertEquals(0, customer.getId());
    }

    @Test
    void setId() {
        customer.setId(10);
        assertEquals(10, customer.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("firstNameTest", customer.getFirstName());
    }

    @Test
    void setFirstName() {
        customer.setFirstName("newFirstName");
        assertEquals("newFirstName", customer.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("lastNameTest", customer.getLastName());
    }

    @Test
    void setLastName() {
        customer.setLastName("newLastName");
        assertEquals("newLastName", customer.getLastName());
    }

    @Test
    void getDateOfBirth() {
        String str = "2020-01-01";
        Date date = Date.valueOf(str);
        assertTrue(date.equals(customer.getDateOfBirth()));
    }

    @Test
    void setDateOfBirth() {
        String str = "2020-12-31";
        Date date = Date.valueOf(str);
        customer.setDateOfBirth(date);
        assertTrue(date.equals(customer.getDateOfBirth()));
    }

    @Test
    void getPhoneNumber() {
        assertEquals("phoneNumberTest", customer.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        customer.setPhoneNumber("newPhoneNumber");
        assertEquals("newPhoneNumber", customer.getPhoneNumber());
    }

    @Test
    void getAddress() {
        assertEquals("addressTest", customer.getAddress());
    }

    @Test
    void setAddress() {
        customer.setAddress("newAddress");
        assertEquals("newAddress", customer.getAddress());
    }

    @Test
    void getCity() {
        assertEquals("cityTest", customer.getCity());
    }

    @Test
    void setCity() {
        customer.setCity("newCity");
        assertEquals("newCity", customer.getCity());
    }

    @Test
    void getCountry() {
        assertEquals("countryTest", customer.getCountry());
    }

    @Test
    void setCountry() {
        customer.setCountry("newCountry");
        assertEquals("newCountry", customer.getCountry());
    }

    @Test
    void testEquals() {
        String str = "2020-01-01";
        Date dateTest = Date.valueOf(str);
        Customer newCustomer = new Customer("firstNameTest", "lastNameTest", dateTest,
                "phoneNumberTest", "addressTest", "cityTest", "countryTest");
        assertTrue(newCustomer.equals(customer));
    }

    @Test
    void testNotEquals() {
        Customer emptyCustomer = new Customer();
        assertFalse(emptyCustomer.equals(customer));
    }

    @Test
    void testHashCode() {
        int result = customer.getId() * 31 + customer.getFirstName().hashCode();
        result = result * 31 + customer.getLastName().hashCode();
        result = result * 31 + customer.getDateOfBirth().hashCode();
        result = result * 31 + customer.getPhoneNumber().hashCode();
        result = result * 31 + customer.getAddress().hashCode();
        result = result * 31 + customer.getCity().hashCode();
        result = result * 31 + customer.getCountry().hashCode();

        assertEquals(result, customer.hashCode());
    }

}