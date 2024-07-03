public class Knapsack01 {

    // Method to solve 0-1 Knapsack problem using tabulation
    public static int knapsack(int[] weights, int[] values, int W) {
        int n = values.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Print the dp table
        printTable(dp, n, W, weights);

        // Return the maximum value that can be put in the knapsack
        return dp[n][W];
    }

    // Method to print the dp table
    // public static void printTable(int[][] dp, int n, int W) {
    //     System.out.println("DP Table:");
    //     for (int i = 0; i <= n; i++) {
    //         for (int w = 0; w <= W; w++) {
    //             System.out.print(dp[i][w] + "\t");
    //         }
    //         System.out.println();
    //     }
    // }

    public static void printTable(int[][] dp, int n, int W, int[] weights) {
        System.out.print("Weights: ");
        for (int w = 0; w <= W; w++) {
            System.out.print(w + "\t");
        }
        System.out.println();

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("Item 0  : ");
            } else {
                System.out.print("Item " + i + ": ");
            }

            for (int w = 0; w <= W; w++) {
                System.out.print(dp[i][w] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] values = {2,5, 8, 1};
        int[] weights = {10, 15, 6, 9};
        int W = 30;

        int maxValue = knapsack(weights, values, W);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
