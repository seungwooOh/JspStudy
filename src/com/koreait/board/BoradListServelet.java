package com.koreait.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.dao.BoardDao;
import com.koreait.board.model.BoardDTO;

@WebServlet("/list")
public class BoradListServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String strPage = request.getParameter("page");
//		int page = strPage == null ? 1 : Integer.parseInt(strPage);
		
		int page = Utils.getParameterInt(request, "11a" , 1);
		
		int rowCnt = 5;	// 한 화면에 나타낼 레코드 수
		BoardDTO param = new BoardDTO();
		param.setStartIdx(rowCnt * (page - 1));
		param.setRowCountPerPage(rowCnt);
		
		request.setAttribute("pageLength", BoardDao.selPageLength(param));
		request.setAttribute("list", BoardDao.selBoardList(param));
		
		String jsp = "WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
