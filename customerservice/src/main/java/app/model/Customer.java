package app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "customer_name", nullable = false)
    String name;

    @Column(name = "customer_surname", nullable = false)
    String surname;

    @Column(name = "customer_age", nullable = false)
    String age;

    @Column(name = "monthly_payment_capacity", nullable = false)
    Integer monthlyPaymentCapacity;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    Set<CustomerCredits> credits_payment;




}
