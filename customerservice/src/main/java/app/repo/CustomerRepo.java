package app.repo;

import app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


    List<Customer> findAllByMonthlyPaymentCapacityGreaterThan(Integer requiredPayment);
}
