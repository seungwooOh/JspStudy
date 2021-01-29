package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.dao.BoardDao;
import com.koreait.board.model.BoardEntity;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 리스트 뿌릴때나 삭제할때는 포스트가 없어도 된다.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "WEB-INF/jsp/write.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");	// getParameter로 날아오는 타입은 String
		String ctnt = request.getParameter("ctnt");
		
		System.out.println("title : " + title);
		System.out.println("ctnt : " + ctnt);
		
		BoardEntity vo = new BoardEntity();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		BoardDao.insBoard(vo);
		
		response.sendRedirect("/list");
	}

}
