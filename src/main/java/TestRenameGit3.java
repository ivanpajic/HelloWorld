public class TestRenameGit3 {

    public static void main(String[] args) {
        EmployeeNew employee = new EmployeeNew("John Doe", 25.0);
        employee.setHoursWorked(40);
        System.out.println("Dino3: " + employee.calculateSalary());
        System.out.println("Ivan: " + employee.calculateSalary());
        System.out.println("Salary ivan3: " + employee.calculateSalary());
    }


}
