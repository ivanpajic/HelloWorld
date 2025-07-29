public class Employee {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public Employee(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }
// change on remote 12
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
// change on remote
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
