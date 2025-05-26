class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
class prblm21 {
    public static void main(String[] args) {
        try {
            int age = 16; // hardcoded for demo; you can get from user
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above.");
            }
            System.out.println("Valid age.");
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

