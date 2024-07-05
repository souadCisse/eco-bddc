package ma.enset.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder@ToString
public class Customer {
    private Long id;
    private String name;
    private String email;
}
