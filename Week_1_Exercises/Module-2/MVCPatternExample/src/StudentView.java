//This is the view class that displays student details.
//It has a method `displayStudentDetails(String studentName, String studentId, String studentGrade)` to print the student information.

public class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}
