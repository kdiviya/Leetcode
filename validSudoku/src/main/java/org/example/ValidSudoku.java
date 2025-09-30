package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Leetcode -> https://leetcode.com/problems/valid-sudoku/description/
Solution Link -> https://neetcode.io/solutions/valid-sudoku */

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                String boxKey = row/3 + "," + col/3;
                 //Validate the duplicate in rows, columns and boxes , else add the  number in the hash set.
                if(rows.computeIfAbsent(row, k-> new HashSet<>()).contains(board[row][col]) ||
                        cols.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col]) ||
                        boxes.computeIfAbsent(boxKey, k-> new HashSet<>()).contains(board[row][col])
                ) {
                    return false;
                }

                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                boxes.get(boxKey).add(board[row][col]);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        ValidSudoku m =  new ValidSudoku();
        char[][] board = {  {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
                };
        System.out.println(m.isValidSudoku(board));

    }
}