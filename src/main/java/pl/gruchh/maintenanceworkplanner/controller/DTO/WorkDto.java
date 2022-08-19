package pl.gruchh.maintenanceworkplanner.controller.DTO;

public class WorkDto {

    private String name;
    private Long workDuration;

    public WorkDto(String name, Long workDuration) {
        this.name = name;
        this.workDuration = workDuration;
    }

    public WorkDto(String name) {
        this.name = name;
        this.workDuration=2L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWorkDuration() {
        return workDuration;
    }

    public void setWorkDuration(Long workDuration) {
        this.workDuration = workDuration;
    }
}
