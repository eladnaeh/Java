package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static ArrayList<DataType> dataTypes = new ArrayList<>();

    public static void main(String[] args) {
	    String fileNameOne = "fileRead1.txt";
	    String fileNameTwo = "fileRead2.txt";

	    readInfo(fileNameOne, fileNameTwo);
        //System.out.println("finished readInfo");

	    WriteToFileFunction(removeIndexs(deleteDuplicate()));

        //System.out.println(dataTypes);
        System.out.println("final file context: " + "\n");
        printFinalFileContext();

    }

    public static void readInfo(String fileName1, String fileName2){
        try{
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName2));

            ArrayList<String> reader1 = new ArrayList<>();
            ArrayList<String> reader2 = new ArrayList<>();

            String line = null;
            while ((line = bufferedReader1.readLine()) != null){
                reader1.add(line);
            }
            while ((line = bufferedReader2.readLine()) != null){
                reader2.add(line);
            }

            for (String read : reader1){
                if(read.length() > 0){
                    String[] itemsArray = read.split(",");
                    String  name, familyName, ID, Data;
                    name = itemsArray[0];
                    familyName = itemsArray[1];
                    ID = itemsArray[2];
                    Data = itemsArray[3];

                    DataType dataType = new DataType(name, familyName, ID, Data);

                    dataTypes.add(dataType);
                }
            }

            for (String read : reader2){
                if(read.length() > 0){
                    String[] itemsArray = read.split(",");
                    String  name, familyName, ID, Data;
                    name = itemsArray[0];
                    familyName = itemsArray[1];
                    ID = itemsArray[2];
                    Data = itemsArray[3];

                    DataType dataType = new DataType(name, familyName, ID, Data);

                    dataTypes.add(dataType);
                }
            }

            bufferedReader1.close();
            bufferedReader2.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("In one of the files there is an illegal input, please fix it");
        }
    }

    public static ArrayList<Integer> deleteDuplicate(){
        ArrayList<Integer> indexsToRemove = new ArrayList<>();

        for (DataType dataType : dataTypes){

            //System.out.println(dataType);
            if(dataType.numberOfEqual == 0){

                for (DataType secondDataType : dataTypes){
                    //System.out.println("in second for loop");

                    if(dataTypes.indexOf(dataType) != dataTypes.indexOf(secondDataType)){
                        if(dataType.getID().equals(secondDataType.getID())){
//                            dataTypes.remove(dataTypes.indexOf(secondDataType));
//                            System.out.println("same" + dataType + " --- " + secondDataType);
//                            System.out.println("\n");
//                            System.out.println(dataTypes.indexOf(secondDataType));
                            dataType.setData(dataType.getData() + ", " + secondDataType.getData());
                            indexsToRemove.add(dataTypes.indexOf(secondDataType));

                            secondDataType.setNumberOfEqual(1);
                        }
                    }

                    //System.out.println("finished if statements");
                }

            }

        }

        //System.out.println(indexsToRemove);
        return indexsToRemove;
    }

    public static ArrayList<DataType> removeIndexs(ArrayList<Integer> indexs){

        ArrayList<DataType> list = new ArrayList<>();
        list = dataTypes;

        //System.out.println(indexs);

        Iterator<DataType> iterator = list.iterator();

        while (iterator.hasNext()){
            DataType dataType = iterator.next();

            for (int index : indexs){
                if(list.indexOf(dataType) == index){
                    iterator.remove();
                }
            }
        }

        return list;

    }

    public static void WriteToFileFunction(ArrayList<DataType> dataList){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("WriteToFile.txt"));

            for(DataType dataType : dataList){
                bufferedWriter.write(dataType.write());
            }

            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void printFinalFileContext(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("WriteToFile.txt"))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
