class Student {
    private String name;
    private int age;

    public Student() {
        this.name = "Default Name";
        this.age = 18;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Q1EXP4 {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("Student 1 details:");
        student1.display();

        System.out.println();
        Student student2 = new Student("Anshuman", 19);
        System.out.println("Student 2 details:");
        student2.display();
    }
}
