package by.tms.home.servlet;

import by.tms.home.storage.InMemoryUserStorage;
import by.tms.home.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {

	private final InMemoryUserStorage inMemoryUserStorage
			= new InMemoryUserStorage();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String question = req.getParameter("question");
		String answer = req.getParameter("answer");

		User user = new User(name, login, password, question, answer);
		boolean passwordLength = inMemoryUserStorage.passwordLength(password);
		if(!passwordLength){
			req.setAttribute("messagePassword", "Wrong password length!");
			getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
		}
		boolean save = inMemoryUserStorage.save(user);
		if (save) {
			resp.sendRedirect("/");
		} else {
			req.setAttribute("messageUser", "User is exist!");
			getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
		}
	}
}
