package com.daunter.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daunter.action.Action;
import com.daunter.action.ActionForward;
import com.daunter.app.board.dao.BoardDAO;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO dao = new BoardDAO();
	
		String temp = req.getParameter("page");
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 10;
		
		int endRow = page * pageSize;
		int startRow = endRow - 9;
		
		int totalCnt = dao.getBoardCnt();
		
		int startPage = (page -1) / pageSize * pageSize + 1;
		int endPage = startPage + 9;
		int totalPage = (totalCnt - 1) / pageSize + 1;
		
		endPage = endPage > totalPage? totalPage : endPage;
		
		
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("boardList", dao.getBoardList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardList.jsp");
		
		return forward;
	}

}
