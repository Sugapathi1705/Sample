import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Password Generator!");
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include digits? (yes/no): ");
        boolean includeDigits = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialCharacters = scanner.nextLine().equalsIgnoreCase("yes");

        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecialCharacters);

        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialCharacters) {
        StringBuilder characterPool = new StringBuilder();

        if (includeUppercase) {
            characterPool.append(UPPERCASE);
        }
        if (includeLowercase) {
            characterPool.append(LOWERCASE);
        }
        if (includeDigits) {
            characterPool.append(DIGITS);
        }
        if (includeSpecialCharacters) {
            characterPool.append(SPECIAL_CHARACTERS);
        }

        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}



