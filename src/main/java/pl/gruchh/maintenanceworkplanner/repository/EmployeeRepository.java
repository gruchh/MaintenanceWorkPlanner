package pl.gruchh.maintenanceworkplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gruchh.maintenanceworkplanner.controller.DTO.WorkDto;
import pl.gruchh.maintenanceworkplanner.repository.Entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query(value = "select new pl.gruchh.maintenanceworkplanner.controller.DTO.WorkDto(employee.name) " +
//            "from Employee employee " +
//            "join employee.workOrder workOrder ")
//    List<WorkDto> getWorkOrderAndBreakdownDurationTime();

//    @Query(value = "select new pl.gruchh.maintenanceworkplanner.controller.DTO.WorkDto(employee.name, sum(breakdown.durationTime + workOrder.durationTime))" +
//            "from Employee employee " +
//            "join employee.workOrder workOrder " +
//            "join employee.breakdownSet breakdown group by employee.name")


    //    List<WorkDto> getWorkOrderAndBreakdownDurationTime();
    @Query(value = "select new pl.gruchh.maintenanceworkplanner.controller.DTO.WorkDto(employee.name) from Employee employee " +
            "join employee.workOrder WorkOrders")
    List<WorkDto> getWorkOrderAndBreakdownDurationTime();

}
