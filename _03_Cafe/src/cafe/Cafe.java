package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe
{
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee)
    {
        if(employees.size() < capacity)
        {
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name)
    {
        Employee employee = getEmployee(name);
        if(employee != null)
        {
            employees.remove(employee);
            return true;
        }
        return false;
    }
    public Employee getOldestEmployee()
    {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }
    public Employee getEmployee(String name)
    {
        return employees.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount()
    {
        return employees.size();
    }
    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:%n", name));
        for(Employee employee : employees)
        {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
