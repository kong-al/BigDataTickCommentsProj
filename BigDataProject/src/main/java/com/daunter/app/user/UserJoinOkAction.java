package com.daunter.app.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daunter.action.Action;
import com.daunter.action.ActionForward;
import com.daunter.app.user.dao.UserDAO;
import com.daunter.app.user.vo.UserVO;

public class UserJoinOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		
		vo.setUser_name(req.getParameter("user_name"));
		vo.setUser_email(req.getParameter("user_email"));
		vo.setUser_pw(req.getParameter("user_pw"));
		vo.setBirth_year(req.getParameter("birth_year"));
		
		dao.join(vo);

		forward.setRedirect(true);
		forward.setPath("/index.jsp");

		
		return forward;
	}
}
