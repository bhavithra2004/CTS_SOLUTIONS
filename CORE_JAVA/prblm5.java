import java.util.Scanner;
public class prblm5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Use a for loop to print the multiplication table up to 10
        System.out.println("Multiplication table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        input.close();
    }
    
}
