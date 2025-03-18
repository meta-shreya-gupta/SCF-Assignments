/**
 * utility class to implement abstraction , inheritance and composition
 */
abstract class Employee {
    protected String name;
    protected int emp_Id;

    /**
     * abstract method to get basic salary of the employee
     * @return salary as double data type
     */
    public abstract double getBasicSalary();

    /**
     * abstract method to get bonus of the employee
     * @return bonus as double data type
     */
    public abstract double getBonus();

    /**
     * abstract method to get compensation of the employee
     * @return compensation as double data type
     */
    public abstract double getCompensation();

    public Employee(String name, int emp_Id) {
        this.name = name;
        this.emp_Id = emp_Id;
    }

    /**
     * extracts name of the employee
     * @return name as string of an employee
     */
    public String getName() {
        return name;
    }

    /**
     * extract employee id of employee
     * @return employee id as an integer
     */
    public int getEmp_Id() {
        return emp_Id;
    }

}
/**
 * utility developer class to extend employee class
 */
class Developer extends Employee {
    final double DEVELOPER_BASIC_SALARY = 50000.0;
    final double DEVELOPER_BONUS = 1000.0;
    final double DEVELOPER_COMPENSATION = 1500.0;

    public Developer(String name, int emp_Id) {
        super(name, emp_Id);
    }

    /**
     * get basic salary of the employee . overridden method from employee parent class
     * @return salary as double data type
     */
    @Override
    public double getBasicSalary() {
        return DEVELOPER_BASIC_SALARY;
    }

    /**
     * get bonus of the employee . overridden method from employee parent class
     * @return bonus as double data type
     */
    @Override
    public double getBonus() {
        return DEVELOPER_BONUS;
    }

    /**
     * get compensation of the employee . overridden method from employee parent class
     * @return compensation as double data type
     */
    @Override
    public double getCompensation() {
        return DEVELOPER_COMPENSATION;
    }
}
/**
 * utility manager class to extend employee class
 */
class Manager extends Employee {
    final double MANAGER_BASIC_SALARY = 70000.0;
    final double MANAGER_BONUS = 1500.0;
    final double MANAGER_COMPENSATION = 2000.0;

    public Manager(String name, int emp_Id) {
        super(name, emp_Id);
    }

    /**
     * get basic salary of the employee . overridden method from employee parent class
     * @return salary as double data type
     */
    @Override
    public double getBasicSalary() {
        return MANAGER_BASIC_SALARY;
    }

    /**
     * get bonus of the employee . overridden method from employee parent class
     * @return bonus as double data type
     */
    @Override
    public double getBonus() {
        return MANAGER_BONUS;
    }

    /**
     * get compensation of the employee . overridden method from employee parent class
     * @return compensation as double data type
     */
    @Override
    public double getCompensation() {
        return MANAGER_COMPENSATION;
    }
}
/**
 * utility tester class to extend employee class
 */
class Tester extends Employee {
    final double TESTER_BASIC_SALARY = 75000.0;
    final double TESTER_BONUS = 2000.0;
    final double TESTER_COMPENSATION = 2500.0;

    public Tester(String name, int emp_Id) {
        super(name, emp_Id);
    }

    /**
     * get basic salary of the employee . overridden method from employee parent class
     * @return salary as double data type
     */
    @Override
    public double getBasicSalary() {
        return TESTER_BASIC_SALARY;
    }

    /**
     * get bonus of the employee . overridden method from employee parent class
     * @return bonus as double data type
     */
    @Override
    public double getBonus() {
        return TESTER_BONUS;
    }

    /**
     * get compensation of the employee . overridden method from employee parent class
     * @return compensation as double data type
     */
    @Override
    public double getCompensation() {
        return TESTER_COMPENSATION;
    }
}