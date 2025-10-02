package org.example;

/*You are given an m x n integer matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Leetcode -  https://leetcode.com/problems/search-a-2d-matrix/description/
Solution - https://neetcode.io/solutions/search-a-2d-matrix */

public class binarySearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int totRows = matrix.length;
        int totColumns = matrix[0].length;
        int i = 0;
        int length = (totRows * totColumns) - 1;

        while(i <= length) {

            int index = i + (length - i) / 2; //find the middle number Index
            int row = index / totColumns;
            int column = index % totColumns;

            if(target > matrix[row][column]) { //if target is greater, search on the right side of the index
                i = index + 1;
            }
            else if (target < matrix[row][column]) { //if target is lesser, search on the left side of the index
                length = index - 1;
            }
            else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        binarySearchMatrix obj = new binarySearchMatrix();
        System.out.println(obj.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }
}