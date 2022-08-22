package pl.gruchh.maintenanceworkplanner.controller.mapper;

import pl.gruchh.maintenanceworkplanner.controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkplanner.repository.Entity.Employee;

public class EmployeeDtoMapper {
    public static EmployeeDto getEmployeeDto(Employee employeeById) {
        return new EmployeeDto(employeeById.getId(), employeeById.getName(), employeeById.getSurname());
    }
}
