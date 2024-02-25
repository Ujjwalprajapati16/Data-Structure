package Sorting;

import java.util.Scanner;

public class BasicArrayTools {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void inputArr(int arr[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input an array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    public static  void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
