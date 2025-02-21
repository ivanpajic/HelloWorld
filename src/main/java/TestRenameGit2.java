public class TestRenameGit2 {

    public static void main(String[] args) {
        EmployeeNew employee = new EmployeeNew("John Doe", 25.0);
        employee.setHoursWorked(40);
        System.out.println("Dino2: " + employee.calculateSalary());
        System.out.println("Ivan: " + employee.calculateSalary());
        System.out.println("Salary ivan2: " + employee.calculateSalary());
    }


}
