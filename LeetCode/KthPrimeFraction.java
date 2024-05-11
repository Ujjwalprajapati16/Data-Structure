import java.util.Comparator;
import java.util.PriorityQueue;

class KthPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            @Override
            public int compare(double arr1[], double arr2[]) {
                if(arr1[0] <= arr2[0]){
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        //insert element in pq
        int n =  arr.length;
        //[primeFraction(N/D), numI, denI]
        for(int i=0; i<n-1; i++){
            double primeFraction = 1.0 * arr[i] / arr[n-1];
            pq.offer(new double[]{primeFraction, i, n-1});
        }

        int res[] = new int[2];
        while(k>0){
            double curVal[] = pq.poll();
            int numIndex = (int)curVal[1];
            int denIndex = (int)curVal[2];
            int nextDenIndex = denIndex - 1;

            if(numIndex < nextDenIndex) {
                double primeFraction = 1.0 * arr[numIndex] / arr[nextDenIndex];
                pq.offer(new double[]{primeFraction, numIndex, nextDenIndex});
            }
            k--;

            if(k == 0){
                res[0] = arr[numIndex];
                res[1] = arr[denIndex];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,5};
        int k = 3;

        KthPrimeFraction obj = new KthPrimeFraction();
        int res[] = obj.kthSmallestPrimeFraction(arr, k);
        System.out.println(res[0] + " " + res[1]);
    }
}