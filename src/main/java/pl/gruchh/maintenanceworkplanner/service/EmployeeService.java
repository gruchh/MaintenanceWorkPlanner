package pl.gruchh.maintenanceworkplanner.service;

import org.springframework.stereotype.Service;
import pl.gruchh.maintenanceworkplanner.controller.DTO.WorkDto;
import pl.gruchh.maintenanceworkplanner.exception.EmployeeNotFoundException;
import pl.gruchh.maintenanceworkplanner.repository.EmployeeRepository;
import pl.gruchh.maintenanceworkplanner.repository.Entity.Breakdown;
import pl.gruchh.maintenanceworkplanner.repository.Entity.Employee;
import pl.gruchh.maintenanceworkplanner.repository.Entity.Phone;
import pl.gruchh.maintenanceworkplanner.repository.Entity.WorkOrder;
import pl.gruchh.maintenanceworkplanner.repository.WorkOrderRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final WorkOrderRepository workOrderRepository;

    public EmployeeService(EmployeeRepository employeeRepository, WorkOrderRepository workOrderRepository) {
        this.employeeRepository = employeeRepository;
        this.workOrderRepository = workOrderRepository;

        prepareDb(employeeRepository, workOrderRepository);
    }

    public List<WorkDto> getAllWorksSummary() {
        return employeeRepository.getWorkOrderAndBreakdownDurationTime();
    }

    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);

        return employee;
    }

    private void prepareDb(EmployeeRepository employeeRepository, WorkOrderRepository workOrderRepository) {
        Phone phone1 = new Phone();
        phone1.setNumber(500123456L);

        Phone phone2 = new Phone();
        phone2.setNumber(504111222L);

        Breakdown breakdown1 = new Breakdown();
        breakdown1.setTitle("Nieobsługiwany wyjątek w programie");
        breakdown1.setBreakdownStartDate(LocalDate.of(2022, 3, 2));
        breakdown1.setDurationTime(92L);

        Breakdown breakdown2 = new Breakdown();
        breakdown2.setTitle("Nieobsługiwany wyjątek w programie");
        breakdown2.setBreakdownStartDate(LocalDate.of(2022, 3, 17));
        breakdown2.setDurationTime(25L);

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();

        employee1.setName("Kuba");
        employee1.setSurname("Piątek");
        employee1.setDateOfEmployment(LocalDate.of(2020, 2, 1));
        employee1.setSalary(BigDecimal.valueOf(5000));
        employee1.setPhone(phone1);
        employee1.setBreakdownSet(Set.of(breakdown1, breakdown2));

        employee2.setName("Marcin");
        employee2.setSurname("Sobota");
        employee2.setDateOfEmployment(LocalDate.of(2021, 9, 1));
        employee2.setSalary(BigDecimal.valueOf(4600));
        employee2.setPhone(phone2);
        employee2.setBreakdownSet(Set.of(breakdown1));

        employee3.setName("Tadeusz");
        employee3.setSurname("Wtorek");

        WorkOrder workOrder1 = new WorkOrder();
        workOrder1.setTitle("Obchód");
        workOrder1.setOrderWeight(3);
        workOrder1.setDurationTime(90L);
        workOrder1.setEmployee(employee1);

        WorkOrder workOrder2 = new WorkOrder();
        workOrder2.setTitle("Wymiana siłownika");
        workOrder2.setOrderWeight(2);
        workOrder2.setDurationTime(90L);
        workOrder2.setEmployee(employee1);

        WorkOrder workOrder3 = new WorkOrder();
        workOrder3.setTitle("Wykonanie backupu oprogramowania");
        workOrder3.setOrderWeight(3);
        workOrder3.setDurationTime(50L);
        workOrder3.setEmployee(employee2);

        employeeRepository.saveAll(Arrays.asList(employee1, employee2, employee3));
        workOrderRepository.saveAll(Arrays.asList(workOrder1, workOrder2, workOrder3));
    }

}