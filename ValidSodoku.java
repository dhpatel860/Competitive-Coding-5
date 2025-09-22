/*
* Keep three boolean arrays of size n*n to keep track of whether the number is seen before or not
* if we have already seen that number in either row, column or box, return false
* else change the false flag to true on that index
// TC: O(1) -> as we know we are iterating through 9*9 i.e 81 cells. For general n it will be O(n^2)
// SC: O(1) -> 3 arrays of 9×9 booleans -> constant extra space (81 * 3 booleans) -> O(1).
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        boolean[][] row = new boolean[n][n];
        boolean[][] col = new boolean[n][n];
        boolean[][] box = new boolean[n][n];

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                char ch = board[r][c];

                if(ch == '.')
                    continue;
                
                // convert it to 0 to 8
                int d = ch - '1';
                int boxIndex = (r/3) * 3 + (c/3);

                if(row[r][d])
                    return false;
                 row[r][d] = true;
                if(col[c][d])
                    return false;
                col[c][d] = true;
                if(box[boxIndex][d])
                    return false;
                 box[boxIndex][d] = true;
            }
        }
        return true;
    }
}
