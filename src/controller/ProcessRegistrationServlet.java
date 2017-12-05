package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.BeanFactory;
import utility.sql.SQLOperations;
import model.MemberBean;

import java.sql.*;

@WebServlet("/processregistration.html")
public class ProcessRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	
	public void init() throws ServletException {
		connection = SQLOperations.getConnection();
		
		if (connection != null) {
			getServletContext().setAttribute("dbConnection", connection);
			System.out.println("connection is READY.");
		} else {
			System.err.println("connection is NULL.");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		String email = request.getParameter("email");
		
		MemberBean member = 
				BeanFactory.getFactoryBean(username, password, firstName, lastName, gender, birthdate, email);
		
		if (connection != null) {
			if (SQLOperations.addMember(member, connection)){
				System.out.println("successful insert");
				request.setAttribute("member", member);
				getServletContext().getRequestDispatcher("/actionstatus.jsp?success=register").forward(request, response);
			} else {
				System.out.println("failed insert");
				getServletContext().getRequestDispatcher("/actionstatus.jsp?success=unameExists").forward(request, response);
			}
		} else {
			System.out.println("invalid connection");
		}
	}

}
