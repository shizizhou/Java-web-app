<%@ page import="java.util.List" %>
<%@ page import="java.util.Hashtable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Patients Sorted by Race:</h2>
    <ul>
        <% List<String> patientRace = (List<String>) request.getAttribute("patientRace"); %>
        <% Hashtable<String, List<String>> data = (Hashtable<String, List<String>>) request.getAttribute("dictionary"); %>
        <% for(String race : patientRace) { %> 
            <li><%= race %></li>
            <ul>
                <% List<String> patients = data.get(race); %>
                <% for (String patient : patients) { %>
                    <li><a href="patientData?patientId=<%=patient%>"><%=patient%></a></li>
                <% } %>
            </ul>
        <% } %>
    </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>