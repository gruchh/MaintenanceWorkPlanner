package pl.gruchh.maintenanceworkplanner.repository.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @OneToOne(mappedBy = "phone")
    private Employee employee;


}
