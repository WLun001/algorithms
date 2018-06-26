package recursion;

/**
 * For binary search to work, the elements in the array must already be ordered
 */
public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(recursiveBinarySearch(list, 9) + "");
    }

    public static int recursiveBinarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        return recursiveBinarySearch(list, key, low, high);
    }

    private static int recursiveBinarySearch(int[] list, int key, int low, int high) {
        if (low > high) return -low - 1; //the list has been exhausted without match
        int mid = (low + high) / 2;
        if (key < list[mid]) return recursiveBinarySearch(list, key, low, mid - 1);
        else if (key == list[mid]) return mid;
        else return recursiveBinarySearch(list, key, mid + 1, high);
    }
}
