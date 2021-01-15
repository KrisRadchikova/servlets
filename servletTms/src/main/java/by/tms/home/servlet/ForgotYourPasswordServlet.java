package by.tms.home.servlet;

import by.tms.home.storage.InMemoryUserStorage;
import by.tms.home.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/forgot")
public class ForgotYourPasswordServlet extends HttpServlet {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = inMemoryUserStorage.getByLogin(login);
        req.setAttribute("question", user.getQuestion());
        getServletContext().getRequestDispatcher("/pages/forgot.jsp").forward(req, resp);
    }

    //Please answer your security question.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String answer = req.getParameter("answer");
        String newPassword = req.getParameter("password");
        User byLogin = inMemoryUserStorage.getByLogin(login);
        if (byLogin != null) {
            if (byLogin.getAnswer().equals(answer)) {
                byLogin.setPassword(newPassword);
                resp.sendRedirect("/auth");
            } else {
                req.setAttribute("messageAnswer", "Answer is not correct.");
                getServletContext().getRequestDispatcher("/pages/forgot.jsp").forward(req, resp);
            }
        }
    }
}