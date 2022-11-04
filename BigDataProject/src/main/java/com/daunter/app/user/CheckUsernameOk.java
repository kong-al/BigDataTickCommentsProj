package com.daunter.app.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.daunter.action.Action;
import com.daunter.action.ActionForward;
import com.daunter.app.user.dao.UserDAO;

public class CheckUsernameOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ActionForward forward = new ActionForward();
		String user_name = req.getParameter("user_name");
		UserDAO dao = new UserDAO();
		PrintWriter out = resp.getWriter();
		
		JSONObject object = new JSONObject();
		
		if(dao.checkUsername(user_name)) {
			object.put("status", "not-ok");
		}else {
			object.put("status", "ok");
		}
		out.println(object.toJSONString());
		out.close();
		
		return forward;
	}

}
