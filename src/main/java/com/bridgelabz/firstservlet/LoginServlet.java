package com.bridgelabz.firstservlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Neeta"),
                @WebInitParam(name = "password" , value = "Neeta")
        }
)
public class LoginServlet extends HttpServlet {
    private static final String FIRST_NAME_PATTERN="^[A-Z]{1}[a-zA-Z]{2}[a-zA-z0-9]*";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get request parameters for userID and password
        String user = request.getParameter("user");
        boolean validateFirstName = validateFirstName(user);
        boolean checkFirstName = checkFirstName(request, response, validateFirstName);
        String pwd = request.getParameter("pwd");
        //get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        if (checkFirstName == true) {
            if (userID.equals(user) && password.equals(pwd)) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Either user name or password is wrong.</font>");
                rd.include(request, response);
            }
        }
    }
    private boolean checkFirstName(HttpServletRequest request, HttpServletResponse response, boolean validateFirstName) throws IOException, ServletException {
        if (validateFirstName==false){
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out=response.getWriter();
            out.println("<font color=red>user name is Incorrect</font>");
            rd.include(request,response);
            return false;
        }
        return true;
    }

    private boolean validateFirstName(String firstName) {
        Pattern check= Pattern.compile(FIRST_NAME_PATTERN);
        boolean value=check.matcher(firstName).matches();
        return value;
    }
}
