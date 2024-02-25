package Sorting;

public class QuickSort {
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void quickSort(int arr[], int si, int ei){
        if(si>= ei){
            return;
        }
        //last element
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        BasicArrayTools.inputArr(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.print("After sorting : ");
        BasicArrayTools.printArr(arr);
    }
}
