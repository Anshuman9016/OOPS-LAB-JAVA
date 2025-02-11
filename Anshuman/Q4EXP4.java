class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Course Code: " + this.courseCode);
    }
}

public class Q4EXP4 {
    public static void main(String[] args) {

        Course course1 = new Course("Data Analytics", "DSCSA201");

        course1.displayCourseDetails();
    }
}
