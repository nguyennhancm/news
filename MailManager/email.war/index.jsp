<%--
  Created by IntelliJ IDEA.
  User: NGUYEN VAN NHAN
  Date: 9/22/2015
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%
  response.sendRedirect(request.getContextPath() + "/send_email.xhtml?i=0");
  %>
  </body>
</html>
