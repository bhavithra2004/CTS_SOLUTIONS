import java.util.Scanner;
public class prblm11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();
        if (number < 0) {
            System.out.println("Invalid input! Please enter a non-negative integer.");
            input.close();
            return;
        }
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
        input.close();
    }
}

