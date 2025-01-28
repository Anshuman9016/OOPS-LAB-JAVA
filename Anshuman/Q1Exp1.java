import java.util.*;

public class Q1Exp1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double marks1, marks2, marks3, average;
		
		System.out.print("Enter marks for Subject1 : ");
		marks1 = sc.nextDouble();
		
		System.out.print("Enter marks for Subject2 : ");
		marks2 = sc.nextDouble();
		
		System.out.print("Enter marks for Subject3 : ");
		marks3 = sc.nextDouble();
		
		average = (marks1 + marks2 + marks3) / 3;
		
		System.out.println("Average Marks: " + average);
		
		if (average >= 90) {
			System.out.println("Grade : A");
		} else if (average >= 75) {
			System.out.println("Grade : B");
		} else if (average >= 50) {
			System.out.println("Grade : C");
		} else {
			System.out.println("Grade : F");
		}
	}

}