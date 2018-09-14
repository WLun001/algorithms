package recursion;

public class Compute {
    public static void main(String[] args) {
        System.out.println(compute(2));
    }

    /**
     * compute the following series
     * m(i) = 2/3 + 4/5 + ... + 2i/(2i + 1)
     * @param n number
     * @return the compute result
     */
    public static float compute(int n) {
        if (n == 0) return 0;
        else return (float) 2 * n / (2 * n + 1) + compute(n - 1);
    }
}
