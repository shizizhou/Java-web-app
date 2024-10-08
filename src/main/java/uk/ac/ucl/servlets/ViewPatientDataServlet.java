package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Dataframe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/patientData")
public class ViewPatientDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String patientId = request.getParameter("patientId");
        Model model = ModelFactory.getModel();
        Dataframe df = model.getData();
        List<String> patientData = new ArrayList<>();
        List<String> columnNames = df.getColumnNames();
        for (int i = 0; i < df.getRowCount(); i++) {
            if (df.getValue("ID", i).equals(patientId)) {
                patientData.add(df.getValue("ID", i));
                patientData.add(df.getValue("BIRTHDATE", i));
                patientData.add(df.getValue("DEATHDATE", i));
                patientData.add(df.getValue("SSN", i));
                patientData.add(df.getValue("DRIVERS", i));
                patientData.add(df.getValue("PASSPORT", i));
                patientData.add(df.getValue("PREFIX", i));
                patientData.add(df.getValue("FIRST", i));
                patientData.add(df.getValue("LAST", i));
                patientData.add(df.getValue("SUFFIX", i));
                patientData.add(df.getValue("MAIDEN", i));
                patientData.add(df.getValue("MARITAL", i));
                patientData.add(df.getValue("RACE", i));
                patientData.add(df.getValue("ETHNICITY", i));
                patientData.add(df.getValue("GENDER", i));
                patientData.add(df.getValue("BIRTHPLACE", i));
                patientData.add(df.getValue("ADDRESS", i));
                patientData.add(df.getValue("CITY", i));
                patientData.add(df.getValue("STATE", i));
                patientData.add(df.getValue("ZIP", i));
                break;
            }
            
        }
        for(int i=0;i<patientData.size();i++){
            if(patientData.get(i).equals("")){
                patientData.set(i,"null");
            }
        }
        request.setAttribute("columnNames", columnNames);
        request.setAttribute("patientData", patientData);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/patientData.jsp");
        dispatcher.forward(request, response);
    }
}