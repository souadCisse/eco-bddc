package ma.enset.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.orderservice.model.Customer;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor@AllArgsConstructor@Builder@ToString@Getter@Setter
@Table(name = "ORDERS")
public class Order {
    @Id
    private String id;
    private LocalDate date ;
    @Enumerated(EnumType.STRING)
    private OrderState state ;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
