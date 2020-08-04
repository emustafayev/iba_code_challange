package app.model;


import lombok.Data;

@Data
public class XCustomer {
    private Integer id;
    private String name;
    private String surname;
    private String age;
    private Integer monthlyPaymentCapacity;
}
