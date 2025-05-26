import java.util.ArrayList;
import java.util.Scanner;
class prblm24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter student name: ");
            students.add(sc.nextLine());
        }
        System.out.println("Student list:");
        for (String name : students) {
            System.out.println(name);
        }
    }
}
