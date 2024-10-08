package uk.ac.ucl.model;

import java.util.ArrayList;

public class Dataframe {
    private ArrayList<Column> columns;
    public Dataframe() {
        this.columns = new ArrayList<Column>();
    }
    public void addColumn(Column column) {
        
        columns.add(column);
    }
    public ArrayList<String> getColumnNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (Column column : columns) {
            names.add(column.getName());
        }
        return names;
    }
    public int getRowCount() {
        return columns.get(0).getSize();
    }
    public String getValue(String columnName, int row){
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                return column.getRowValue(row);
            }
        }
        return null;
    }
    public void putValue(String columnName, int row, String value){
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                column.setRowValue(row, value);
            }
        }
    }
    public void addValue(String columnName, String value){
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                column.addRowValue(value);
            }
        }
    }
    public boolean equals(){
        int temp = columns.get(0).getSize();
        for (Column column : columns) {
            if(column.getSize() != temp){
                return false;
            }
        }
        return true;
    }
    public void show(){
        for(Column column: columns){
            System.out.print(column.getName()+" ");
        }
        System.out.println();
        for(int i=0;i<columns.get(0).getSize();i++){
            for(Column column: columns){
                System.out.print(column.getRowValue(i)+" ");
            }
            System.out.println();
        }
    }
}
