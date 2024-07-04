package Arrays;
import java.util.Arrays;

public class Array {
    // Reverse the elements of an array in place
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move towards the center
            start++;
            end--;
        }
    }

    // Find the maximum element in an array
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Find the minimum element in an array
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // Find the sum of all elements in an array
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Find the average of all elements in an array
    public static double findAverage(int[] arr) {
        int sum = findSum(arr);
        return (double) sum / arr.length;
    }

    // Find the second maximum element in an array
    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i]!=max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // Find the second minimum element in an array
    public static int findSecondMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin && arr[i]!=min) {
                secondMin = arr[i];
            }
        }
        return secondMin;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(arr));

        // Reverse the array
        reverseArray(arr);
        System.out.println("Reversed array: " + Arrays.toString(arr));

        // Find the maximum element in the array
        int max = findMax(arr);
        System.out.println("Maximum element: " + max);

        // Find the minimum element in the array
        int min = findMin(arr);
        System.out.println("Minimum element: " + min);

        // Find the sum of all elements in the array
        int sum = findSum(arr);
        System.out.println("Sum of elements: " + sum);

        // Find the average of all elements in the array
        double avg = findAverage(arr);
        System.out.println("Average of elements: " + avg);
    }
}