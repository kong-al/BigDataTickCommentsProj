package com.daunter.app.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daunter.action.Action;
import com.daunter.action.ActionForward;
import com.daunter.app.user.dao.UserDAO;

public class UserLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		
		UserDAO dao = new UserDAO();
		
		String user_name = req.getParameter("user_name");
		String user_email = req.getParameter("user_email");
		String user_pw = req.getParameter("user_pw");
		
		dao.login(user_name, user_email, user_pw);
		
		return forward;
	}

}
