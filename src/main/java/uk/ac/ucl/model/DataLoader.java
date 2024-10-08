package uk.ac.ucl.model;
import java.io.BufferedReader;
import java.io.FileReader;
public class DataLoader {
    private Dataframe data;
    public DataLoader(){
        this.data= new Dataframe();
    }
    public void load(String filename){
        try{
            BufferedReader temp= new BufferedReader(new FileReader(filename));
            String line= temp.readLine();
            String[] columnNames= line.split(",");
            for(String columnName: columnNames){
                data.addColumn(new Column(columnName));
            }
            while((line=temp.readLine())!=null){
                String[] temp1= line.split(",");
                if(temp1.length==columnNames.length){
                    for(int i=0;i<temp1.length;i++){
                        data.addValue(columnNames[i], temp1[i]);
                    }
                }
                else{
                    for(int i=0;i<temp1.length;i++){
                        data.addValue(columnNames[i], temp1[i]);
                    }
                    data.addValue("ZIP","");
                }
            }
            temp.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public Dataframe getData(){
        return data;
    }
}
