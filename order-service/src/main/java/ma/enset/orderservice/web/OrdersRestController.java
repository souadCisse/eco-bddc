package ma.enset.orderservice.web;

import ma.enset.orderservice.entities.Order;
import ma.enset.orderservice.repositories.OrderRepository;
import ma.enset.orderservice.restclients.InventoryRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersRestController {
    private OrderRepository orderRepository;
    private InventoryRestClient inventoryRestClient;

    public OrdersRestController(OrderRepository orderRepository, InventoryRestClient inventoryRestClient) {
        this.orderRepository = orderRepository;
        this.inventoryRestClient = inventoryRestClient;
    }

    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }
@GetMapping("/orders/{id}")
    public Order findById(@PathVariable String id){
    Order order = orderRepository.findById(id).get();
    order.getProductItems().forEach(pi->{
        pi.setProduct(inventoryRestClient.findProductById(pi.getProductId()));
    });
    return order;
}
}
