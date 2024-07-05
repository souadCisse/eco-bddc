package ma.enset.customerservice.web;

import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@EnableMethodSecurity(prePostEnabled = true)
public class CustomerRestController {
    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<Customer> CustomerList(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer productById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
    @GetMapping("/auth")
    Authentication authentication(Authentication authentication){
        return authentication;
    }
}
