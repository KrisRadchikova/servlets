package by.tms.home.servlet;

import by.tms.home.storage.InMemoryUserStorage;
import by.tms.home.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

  /*  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = inMemoryUserStorage.getByLogin(login);
        if (byLogin != null){
            if (byLogin.getPassword().equals(password)){
                req.getSession().setAttribute("user", byLogin);
                getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);

            }
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = inMemoryUserStorage.getByLogin(login);
        if (byLogin != null) {
            if (byLogin.getPassword().equals(password)) {
                req.getSession().setAttribute("user", byLogin);
                resp.sendRedirect("/");
            }
            else {
                req.setAttribute("messageAuth", "The password was entered incorrectly.");
                getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
            }
        }

    }
}
