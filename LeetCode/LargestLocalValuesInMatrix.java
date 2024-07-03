/*
 * You are given an n x n integer matrix grid.

Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

Return the generated matrix.
 */

public class LargestLocalValuesInMatrix {
    public int findMax(int[][] grid, int startRow, int startCol){
        int maxVal = Integer.MIN_VALUE;
        for(int i=startRow; i<startRow+3; i++){
            for(int j=startCol; j<startCol+3; j++){
                maxVal = Math.max(maxVal, grid[i][j]);
            }
        }
        return maxVal;
    }

    public int[][] largestLocal(int[][] grid) {
        int n =  grid.length;
        int res[][] = new int[n-2][n-2];
        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                res[i][j] = findMax(grid, i, j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};

        LargestLocalValuesInMatrix obj = new LargestLocalValuesInMatrix();
        int res[][] = obj.largestLocal(grid);
        for (int[] re : res) {
            for (int j = 0; j<res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }
}
