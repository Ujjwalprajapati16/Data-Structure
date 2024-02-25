package Searching;

public class BinarySearch {
    public static int binarySearch(int num[], int key){
        int start = 0;
        int end = num.length-1;

        while (start <= end) {
            int mid = (start + end)/2;

            //Comparisons
            if(num[mid] == key){//found
                return mid;
            }
            if(num[mid] < key){ //right
                start = mid + 1;
            } else { //left
                end = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10};
        int key = 0;

        System.out.println("Key found at " + binarySearch(num, key));
    }
}
