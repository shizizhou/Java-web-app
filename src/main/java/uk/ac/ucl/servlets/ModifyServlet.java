package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/modify.html")
public class ModifyServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String field1 = request.getParameter("field");
    int field=Integer.parseInt(field1);
    String data = request.getParameter("data");
    String newString = request.getParameter("newString");
    Model model = ModelFactory.getModel();
    int col=model.searchCSV(data);
    model.updateCSVValue(newString,col,field);
    response.sendRedirect("index.html");
  }
}
