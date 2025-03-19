import java.util.List;
import java.util.ArrayList;

public class Organization {
    List<Department> departmentList = new ArrayList<>();

    /**
     * adds the department if it do not exist
     * @param dept department to be added
     * @return true if the department id added else false
     */
    public boolean addDepartment(Department dept) {
        if (dept != null && !departmentList.contains(dept)) {
            departmentList.add(dept);
            return true;
        }
        return false;
    }

    /**
     * extracts all employees of that department
     * @return list of all employees of that department
     */
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployes = new ArrayList<>();
        for (Department dept : departmentList) {
            allEmployes.addAll(dept.getEmployees());
        }
        return allEmployes;
    }
}
