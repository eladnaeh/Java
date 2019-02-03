package com.company;

public class Main {

    public static int[][] sudoku = {
            {2, 6, 9, 5, 7, 8, 1, 3, 4},
            {3, 8, 7, 9, 4, 1, 2, 6, 5},
            {1, 5, 4, 2, 3, 6, 7, 9, 8},
            {5, 9, 1, 6, 2, 7, 8, 4, 3},
            {7, 4, 6, 8, 9, 3, 5, 2, 1},
            {8, 2, 3, 1, 5, 4, 9, 7, 6},
            {9, 3, 5, 4, 1, 2, 6, 8, 7},
            {6, 7, 2, 3, 8, 5, 4, 1, 9},
            {4, 1, 8, 7, 6, 9, 3, 5, 2}
    };

    public static int[][] Diagonalsudoku = {
            {1, 6, 9, 5, 7, 8, 1, 3, 9},
            {3, 2, 7, 9, 4, 1, 2, 8, 5},
            {1, 5, 3, 2, 3, 6, 7, 9, 8},
            {5, 9, 1, 4, 2, 6, 8, 4, 3},
            {7, 4, 6, 8, 5, 3, 5, 2, 1},
            {8, 2, 3, 4, 5, 6, 9, 7, 6},
            {9, 3, 3, 4, 1, 2, 7, 8, 7},
            {6, 2, 2, 3, 8, 5, 4, 8, 9},
            {1, 1, 8, 7, 6, 9, 3, 5, 9}
    };



    public static void main(String[] args) {
        if(rowCheck() && columnCheck() && squareCheck()){
            System.out.println("the sudoku is correct!");
        }
        if(!rowCheck()){
            System.out.println("rows are wrong");
        }
        if(!columnCheck()){
            System.out.println("columns are wrong");
        }
        if (!squareCheck()){
            System.out.println("squares are wrong");
        }
        if(!diagonalCheck()){
            System.out.println("diagonal isn't correct");
        }
    }

