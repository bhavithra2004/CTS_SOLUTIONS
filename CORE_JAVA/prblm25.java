import java.util.HashMap;
import java.util.Scanner;
class prblm25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            map.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();
        System.out.println("Name: " + map.getOrDefault(searchId, "Not found"));
    }
}
