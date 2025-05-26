
    import java.util.Scanner;

public class prblm9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for marks
        System.out.print("Enter marks (0-100): ");
        int marks = input.nextInt();

        // Determine grade based on marks
        char grade;

        if (marks >= 90 && marks <= 100) {
            grade = 'A';
        } else if (marks >= 80) {
            grade = 'B';
        } else if (marks >= 70) {
            grade = 'C';
        } else if (marks >= 60) {
            grade = 'D';
        } else if (marks >= 0) {
            grade = 'F';
        } else {
            System.out.println("Invalid marks entered.");
            input.close();
            return;
        }

        // Display the grade
        System.out.println("Grade: " + grade);

        input.close();
    }
}


