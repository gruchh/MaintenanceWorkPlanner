package pl.gruchh.maintenanceworkplanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchh.maintenanceworkplanner.controller.DTO.WorkDto;
import pl.gruchh.maintenanceworkplanner.service.EmployeeService;

import java.util.List;

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


}
