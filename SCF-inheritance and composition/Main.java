class Main{
    public static void main(String[] args){
        Organization metacube = new Organization();
        Department HR = new Department("HR");
        Department Engineering = new Department("Engineering");

        Employee employee1 = new Developer("Amit" ,1001);
        Employee employee2 = new Manager("Kartik" , 1002);
        Employee employee3 = new Tester("Naman" , 1003);
        Employee employee4 = new Developer("Manisha", 1004);
        if(metacube.addDepartment(HR)){
            HR.join(employee1);
            HR.join(employee2);
        }
        else{
            System.out.println("HR department cannot be added");
        }
        if(metacube.addDepartment(Engineering)){
            Engineering.join(employee3);
            Engineering.join(employee4);
        }
        else{
            System.out.println("Engineering department cannot be added");
        }
        Payroll payroll = new Payroll();

        for(Employee employee : metacube.getAllEmployees()){
            payroll.printSalarySlip(employee);
        }
    }
}
