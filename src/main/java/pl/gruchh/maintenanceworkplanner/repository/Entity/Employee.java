package pl.gruchh.maintenanceworkplanner.repository.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd.MM.yyyy"})
    private LocalDate dateOfEmployment;
    private BigDecimal salary;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Phone phone;
    private LocalDate editionDate;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Breakdown> breakdownSet;
    @OneToMany(mappedBy = "employee")
    private Set<WorkOrder> workOrder;
}
