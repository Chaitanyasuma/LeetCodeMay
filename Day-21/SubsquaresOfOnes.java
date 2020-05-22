class Solution {
    //int count = 0;
    public int countSquares(int[][] matrix) {
        int sum = 0;
        //first find sum of 0th row and 0th column bc those are skipped from second part of logic
        for(int i = 0; i < matrix.length; i++) {
            sum += matrix[i][0];
        }
        for(int j = 1; j < matrix[0].length; j++) { //dont count [0][0] element twice!!
            sum += matrix[0][j];
        }
        for(int i = 1; i < matrix.length; i++) { //traverse rows
            for(int j = 1; j < matrix[0].length; j++) { //traverse columns
                if(matrix[i][j] != 0) {
                    //if it is 1, then check if neighboring are 1s, if yes then a square can be formed
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1; //1 for itself
                    sum += matrix[i][j];
                }
            }    
        }
        return sum;
    }
}