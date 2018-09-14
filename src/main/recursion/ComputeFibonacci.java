package recursion;

import java.util.Scanner;

public class ComputeFibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index " +
                index + " is " + fibonacci(index));
    }

    public static long fib(long index) {
        if (index == 0) return 0; // Base case
        else if (index == 1) return 1; // Base case
        else return fib(index - 1) + fib(index - 2); // Reduction and recursive calls
    }

    /**
     * calculate fibonacci with dynamic programming approach
     * @param n number to be calculate
     * @return fibonacci
     */
    public static long fibonacci(long n) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;

        if (n == 0) return f0;
        else if (n == 1) return f1;
        else if (n == 2) return  f2;

        for (int i = 3; i < n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        return f2;
    }
}
