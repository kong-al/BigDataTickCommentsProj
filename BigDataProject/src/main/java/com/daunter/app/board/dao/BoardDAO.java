package com.daunter.app.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.daunter.app.board.vo.BoardVO;
import com.daunter.mybatis.config.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory factory = SqlMapConfig.getSqlMapInterface();
	SqlSession sqlsession;
	
	public BoardDAO() {
		sqlsession = factory.openSession(true);
	}

	public List<BoardVO> getBoardList(int startRow, int endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		List<BoardVO> boardList = sqlsession.selectList("Board.getBoardList", pageMap);
		
		return boardList;
	}

	public int getBoardCnt() {
		return sqlsession.selectOne("Board.getBoardCnt");
	}
	
	
}