    public static boolean rowCheck(){
        for (int row=0; row<sudoku.length; row++){
            for (int number=0; number<sudoku.length; number++){
                for (int secondNumber=number+1; secondNumber<sudoku.length; secondNumber++){
                    if(sudoku[row][number] == sudoku[row][secondNumber]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean columnCheck(){
        for (int row=0; row<sudoku.length; row++){
            for (int secondRow=row+1; secondRow<sudoku.length; secondRow++){
                for (int pos=0; pos<sudoku.length; pos++){
                    if(sudoku[row][pos] == sudoku[secondRow][pos]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean squareCheck(){
        for (int row=0; row<sudoku.length; row++){
            for (int pos=0; pos<sudoku.length; pos++){
                if(pos == 0 || pos == 3 || pos == 6){
                    if(row == 0 || row == 3 || row == 6){
                        if(sudoku[row][pos] == sudoku[row][pos+1] ||
                                sudoku[row][pos] == sudoku[row][pos+2] ||
                                sudoku[row][pos] == sudoku[row+1][pos] ||
                                sudoku[row][pos] == sudoku[row+2][pos] ||
                                sudoku[row][pos] == sudoku[row+1][pos+1] ||
                                sudoku[row][pos] == sudoku[row+1][pos+2] ||
                                sudoku[row][pos] == sudoku[row+2][pos+1] ||
                                sudoku[row][pos] == sudoku[row+2][pos+2] ){
                            return false;
                        }
                    }
                    if(row == 1 || row == 4 || row == 7){
                        if(sudoku[row][pos] == sudoku[row][pos+1] ||
                                sudoku[row][pos] == sudoku[row][pos+2] ||
                                sudoku[row][pos] == sudoku[row-1][pos] ||
                                sudoku[row][pos] == sudoku[row-1][pos+1] ||
                                sudoku[row][pos] == sudoku[row-1][pos+2] ||
                                sudoku[row][pos] == sudoku[row+1][pos] ||
                                sudoku[row][pos] == sudoku[row+1][pos+1] ||
                                sudoku[row][pos] == sudoku[row+1][pos+2] ){
                            return false;
                        }
                    }
                    if(row == 2 || row == 5 || row == 8){
                        if(sudoku[row][pos] == sudoku[row][pos+1] ||
                                sudoku[row][pos] == sudoku[row][pos+2] ||
                                sudoku[row][pos] == sudoku[row-1][pos] ||
                                sudoku[row][pos] == sudoku[row-1][pos+1] ||
                                sudoku[row][pos] == sudoku[row-1][pos+2] ||
                                sudoku[row][pos] == sudoku[row-2][pos] ||
                                sudoku[row][pos] == sudoku[row-2][pos+1] ||
                                sudoku[row][pos] == sudoku[row-2][pos+2] ){
                            return false;
                        }
                    }
                }
                if(pos == 1 || pos == 4 || pos == 7){
                    if(row == 0 || row == 3 || row == 6){
                        if(sudoku[row][pos] == sudoku[row][pos+1] ||
                                sudoku[row][pos] == sudoku[row][pos-1] ||
                                sudoku[row][pos] == sudoku[row+1][pos] ||
                                sudoku[row][pos] == sudoku[row+2][pos] ||
                                sudoku[row][pos] == sudoku[row+1][pos+1] ||
                                sudoku[row][pos] == sudoku[row+1][pos-1] ||
                                sudoku[row][pos] == sudoku[row+2][pos+1] ||
                                sudoku[row][pos] == sudoku[row+2][pos-1] ){
                            return false;
                        }
                    }
                    if(row == 1 || row == 4 || row == 7){
                        if(sudoku[row][pos] == sudoku[row][pos+1] ||
                                sudoku[row][pos] == sudoku[row][pos-1] ||
                                sudoku[row][pos] == sudoku[row+1][pos] ||
                                sudoku[row][pos] == sudoku[row+1][pos+1] ||
                                sudoku[row][pos] == sudoku[row+1][pos-1] ||
                                sudoku[row][pos] == sudoku[row-1][pos] ||
                                sudoku[row][pos] == sudoku[row-1][pos+1] ||
                                sudoku[row][pos] == sudoku[row-1][pos-1] ){
                            return false;
                        }
                    }
                    if(row == 2 || row == 5 || row == 8){
                        if(sudoku[row][pos] == sudoku[row][pos+1] ||
                                sudoku[row][pos] == sudoku[row][pos-1] ||
                                sudoku[row][pos] == sudoku[row-1][pos] ||
                                sudoku[row][pos] == sudoku[row-1][pos+1] ||
                                sudoku[row][pos] == sudoku[row-1][pos-1] ||
                                sudoku[row][pos] == sudoku[row-2][pos] ||
                                sudoku[row][pos] == sudoku[row-2][pos+1] ||
                                sudoku[row][pos] == sudoku[row-2][pos-1] ){
                            return false;
                        }
                    }
                }
                if(pos == 2 || pos == 5 || pos == 8){
                    if(row == 0 || row == 3 || row == 6){
                        if(sudoku[row][pos] == sudoku[row][pos-1] ||
                                sudoku[row][pos] == sudoku[row][pos-2] ||
                                sudoku[row][pos] == sudoku[row+1][pos] ||
                                sudoku[row][pos] == sudoku[row+2][pos] ||
                                sudoku[row][pos] == sudoku[row+1][pos-1] ||
                                sudoku[row][pos] == sudoku[row+1][pos-2] ||
                                sudoku[row][pos] == sudoku[row+2][pos-1] ||
                                sudoku[row][pos] == sudoku[row+2][pos-2] ){
                            return false;
                        }
                    }
                    if(row == 1 || row == 4 || row == 7){
                        if(sudoku[row][pos] == sudoku[row][pos-1] ||
                                sudoku[row][pos] == sudoku[row][pos-2] ||
                                sudoku[row][pos] == sudoku[row-1][pos] ||
                                sudoku[row][pos] == sudoku[row-1][pos-1] ||
                                sudoku[row][pos] == sudoku[row-1][pos-2] ||
                                sudoku[row][pos] == sudoku[row+1][pos] ||
                                sudoku[row][pos] == sudoku[row+1][pos-1] ||
                                sudoku[row][pos] == sudoku[row+1][pos-2] ){
                            return false;
                        }
                    }
                    if(row == 2 || row == 5 || row == 8){
                        if(sudoku[row][pos] == sudoku[row][pos-1] ||
                                sudoku[row][pos] == sudoku[row][pos-2] ||
                                sudoku[row][pos] == sudoku[row-1][pos] ||
                                sudoku[row][pos] == sudoku[row-1][pos-1] ||
                                sudoku[row][pos] == sudoku[row-1][pos-2] ||
                                sudoku[row][pos] == sudoku[row-2][pos] ||
                                sudoku[row][pos] == sudoku[row-2][pos-1] ||
                                sudoku[row][pos] == sudoku[row-2][pos-2] ){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean diagonalCheck(){
        int row = 0;
        int secondRow = 8;
        for (int number=0; number<sudoku.length; number++){
            for (int secondNumber=number+1; secondNumber<sudoku.length; secondNumber++){
                if(Diagonalsudoku[row+number][number] == Diagonalsudoku[row+secondNumber][secondNumber]){

                    System.out.println("row : column" + (secondRow-number) + " : " + number);
                    System.out.println("---------------------------------");
                    System.out.println("row : column" + (secondRow-secondNumber) + " : " + secondNumber);

                    System.out.println("diagonal 1 isn't correct");
                    return false;
                }
                if(Diagonalsudoku[secondRow-number][number] == Diagonalsudoku[secondRow-secondNumber][secondNumber]){

                    System.out.println("row : column" + (secondRow-number) + " : " + number);
                    System.out.println("---------------------------------");
                    System.out.println("row : column" + (secondRow-secondNumber) + " : " + secondNumber);

                    System.out.println("diagonal 2 isn't correct");
                    return false;
                }
            }
        }
        return true;
    }

}
