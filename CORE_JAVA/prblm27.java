import java.util.*;
class prblm27 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Banana", "Apple", "Cherry");
        list.sort((s1, s2) -> s1.compareTo(s2));
        list.forEach(System.out::println);
    }
}
