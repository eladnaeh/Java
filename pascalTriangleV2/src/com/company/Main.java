package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int firstNum = 1;
    public static ArrayList<Integer> row = new ArrayList<>();
    public static  ArrayList<Integer> rowBefore = new ArrayList<>();
    public static int rowNumber = 1;
    public static int runTime = 0;

    public static ArrayList<Integer> fibonacciArray = new ArrayList<>();

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("how many rows do you want? : ");
//        int numOfRows = scanner.nextInt();
//        pascalTriangle(numOfRows);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("how many numbers in fibonacci? :");
//        int num = scanner.nextInt();
//        fibonacci(num);

        //primeNumbers(20000);

    }

    public static void pascalTriangle(int numOfRows){
        int sum = 0;
        while(runTime < numOfRows){
            if(rowNumber == 1){
                row.add(firstNum);
                rowNumber++;
            }
            else{
                for (int i=0; i<rowBefore.size()+1; i++){
                    if (i == rowBefore.size()){
                        row.add(rowBefore.get(rowBefore.size()-1));
                    }
                    else if(i == 0){
                        row.add(rowBefore.get(i));
                    }
                    else{
                        row.add(rowBefore.get(i) + rowBefore.get(i-1));
                    }
                }
            }
            rowBefore.clear();
            for (int num : row){
                sum += num;
                //System.out.print(num + " ");
                rowBefore.add(num);
            }
            System.out.print(sum + " ");
            //System.out.println("");
            row.clear();
            runTime++;
            sum = 0;
        }
    }

    public static void fibonacci(int num){
        int numOfRuns = 0;
        while (numOfRuns < num){
            if (numOfRuns == 0 || numOfRuns == 1){
                fibonacciArray.add(firstNum);
                numOfRuns++;
            }
            else{
                fibonacciArray.add(fibonacciArray.get(numOfRuns-1) + fibonacciArray.get(numOfRuns-2));
                numOfRuns++;
            }

        }
        System.out.println(fibonacciArray);
    }

    public static void primeNumbers(int numOfNumbers){
        ArrayList<Integer> prime = new ArrayList<>();
        int number = 1;
        while(prime.size() < numOfNumbers){
            int times = 0;
            for (int secondNum = 2; secondNum < number/2 + 1; secondNum++){
                if(number != secondNum){
                    if(number%secondNum == 0){
                        times++;
                    }
                }
            }
            if(times == 0){
                prime.add(number);
                System.out.println(number + " : " + prime.size());
            }
            number++;
        }
        System.out.println(prime);
    }
}
