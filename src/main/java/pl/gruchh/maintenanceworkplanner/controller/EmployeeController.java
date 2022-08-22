package pl.gruchh.maintenanceworkplanner.controller;

import org.springframework.web.bind.annotation.*;
import pl.gruchh.maintenanceworkplanner.controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkplanner.controller.DTO.WorkDto;
import pl.gruchh.maintenanceworkplanner.exception.EmployeeNotFoundException;
import pl.gruchh.maintenanceworkplanner.repository.Entity.Employee;
import pl.gruchh.maintenanceworkplanner.service.EmployeeService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

import static pl.gruchh.maintenanceworkplanner.controller.mapper.EmployeeDtoMapper.getEmployeeDto;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/work-summary")
    public List<WorkDto> getAllDurationTime() {
        return employeeService.getAllWorksSummary();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return getEmployeeDto(employeeService.getEmployeeById(id));
    }

    @PostMapping()
    public Employee saveNewEmployee(@RequestBody @Valid EmployeeDto newEmployeeDto) {
        Employee employee = new Employee();
        employee.setName(newEmployeeDto.name());
        employee.setSurname(newEmployeeDto.surname());
        employee.setEditionDate(LocalDate.now());
        return employeeService.saveNewEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee  changeEmployeeDetails(@PathVariable("id") Long id, @RequestBody @Valid EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(employeeDto.name());
        employee.setSurname(employeeDto.surname());
        employee.setDateOfEmployment(LocalDate.now());
        return employeeService.updateEmployeeDetails(employee);
    }


}