package app.repo;

import app.model.CustomerCredits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCreditRepo extends JpaRepository<CustomerCredits, Integer> {

}
