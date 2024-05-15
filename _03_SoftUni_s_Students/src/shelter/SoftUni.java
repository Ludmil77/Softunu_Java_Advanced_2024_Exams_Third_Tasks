package shelter;

import java.util.ArrayList;
import java.util.List;

public class SoftUni
{
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }

    public int getCount()
    {
        return data.size();
    }

    public String insert(Student student)
    {
        if(data.contains(student))
        {
            return String.format("Student is already in the hall.");
        }
        if(data.size() >= capacity)
        {
            return String.format("The hall is full.");
        }

        data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }
    public String remove(Student student)
    {
        if(data.contains(student))
        {
            data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return String.format("Student not found.");
    }
    public Student getStudent(String firstName, String lastName)
    {
        return data.stream().filter(x -> x.getFirstName().equals(firstName) && x.getLastName().equals(lastName)).findFirst().orElse(null);
    }
    public String getStatistics()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d%n", data.size()));
        for(Student student : data)
        {
            sb.append(student.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
