package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String submit = request.getParameter("Submit");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        // do some processing here...

        // get response writer
        PrintWriter writer = response.getWriter();

        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";
        htmlRespone += "Your password is: " + password + "</h2>";
        htmlRespone += "<form>\n" +
                "  First name:<br>\n" +
                "  <input type=\"text\" name=\"firstname\"><br>\n" +
                "  Last name:<br>\n" +
                "  <input type=\"text\" name=\"lastname\">\n" +
                "<input type=\"submit\" value=\"Submit\">"+
                "</form>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);


    }
}
