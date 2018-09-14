package practice;

public class Numbers {

    public static void main(String[] args) {
        binaryPrint(19);
        System.out.println(parseBinary("10011"));
    }

    public static void printNumberDes(int n) {
        if (n == 0)
            System.out.println(n + "");
        else {
            System.out.println(n + "");
            printNumberDes(n - 1);
        }
    }

    public static void printNumberAs(int startNum, int n) {
        if (startNum == n)
            System.out.println(startNum + "");
        else {
            System.out.println(startNum + "");
            printNumberAs(startNum + 1, n);
        }
    }

    public static int sumOfSquare(int n) {
        int sum = 0;
        if (n != 0) {
            sum += n * n + sumOfSquare(n - 1);
        }
        return sum;
    }

    public static int power(int base, int power) {
        if (power == 0) return 1;
        return base * power(base, power - 1);
    }

    public static void binaryPrint(int x) {
        if (x != 0) {
            binaryPrint(x / 2);
            System.out.print(x % 2 + "");
        }
    }

    public static int parseBinary(String binaryStr) {
        return Integer.parseInt(binaryStr, 2);
    }
}
