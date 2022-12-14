package pl.gruchh.maintenanceworkplanner.exception;

public class EmployeeNotFoundException extends RuntimeException {

    private String message;

    public EmployeeNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public EmployeeNotFoundException() {
    }
}
