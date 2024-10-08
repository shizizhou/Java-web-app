package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Dataframe;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
@WebServlet("/sortByAgePatients.html")
public class ViewByAgeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        List<String> patientBirthday = model.sortByAge();
        Dataframe df = model.getData();
        Hashtable<String, List<String>> dictionary = new Hashtable<>();
        for (int i = 0; i < patientBirthday.size(); i++) {
            List<String> temp = new ArrayList<String>();
            for (int j = 0; j < df.getRowCount(); j++) {
                if (df.getValue("BIRTHDATE", j).equals(patientBirthday.get(i))) {
                    temp.add(df.getValue("ID", j));
                }
            }
            dictionary.put(patientBirthday.get(i), temp);
        }
        request.setAttribute("patientBirthday", patientBirthday);
        request.setAttribute("dictionary", dictionary);
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/sortByAgePatients.jsp");
        dispatch.forward(request, response);
    }
}