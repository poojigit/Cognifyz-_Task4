import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Prompt user for password length
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Prompt user for character types to include
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        // Generate the password
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial);

        // Display the generated password
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecial) {
        StringBuilder passwordCharacters = new StringBuilder();
        Random random = new Random();
        if (includeLowercase) {
            passwordCharacters.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (includeUppercase) {
            passwordCharacters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (includeNumbers) {
            passwordCharacters.append("0123456789");
        }
        if (includeSpecial) {
            passwordCharacters.append("!@#$%^&*()-_+=<>?{}[]|~`");
        }

        // Check if at least one character set is selected
        if (passwordCharacters.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be selected.");
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(passwordCharacters.length());
            password.append(passwordCharacters.charAt(randomIndex));
        }

        return password.toString();
    }
}