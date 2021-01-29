package com.koreait.board.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board.model.BoardDTO;
import com.koreait.board.model.BoardEntity;

public class BoardDao {
	
	public static void insBoard(BoardEntity vo) {
		
		String sql = "INSERT INTO t_board (title, ctnt) VALUES (?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, vo.getTitle());
			ps.setNString(2, vo.getCtnt());
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			DbUtils.close(con, ps);
			
		}
		
	}
	
	public static List<BoardEntity> selBoardList() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT i_board, title, r_dt FROM t_board ORDER BY i_board DESC";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<BoardEntity> list = new ArrayList<>();
			
			while(rs.next()) {
				
				BoardEntity vo = new BoardEntity();
				
				vo.setI_board(rs.getInt("i_board"));
				vo.setTitle(rs.getString("title"));
				vo.setR_dt(rs.getString("r_dt"));
				
				list.add(vo);
			}
			return list;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return null;
	}
	
	public static List<BoardEntity> selBoardList(BoardDTO param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT i_board, title, r_dt FROM t_board ORDER BY i_board DESC limit ?, ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRowCountPerPage());
			rs = ps.executeQuery();
			
			List<BoardEntity> list = new ArrayList<>();
			
			while(rs.next()) {
				
				BoardEntity vo = new BoardEntity();
				
				vo.setI_board(rs.getInt("i_board"));
				vo.setTitle(rs.getString("title"));
				vo.setR_dt(rs.getString("r_dt"));
				
				list.add(vo);
			}
			return list;
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return null;
	}
	
	public static BoardEntity selBoard(BoardEntity param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT title, ctnt, r_dt FROM t_board WHERE i_board = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardEntity vo = new BoardEntity();
				vo.setI_board(param.getI_board());
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setR_dt(rs.getString("r_dt"));
				return vo;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return null;
	}
	
	public static int selPageLength(BoardDTO param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select ceil(count(i_board) / ?) from t_board;";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getRowCountPerPage());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return 0;
	}
	
	public static int updBoard(BoardEntity param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE t_board SET title = ?, ctnt = ? where i_board= ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getI_board());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int delBoard(BoardEntity param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board WHERE i_board = ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		
		return 0;
	}
	
}
