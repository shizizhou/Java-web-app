<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>A Patient</title>
  <style>
    .modify-link {
        text-decoration: underline;
        color: blue;
        cursor: pointer;
        margin-bottom: 10px;
    }
  </style>
</head>
<body>
  <h2>Patient Details:</h2>
  <% List<String> patientData = (List<String>) request.getAttribute("patientData"); %>
  <a href="/delete.jsp?data=<%= patientData.get(0) %>">delete</a>
  <div class="modify-link" onclick="showModifyOptions()">modify</div>
  <div id="modifyOptions" style="display: none;">
    <p>Select an option:</p>
    <ul>
        <li><a href="/modify.jsp?field=1&data=<%= patientData.get(0) %>">ID</a></li>
        <li><a href="/modify.jsp?field=2&data=<%= patientData.get(0) %>">BIRTHDATE</a></li>
        <li><a href="/modify.jsp?field=3&data=<%= patientData.get(0) %>">DEATHDATE</a></li>
        <li><a href="/modify.jsp?field=4&data=<%= patientData.get(0) %>">SSN</a></li>
        <li><a href="/modify.jsp?field=5&data=<%= patientData.get(0) %>">DRIVERS</a></li>
        <li><a href="/modify.jsp?field=6&data=<%= patientData.get(0) %>">PASSPORT</a></li>
        <li><a href="/modify.jsp?field=7&data=<%= patientData.get(0) %>">PREFIX</a></li>
        <li><a href="/modify.jsp?field=8&data=<%= patientData.get(0) %>">FIRST</a></li>
        <li><a href="/modify.jsp?field=9&data=<%= patientData.get(0) %>">LAST</a></li>
        <li><a href="/modify.jsp?field=10&data=<%= patientData.get(0) %>">SUFFIX</a></li>
        <li><a href="/modify.jsp?field=11&data=<%= patientData.get(0) %>">MAIDEN</a></li>
        <li><a href="/modify.jsp?field=12&data=<%= patientData.get(0) %>">MARITAL</a></li>
        <li><a href="/modify.jsp?field=13&data=<%= patientData.get(0) %>">RACE</a></li>
        <li><a href="/modify.jsp?field=14&data=<%= patientData.get(0) %>">ETHNICITY</a></li>
        <li><a href="/modify.jsp?field=15&data=<%= patientData.get(0) %>">GENDER</a></li>
        <li><a href="/modify.jsp?field=16&data=<%= patientData.get(0) %>">BIRTHPLACE</a></li>
        <li><a href="/modify.jsp?field=17&data=<%= patientData.get(0) %>">ADDRESS</a></li>
        <li><a href="/modify.jsp?field=18&data=<%= patientData.get(0) %>">CITY</a></li>
        <li><a href="/modify.jsp?field=19&data=<%= patientData.get(0) %>">STATE</a></li>
        <li><a href="/modify.jsp?field=20&data=<%= patientData.get(0) %>">ZIP</a></li>
    </ul>
  </div>

  
  <% List<String> title = (List<String>) request.getAttribute("columnNames"); %>
  <% if (patientData != null) { %>
    <% for (int i = 0; i < patientData.size(); i++) { %>
      <p><%= title.get(i) %>:</p>
      <p> <%= patientData.get(i) %></p>
    <% } %>
  <% } else { %>
    <p>No patient data available.</p>
  <% } %>

  <script>
    function showModifyOptions() {
      var modifyOptions = document.getElementById("modifyOptions");
      modifyOptions.style.display = "block";
    }
  </script>
</body>
</html>