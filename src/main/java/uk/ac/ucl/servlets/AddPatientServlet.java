package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Dataframe;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addPatient.html")
public class AddPatientServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    ArrayList<String> patientData = new ArrayList<>();
    Dataframe df = ModelFactory.getModel().getData();
    Model model = ModelFactory.getModel();
    ArrayList<String> columnNames = df.getColumnNames();
    for(String columnName: columnNames){
        if(request.getParameter(columnName) == null){
            patientData.add("");
        }
        else{
            patientData.add(request.getParameter(columnName));
        }
    }
    model.addRowToCSV(patientData);
    response.sendRedirect("index.html");
  }
}
