package Sorting;

public class SelectionSort {
    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        BasicArrayTools.inputArr(arr);
        selectionSort(arr);
        System.out.print("After sorting : ");
        BasicArrayTools.printArr(arr);
    }
}
