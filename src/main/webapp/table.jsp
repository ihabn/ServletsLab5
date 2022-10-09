<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10.10.2022
  Time: 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
    <%  try {
        String word = request.getParameter("word");
        String row = request.getParameter("row");
        String column = request.getParameter("column");
        String bgcolor = request.getParameter("bgcolor");

        //Заголовок
        out.println("<center><h1>" + word + "</center></h1>");

        //Таблица
        out.println("<table bgcolor=" + bgcolor + ">");

        for (int i = 0; i < Integer.parseInt(row); i++) {
            out.println("<tr>");
            for (int j = 0; j < Integer.parseInt(column); j++) {
                out.println("<td>");
                out.println("Строка:" + (i + 1) + "Ячейка" + (j + 1));
                out.println("</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }finally {
        out.close();
    }
    %>
</body>
</html>
