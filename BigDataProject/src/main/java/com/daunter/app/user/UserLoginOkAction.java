package com.daunter.app.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daunter.action.Action;
import com.daunter.action.ActionForward;
import com.daunter.app.user.dao.UserDAO;

public class UserLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		
		UserDAO dao = new UserDAO();
		HttpSession session = req.getSession();
		
		String user_name = req.getParameter("user_name");
		String user_pw = req.getParameter("user_pw");
		
		boolean loginCheck = dao.login(user_name, user_pw);
		
		forward.setRedirect(true);
		
		if (loginCheck) {
			session.setAttribute("session_id", user_name);
			forward.setPath(req.getContextPath() + "/index.jsp");
		} else {
			forward.setPath(req.getContextPath() + "/user/UserLogin.us?flag=flase");
		}
		
		forward.setRedirect(false);
		
		return forward;
	}

}
