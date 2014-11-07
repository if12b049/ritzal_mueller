<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 05.11.2014
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html>
<head>
    <title>JSP Test</title>
    <%!
        String message = "Hello, World.";
    %>
</head>
<body>
<h2><%= message%></h2>
<%= new java.util.Date() %>
</body>
</html>
