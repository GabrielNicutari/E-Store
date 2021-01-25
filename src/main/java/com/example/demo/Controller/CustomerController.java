package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {
        "http://localhost:8081",
        "http://localhost:3000",
        "https://next-level-web-client.herokuapp.com",
        "http://nextlevelclient-env.eba-3tw249tp.us-east-1.elasticbeanstalk.com",
        "http://nextlevelclient-env.eba-5fkitpmg.us-east-1.elasticbeanstalk.com"
})
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("")
    public ResponseEntity<List<Customer>> fetchAll() {
        List<Customer> customers = customerRepository.findAll();

        if(customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer _customer = customerRepository.save(customer);
        return new ResponseEntity<>(_customer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        Optional<Customer> customers = customerRepository.findById(id);

        if (customers.isPresent()) {
            Customer _customer = customers.get();
            _customer.setFirstName(customer.getFirstName());
            _customer.setLastName(customer.getLastName());
            _customer.setDateOfBirth(customer.getDateOfBirth());
            _customer.setPhoneNumber(customer.getPhoneNumber());
            _customer.setAddress(customer.getAddress());
            _customer.setCity(customer.getCity());
            _customer.setCountry(customer.getCountry());
            _customer.setFirstName(customer.getFirstName());

            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") int id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
