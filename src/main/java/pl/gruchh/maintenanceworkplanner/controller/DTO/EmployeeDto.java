package pl.gruchh.maintenanceworkplanner.controller.DTO;

import javax.validation.constraints.NotBlank;

public record EmployeeDto(Long id,
                          @NotBlank(message = "Name is mandatory")
                          String name,
                          @NotBlank(message = "Surname is mandatory")
                          String surname) {
}
