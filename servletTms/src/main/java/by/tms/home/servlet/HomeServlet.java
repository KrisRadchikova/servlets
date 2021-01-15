package by.tms.home.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {

//    @Override
//    public void init() throws ServletException {
//        System.out.println("init");
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//        System.out.println("Service");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("destroy");
//    }

    //app scope
    //session scope
    //request scope

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("name", name);
        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}
