public class EmployeeNew {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public EmployeeNew(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked + 1;
    }
}