package ma.enset.orderservice.restclients;

import ma.enset.orderservice.model.Customer;
import ma.enset.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8089",value = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers")
    List<Customer> getAllCustomers();
    @GetMapping("/api/customers/{id}")
    Product findCustomerById(@PathVariable Long id);
}
