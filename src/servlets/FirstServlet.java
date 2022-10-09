import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head><title>Вариант 1</title>");
            out.println("<meta charset='utf-8' />");
            out.println("</head>");
            out.println("<body>");
            out.print("<p><b>Генерация таблиц по переданным параметрам: заголовок, количество строк и столбцов, цвет фона.</b></p>");

            out.print("<p>Введите заголовок:</p>");
            out.println("<form action='/table.jsp'>");
            out.println("<input type='text' name='word'>");

            out.print("<p>Введите количество строк:</p>");
            out.println("<input type='text' name='row'>");

            out.print("<p>Введите количество столбцов</p>");
            out.println("<input type='text' name='column'>");

            out.print("<p>Введите цвет фона(В формате hex например #6082b6):</p>");
            out.println("<input type='text' name='bgcolor'>");
            out.println("<input type='submit'>");
            out.println("</form>");

            String word = request.getParameter("word");
            String row = request.getParameter("row");
            String colimn = request.getParameter("colimn");
            String bgcolor = request.getParameter("bgcolor");

            //Заголовок
            out.println("<center><h1>" + word + "</center></h1>");

            //Таблица
            out.println("<table bgcolor="+bgcolor+">");

            for (int i = 0; i < Integer.parseInt(row); i++) {
                out.println("<tr>");
                for (int j = 0; j < Integer.parseInt(colimn); j++) {
                    out.println("<td>");
                    out.println("Строка:" + (i+1) + "Ячейка" + (j+1));
                    out.println("</td>");
                }
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
