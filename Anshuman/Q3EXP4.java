class University {
    static String universityName = "Central University";
    String studentName;

    public University(String studentName) {
        this.studentName = studentName;
    }

    static void displayUniversityName() {
        System.out.println("University Name: " + universityName);
    }

    void displayStudentDetails() {
        System.out.println("Student Name: " + studentName);
    }
}

public class Q3EXP4 {
    public static void main(String[] args) {

        University.displayUniversityName();

        University student1 = new University("Aditya");
        University student2 = new University("Rahul");
        University student3 = new University("Dhruv");

        student1.displayStudentDetails();
        student2.displayStudentDetails();
        student3.displayStudentDetails();

        System.out.println("Changing university name to 'Tech University'");
        University.universityName = "Tech University";

        University.displayUniversityName();
    }
}
