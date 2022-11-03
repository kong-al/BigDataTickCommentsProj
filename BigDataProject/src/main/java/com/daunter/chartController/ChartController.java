package com.daunter.chartController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.daunter.action.ActionForward;
import com.daunter.app.board.BoardListAction;

/**
 * Servlet implementation class ChartController
 */
public class ChartController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		
		String load = req.getParameter("year");
		PrintWriter out = res.getWriter() ;
		
		JSONObject age10 = new JSONObject() ;
		JSONObject age20 = new JSONObject() ;
		JSONObject age30 = new JSONObject() ;
		JSONObject age40 = new JSONObject() ;
		JSONObject age50 = new JSONObject() ;
		
		age10.put("잘가용~", 10 );
		age10.put("방가룽!!!", 14 );
		age10.put("으..", 20 );
		age10.put("정말??", 34 );
		age10.put("no", 100 );
		age10.put("what?", 120 );
		
		age20.put("미소", 14 );
		age20.put("고양이", 44 );
		age20.put("강아지", 24 );
		age20.put("별별별별", 88 );
		age20.put("틱톡", 103 );
		age20.put("주문", 48 );
		
		age30.put("삼십", 30 );
		age30.put("밥먹어", 44 );
		age30.put("수리남", 10 );
		age30.put("곱창", 80 );
		age30.put("예뻐요", 130 );
		age30.put("나랑놀아요", 140 );
		
		age40.put("피곤", 30 );
		age40.put("활명수", 84 );
		age40.put("어머니", 2 );
		age40.put("진짜로", 80 );
		age40.put("충청도", 12 );
		age40.put("해외로가", 54 );
		
		age50.put("이몽룡", 239 );
		age50.put("사이다", 300 );
		age50.put("독립..", 20 );
		age50.put("눈물", 20 );
		age50.put("자연그대로", 34 );
		age50.put("눈이내려", 180 );
		
		
		
		switch(load) {
		case "year10": 
			out.println(age10);
			break;
		case "year20":
			out.println(age20);
			break;
		case "year30":
			out.println(age30);
			break;
		case "year40":
			out.println(age40);
			break;
		case "year50":
			out.println(age50);
			break;
		default :
			break;
		}
		
		
		
	}

}
