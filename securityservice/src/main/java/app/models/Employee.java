package app.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    Integer id;
    String username;
    String password;
}
