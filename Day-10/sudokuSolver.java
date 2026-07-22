import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    // Arrays to store the bitmasks for rows, columns, and 3x3 boxes
    int[] rowMask = new int[9];
    int[] colMask = new int[9];
    int[] boxMask = new int[9];
    List<int[]> emptyCells = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // Reset state in case the platform reuses the same Solution object for multiple test cases
        rowMask = new int[9];
        colMask = new int[9];
        boxMask = new int[9];
        emptyCells.clear();

        // 1. Initialize masks and record empty cells
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.' || board[r][c] == '0') {
                    emptyCells.add(new int[]{r, c});
                } else {
                    // Mark the digit as used by setting its specific bit to 1
                    int val = board[r][c] - '0';
                    int bit = 1 << val; 
                    int box = (r / 3) * 3 + (c / 3);
                    
                    rowMask[r] |= bit;
                    colMask[c] |= bit;
                    boxMask[box] |= bit;
                }
            }
        }

        // 2. Start solving
        solve(board, 0);
    }

    private boolean solve(char[][] board, int index) {
        // Base case: all empty cells are filled
        if (index == emptyCells.size()) {
            return true;
        }

        int[] cell = emptyCells.get(index);
        int r = cell[0];
        int c = cell[1];
        int box = (r / 3) * 3 + (c / 3);

        // Try digits 1 through 9
        for (int val = 1; val <= 9; val++) {
            int bit = 1 << val;

            // O(1) Check: If the bit is 0 in row, col, and box, the number is safe to place
            if ((rowMask[r] & bit) == 0 && (colMask[c] & bit) == 0 && (boxMask[box] & bit) == 0) {
                
                // Place the digit and update the masks
                board[r][c] = (char) (val + '0');
                rowMask[r] |= bit;
                colMask[c] |= bit;
                boxMask[box] |= bit;

                // Move to the next empty cell
                if (solve(board, index + 1)) {
                    return true;
                }

                // Backtrack: Undo the placement and remove the bit from the masks
                board[r][c] = '0'; // Restore as empty
                rowMask[r] &= ~bit;
                colMask[c] &= ~bit;
                boxMask[box] &= ~bit;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Sudoku board row by row (9 characters each, use '.' for empty cells):");

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String row = scanner.nextLine().replaceAll("\\s+", "");
            while (row.length() != 9) {
                System.out.println("Please enter exactly 9 characters for row " + (i + 1) + ":");
                row = scanner.nextLine().replaceAll("\\s+", "");
            }
            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        Solution solution = new Solution();
        solution.solveSudoku(board);

        System.out.println("Solved Sudoku:");
        for (char[] row : board) {
            System.out.println(new String(row));
        }

        scanner.close();
        System.out.println("The compiler is working");
    }
}