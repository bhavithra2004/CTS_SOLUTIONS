import java.util.Scanner;
public class prblm2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        System.out.println("Choose operation (+, -, *, /): ");
        char op = input.next().charAt(0);
        double result = 0;
        if (op == '+') {
            result = num1 + num2;
        } else if (op == '-') {
            result = num1 - num2;
        } else if (op == '*') {
            result = num1 * num2;
        } else if (op == '/') {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("Cannot divide by zero!");
                input.close();
                return;
            }
        } else {
            System.out.println("Invalid operator!");
            input.close();
            return;
        }
        System.out.println("Result: " + result);
        input.close();
    }
}    
