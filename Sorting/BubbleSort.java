package Sorting;
// import Sorting.BasicArrayTools;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        BasicArrayTools.inputArr(arr);
        bubbleSort(arr);
        System.out.print("After sorting : ");
        BasicArrayTools.printArr(arr);
    }
}
