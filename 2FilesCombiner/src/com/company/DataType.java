package com.company;

public class DataType {
    private String Name;
    private String FamilyName;
    private String ID;
    private String Data;
    public int numberOfEqual = 0;

    public DataType(String Name, String FamilyName, String ID, String Data){
        this.Name = Name;
        this.FamilyName = FamilyName;
        this.ID = ID;
        this.Data = Data;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public int getNumberOfEqual() {
        return numberOfEqual;
    }

    public void setNumberOfEqual(int numberOfEqual) {
        this.numberOfEqual = numberOfEqual;
    }

    @Override
    public String toString() {
        return "DataType{" +
                "Name='" + Name + '\'' +
                ", FamilyName='" + FamilyName + '\'' +
                ", ID='" + ID + '\'' +
                ", Data='" + Data + '\'' +
                ", numberOfEqual=" + numberOfEqual +
                '}'+
                '\n';
    }

    public String write(){
        return Name + "," + FamilyName + "," + ID + "," + Data + "\n";
    }
}
