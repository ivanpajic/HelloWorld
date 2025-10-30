public class EmployeeNew {
    private final String name;
    private double hourlyRate;
    private int hoursWorked;
    // something to add here
    
    public EmployeeNew(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hourlyRate = hourlyRate;
    }
    // and here and here
    // and here and here
    // and here and here
    // and here and here c hange

    // change
    // change
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked + 1;
    }
}
