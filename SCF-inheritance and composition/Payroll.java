public class Payroll {
    /**
     * calculated tax on the salary of the employee . tax = 5% of total salary
     * @param totalSalary salary at which tax is to be calculated
     * @return computed tax on total salary
     */
    double calculateTax(double totalSalary) {
        double tax = 0.05 * totalSalary;
        return tax;
    }

    /**
     * it displays all the details of all the employe one by one
     * @param employee whose details is to be displayed
     */
    public void printSalarySlip(Employee employee) {
        double totalSalary = employee.getBasicSalary() + employee.getBonus() + employee.getCompensation();
        double tax = calculateTax(totalSalary);

        System.out.println("---------- Salary Slip ----------");
        System.out.println("Employee ID : " + employee.getEmp_Id());
        System.out.println("Name : " + employee.getName());
        System.out.println("Basic Salary : " + employee.getBasicSalary());
        System.out.println("Bonus : " + employee.getBonus());
        System.out.println(("Compensation : " + employee.getCompensation()));
        System.out.println("Total salary : " + totalSalary);
        System.out.println("Tax Amount : " + tax);
        System.out.println("Overall Salary : " + (totalSalary - tax));
    }
}
