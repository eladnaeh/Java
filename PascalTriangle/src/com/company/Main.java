package com.company;

import java.util.ArrayList;;
import java.util.List;

public class Main {
    public static List<Integer> previousRow = new ArrayList<>();
    public static List<Integer> row = new ArrayList<>();

    public static void main(String[] args) {

        drawTriangle(30);
    }
    public static void drawTriangle(int maxRows){
        for(int i=0; i<=maxRows; i++){
            Integer[] firstRow = {1};


            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    row.add(firstRow[0]);
                }
                else {
                    row.add(previousRow.get(j-1) + previousRow.get(j));
//                    System.out.println("in else statement");
//                    System.out.println(previousRow);
//                    System.out.println(previousRow.get(j-1));
                }
            }

            previousRow.clear();
            for (Integer integer : row){
                previousRow.add(integer);
            }
            System.out.println(previousRow);
            row.clear();

        }
    }
}
