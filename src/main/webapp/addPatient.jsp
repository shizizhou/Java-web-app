<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Patient Page</title>
</head>
<body>
  <h2>Add patient:</h2>
  <form action="addPatient.html" method="post">
    <li><input type="text" name="ID" placeholder="Enter ID" required>
    <li><input type="text" name="BIRTHDATE" placeholder="Enter BIRTHDATE" >
    <li><input type="text" name="DEATHDATE" placeholder="Enter DEATHDATE" >
    <li><input type="text" name="SSN" placeholder="Enter SSN" >
    <li><input type="text" name="DRIVERS" placeholder="Enter DRIVERS" >
    <li><input type="text" name="PASSPORT" placeholder="Enter PASSPORT" >
    <li><input type="text" name="PREFIX" placeholder="Enter PREFIX" >
    <li><input type="text" name="FIRST" placeholder="Enter FIRST" >
    <li><input type="text" name="LAST" placeholder="Enter LAST" >
    <li><input type="text" name="SUFFIX" placeholder="Enter SUFFIX" >
    <li><input type="text" name="MAIDEN" placeholder="Enter MAIDEN" >
    <li><input type="text" name="MARITAL" placeholder="Enter MARITAL" >
    <li><input type="text" name="RACE" placeholder="Enter RACE" >
    <li><input type="text" name="ETHNICITY" placeholder="Enter ETHNICITY" >
    <li><input type="text" name="GENDER" placeholder="Enter GENDER" >
    <li><input type="text" name="BIRTHPLACE" placeholder="Enter BIRTHPLACE" >
    <li><input type="text" name="ADDRESS" placeholder="Enter ADDRESS" >
    <li><input type="text" name="CITY" placeholder="Enter CITY" >
    <li><input type="text" name="STATE" placeholder="Enter STATE" >
    <li><input type="text" name="ZIP" placeholder="Enter ZIP" required>
    <li><input type="submit" value="Submit">
  </form>
</body>
</html>