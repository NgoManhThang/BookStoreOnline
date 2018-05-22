package project01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project01.model.UserDto;
import project01.service.UserService;
import project01.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class LogginController
 */
@WebServlet(urlPatterns = { "/login" })
public class LogginController extends HttpServlet {

	UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/login/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDto user = userService.getUserByUserName(username);
		if (user != null) {
			if (password.equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("current_user", user);
				String url = request.getContextPath() + "/admin/pages/dashboard.jsp";
				response.sendRedirect(url);
			} else {
				request.setAttribute("error_type", 0);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/login/login.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("error_type", 0);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/login/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
