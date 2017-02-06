package natasha;

import natasha.FaqDBAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Natasha on 13/12/2016.
 */
@WebServlet(name = "FaqServlet", urlPatterns = "/faqservlet")
public class FaqServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        FaqDBAO db = new FaqDBAO();
        List faqList = db.getFaqByCategory(category);
        request.setAttribute("faqs", faqList);
        getServletContext().getRequestDispatcher("/faq.jsp").forward(request, response);
    }
}
