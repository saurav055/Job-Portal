package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String em = req.getParameter("email");
			String ps = req.getParameter("password");
			User u = new User();
			HttpSession session = req.getSession();

			if ("admin@gmail.com".equals(em) && "admin@121".equals(ps)) {
				u.setRole("admin");
				session.setAttribute("userobj", u);
				resp.sendRedirect("admin.jsp");
			} else {
				
				UserDAO dao=new UserDAO(DBConnect.getConn());
					User user=dao.login(em, ps);
					
					if(user!=null)
					{
						session.setAttribute("userobj", user);
						resp.sendRedirect("home.jsp");
					}else
					{
						session.setAttribute("succMsg", "Invalid Email & Password  ");
						resp.sendRedirect("login.jsp");
					}
				
				
				/*
				 * u.setRole("user"); session.setAttribute("userobj", u);
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
