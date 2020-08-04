package app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "customer_credit")
public class CustomerCredits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "payment_date", nullable = false)
    LocalDateTime payment_time;

    @Column(name = "paid_time", nullable = false)
    LocalDateTime paid_time;

    @Column(name = "payment_amount", nullable = false)
    Integer payment_amount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

}
