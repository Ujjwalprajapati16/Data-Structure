public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Create hash sets to track seen numbers in rows, columns, and sub-grids
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    
                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {

                        return false; 

                    }
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
