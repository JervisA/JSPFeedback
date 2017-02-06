package natasha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Natasha on 9/12/2016.
 */

@WebServlet(name = "MapServlet", urlPatterns="/mapservlet")
public class MapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = request.getParameter("location");
        String destination = request.getParameter("destination");

        if(location.equals(destination)){
            getServletContext().getRequestDispatcher("/reselect.jsp").forward(request, response);
        }
        else {
            MapDBAO db = new MapDBAO();
            request.setAttribute("map", db.getMapDetails(location, destination));
            getServletContext().getRequestDispatcher("/showmap.jsp").forward(request, response);
        }
    }

}

