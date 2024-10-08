<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Modify Page</title>
</head>
<body>
  <h2>Modify Data:</h2>
  <form action="modify.html" method="post">
    <input type="hidden" name="field" value="<%= request.getParameter("field") %>">
    <input type="hidden" name="data" value="<%= request.getParameter("data") %>">
    <input type="text" name="newString" placeholder="Enter new value" required>
    <input type="submit" value="Submit">
  </form>
</body>
</html>