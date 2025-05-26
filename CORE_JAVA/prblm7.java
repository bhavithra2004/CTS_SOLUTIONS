public class prblm7 {
    public static void main(String[] args) {
        double myDouble = 9.75;
        int myInt = (int) myDouble;
        System.out.println("Original double value: " + myDouble);
        System.out.println("Double cast to int: " + myInt);
        int anotherInt = 42;
        double anotherDouble = (double) anotherInt;
        System.out.println("Original int value: " + anotherInt);
        System.out.println("Int cast to double: " + anotherDouble);
    }
}
