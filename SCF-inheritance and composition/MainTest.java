import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MainTest {
    
    @Test
    public void joinTest(){
        Employee developer1 = new Developer("Kirti", 1005);
        Employee manager1 = new Manager("Kanishka",1005);
        Employee tester1 = new Tester("Kashish", 1006);

        Department HR = new Department("HR");
        assertEquals(true , HR.join(developer1));
        assertEquals(true , HR.join(manager1));
        assertEquals(true , HR.join(tester1));
    }

    @Test
    public void relievetest(){
        Employee developer1 = new Developer("Kirti", 1005);
        Employee manager1 = new Manager("Kanishka",1005);
        Employee tester1 = new Tester("Kashish", 1006);

        Department HR = new Department("HR");
        HR.join(developer1);
        HR.join(manager1);
        HR.join(tester1);
        assertEquals(true, HR.relieve(developer1));
        assertEquals(true, HR.relieve(manager1));
        assertEquals(true, HR.relieve(tester1));
    }

    @Test
    public void getEmployeesTest(){
        Department HR = new Department("HR");
        Employee developer1 = new Developer("Kirti", 1005);
        Employee manager1 = new Manager("Kanishka",1005);
        HR.join(developer1);
        HR.join(manager1);
        assertEquals(2, HR.getEmployees().size());
    }

    @Test
    public void getAllEmployeesTest(){
        Department HR = new Department("HR");
        Department IT = new Department("IT");
        Employee developer1 = new Developer("Kirti", 1005);
        Employee manager1 = new Manager("Kanishka",1005);
        Organization metacube = new Organization();

        metacube.addDepartment(IT);
        metacube.addDepartment(HR);
        IT.join(developer1);
        HR.join(manager1);
        assertEquals(2, metacube.getAllEmployees().size());
    }

    @Test
    public void addDepartmentTest(){
        Department HR = new Department("HR");
        Department IT = new Department("IT");
        Organization metacube = new Organization();
        assertEquals(true, metacube.addDepartment(IT));
        assertEquals(true, metacube.addDepartment(HR));
    }
}
