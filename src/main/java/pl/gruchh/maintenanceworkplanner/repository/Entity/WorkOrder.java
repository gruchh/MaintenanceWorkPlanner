package pl.gruchh.maintenanceworkplanner.repository.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WorkOrders")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private int orderWeight;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd.MM.yyyy"})
    private LocalDate deadLineDate;
    private Long durationTime;

    @ManyToOne
    @JoinColumn(name = "employee_FK")
    private Employee employee;


}
