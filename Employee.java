/**
 * @author avinash
 */
public class Employee {
    private Integer id;
    private String name;
    private Integer salary;
    private String email;

    public Employee(int i, String d, Integer i1, String mail) {
        this.id = i;
        this.name = d;
        this.salary = i1;
        this.email = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
