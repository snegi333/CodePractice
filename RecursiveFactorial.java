import java.util.Scanner;

public class RecursiveFactorial {

    // Recursive method to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int num = scanner.nextInt();

        try {
            long result = factorial(num);
            System.out.println("Factorial of " + num + " is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}