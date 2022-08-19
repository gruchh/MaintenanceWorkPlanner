package pl.gruchh.maintenanceworkplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gruchh.maintenanceworkplanner.repository.Entity.WorkOrder;

public interface WorkOrderRepository extends JpaRepository <WorkOrder, Long> {
}
