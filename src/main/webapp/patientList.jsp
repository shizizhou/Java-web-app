<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients:</h2>
  <a href="/addPatient.jsp">Add a patient</a>
  <h2>Sort</h2>
  <form action="/sortByAgePatients.html" method="GET">
    <input type="submit" value="Birthdate">
  </form>
  <form action="/sortByLocPatients.html" method="GET">
    <input type="submit" value="Birthplace">
  </form>
  <form action="/sortByRacePatients.html" method="GET">
    <input type="submit" value="Race">
  </form>
  <ul>
    <%
      List<String> patients = (List<String>) request.getAttribute("patientNames");
      for (String patient : patients)
      {
        String href = "patientData?patientId=" + patient;
    %>
    <li><a href="<%=href%>"><%=patient%></a></li>
    <% } %>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>