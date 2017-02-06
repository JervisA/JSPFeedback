package jervis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jervis on 5/2/2017.
 */
@WebServlet(name = "AddServlet", urlPatterns = "/feedbackform")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            try{
                FeedbackDAO dao = new FeedbackDAO();
                HttpSession session = request.getSession();
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String mobile = request.getParameter("mobile");
                String feedback = request.getParameter("feedback");

                session.setAttribute("name" , name);
                session.setAttribute("email", email);
                session.setAttribute("mobile", mobile);
                session.setAttribute("feedback", feedback);
                dao.add(name,email,mobile,feedback);
                getServletContext().getRequestDispatcher("/home.html").forward(request, response);
            }

            catch (Exception e){
                e.printStackTrace();
            }

    }



}
