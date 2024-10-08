<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Delete Page</title>
</head>
<body>
  <h2>Data successfully deleted!</h2>
  <form action="delete.html" method="post">
    <input type="hidden" name="data" value="<%= request.getParameter("data") %>">
    <input type="submit" value="Return">
  </form>
</body>
</html>