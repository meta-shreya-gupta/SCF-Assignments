import java.util.List;
import java.util.ArrayList;

public class Department {

    private String departmentName;
    List<Employee> employees = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * extracts department name
     * @return department name as a string
     */
    public String getDepartment() {
        return departmentName;
    }

    /**
     * It adds the employee in the list if not exist
     * @param emp1 employee to be added
     * @return true id employee gets added else false
     */
    public boolean join(Employee emp1) {
        if (emp1 != null && !employees.contains(emp1)) {
            employees.add(emp1);
            return true;
        }
        return false;
    }

    /**
     * It removes the employee in the list if exist
     * @param emp2 employee to be removed
     * @return true if employee gets successfully removed else false
     */
    public boolean relieve(Employee emp2) {
        if (emp2 != null && employees.contains(emp2)) {
            employees.remove(emp2);
            return true;
        }
        return false;
    }

    /**
     * extracts the list of all the employees
     * @return list of employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }
}
