public class TestRenameGit {

    public static void main(String[] args) {
        EmployeeNew employee = new EmployeeNew("John Doe", 25.0);
        employee.setHoursWorked(40);
        System.out.println("Dino: " + employee.calculateSalary());
        System.out.println("Ivan: " + employee.calculateSalary());
        System.out.println("Salary: " + employee.calculateSalary());
    }


}
