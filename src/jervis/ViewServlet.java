package jervis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jervis on 4/2/2017.
 */
@WebServlet(name = "ViewServlet",urlPatterns ="/feedback")
public class ViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FeedbackDAO db = new FeedbackDAO();
            List fb = db.getAllFeedback();
            // store bookdetails object in request scope with attribute name "book"
            // bookdetails.jsp will retrieve this stored object later to display the content
            request.setAttribute("feedback", fb);
            // forward the request to bookdetails.jsp, there must be a "/" before the web resource reference
            getServletContext().getRequestDispatcher("/ViewFeedback.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

}
