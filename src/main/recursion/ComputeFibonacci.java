package recursion;

import java.util.Scanner;

public class ComputeFibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index " +
                  index + " is " + fib(index));
    }

    public static long fib(long index) {
        if (index == 0) return 0; // Base case
        else if (index == 1) return 1; // Base case
        else  return fib(index - 1) + fib(index - 2); // Reduction and recursive calls
    }


}
