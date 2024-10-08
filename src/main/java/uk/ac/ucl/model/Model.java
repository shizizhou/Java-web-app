package uk.ac.ucl.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
  private Dataframe df;
  private String csvFilePath = "data/patients100.csv";
  // The example code in this class should be replaced by your Model class code.
  // The data should be stored in a suitable data structure.

  public List<String> getPatientNames() {
    return readFile(csvFilePath);
  }

  public Dataframe getData() {
    return df;
  }

  // This method illustrates how to read csv data from a file.
  // The data files are stored in the root directory of the project (the directory
  // your project is in),
  // in the directory named data.
  public List<String> readFile(String fileName) {
    List<String> data = new ArrayList<>();
    DataLoader dataLoader = new DataLoader();
    dataLoader.load(fileName);
    df = dataLoader.getData();
    for (int i = 0; i < df.getRowCount(); i++) {
      data.add(df.getValue("ID", i));
    }
    return data;
  }

  public int searchCSV(String searchString) {
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
      String line;
      int currentRow = 1;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(",");
        if (values[0].equals(searchString)) {
          return currentRow;
        }
        currentRow++;
      }

    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    return -1;
  }

  public void updateCSVValue(String newValue, int targetRow, int targetColumn) {
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        FileWriter writer = new FileWriter(csvFilePath + ".tmp")) {

      String line;
      int currentRow = 1;

      while ((line = reader.readLine()) != null) {
        if (currentRow == targetRow) {
          String[] values = line.split(",");

          if (targetColumn <= values.length) {
            values[targetColumn - 1] = newValue;
          } else {
            System.out.println("Invalid column number: " + targetColumn);
            return;
          }

          line = String.join(",", values);
        }

        writer.write(line + "\n");
        currentRow++;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      java.nio.file.Files.move(
          java.nio.file.Paths.get(csvFilePath + ".tmp"),
          java.nio.file.Paths.get(csvFilePath),
          java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteCSVRow(int rowToDelete) {
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath + ".tmp"))) {

      String line;
      int currentRow = 1;

      while ((line = reader.readLine()) != null) {
        if (currentRow != rowToDelete) {
          writer.write(line);
          writer.newLine();
        }
        currentRow++;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      java.nio.file.Files.move(
          java.nio.file.Paths.get(csvFilePath + ".tmp"),
          java.nio.file.Paths.get(csvFilePath),
          java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addRowToCSV(List<String> rowData) {
    String tempFilePath = csvFilePath + ".tmp";

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath))) {

      String line;
      boolean isFirstLine = true;

      while ((line = reader.readLine()) != null) {
        if (!isFirstLine) {
          writer.newLine();
        }
        writer.write(line);
        isFirstLine = false;
      }

      StringBuilder rowBuilder = new StringBuilder();
      for (String field : rowData) {
        rowBuilder.append(field).append(",");
      }
      rowBuilder.deleteCharAt(rowBuilder.length() - 1);

      if (!isFirstLine) {
        writer.newLine();
      }
      writer.write(rowBuilder.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      java.nio.file.Files.move(
          java.nio.file.Paths.get(tempFilePath),
          java.nio.file.Paths.get(csvFilePath),
          java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<String> sortByLoc() {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < df.getRowCount(); i++) {
      if (!result.contains(df.getValue("BIRTHPLACE", i))) {
        result.add(df.getValue("BIRTHPLACE", i));
      }
    }
    result.sort(String::compareTo);
    return result;
  }

  public List<String> sortByRace() {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < df.getRowCount(); i++) {
      if (!result.contains(df.getValue("RACE", i))) {
        result.add(df.getValue("RACE", i));
      }
    }
    result.sort(String::compareTo);
    return result;
  }

  public List<String> sortByAge() {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < df.getRowCount(); i++) {
      if (!result.contains(df.getValue("BIRTHDATE", i))) {
        result.add(df.getValue("BIRTHDATE", i));
      }
    }
    result.sort(String::compareTo);
    return result;
  }

  // This also returns dummy data. The real version should use the keyword
  // parameter to search
  // the data and return a list of matching items.
  public List<String> searchFor(String keyword) {
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < df.getRowCount(); i++) {
      ArrayList<String> temp = df.getColumnNames();
      for(int j = 0; j < temp.size(); j++){
        if (df.getValue(temp.get(j), i).contains(keyword)) {
          result.add(df.getValue("ID", i));
          break;
        }
      }
    }
    return result;
  }
}
