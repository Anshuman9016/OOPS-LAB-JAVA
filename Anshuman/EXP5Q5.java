import java.util.ArrayList;
import java.util.List;

abstract class Person {
    protected String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public abstract void performDuty();
}

class Student extends Person {
    public Student(String name) {
        super(name);
    }
    
    @Override
    public void performDuty() {
        System.out.println(name + " is studying.");
    }
}

class Teacher extends Person {
    public Teacher(String name) {
        super(name);
    }
    
    @Override
    public void performDuty() {
        System.out.println(name + " is teaching.");
    }
}

public class EXP5Q5 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        
        people.add(new Student("Anand"));
        people.add(new Teacher("Mr. Seth"));
        people.add(new Student("Rahul"));
        people.add(new Teacher("Mrs. Falguni"));

        for (Person person : people) {
            person.performDuty();
        }
    }
}