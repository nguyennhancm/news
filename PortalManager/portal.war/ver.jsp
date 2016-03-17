<%--
  Created by IntelliJ IDEA.
  User: NGUYEN VAN NHAN
  Date: 6/1/2015
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  Server info: <%= application.getServerInfo() %><br>
  Servlet version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
  JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
  Java version: <%= System.getProperty("java.version") %><br>
  </body>
</html>
