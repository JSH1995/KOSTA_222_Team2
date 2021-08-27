package team2.mvc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.User;
import team2.mvc.model.service.SearchService;
import team2.mvc.util.DbUtil;
import team2.mvc.view.FailView;


public class WishController {
	private static SearchService searchService = new SearchService();
	
	public static void putWishList(int userNo, int movieNo) {
		
		try {
			Movie movie = searchService.searchByPK(movieNo);
					
			List<Movie> movieList = new ArrayList<Movie>();
			if(!movieList.contains(movie)) {
				movieList.add(movie);
			}else
				System.out.println("이미 추가된 영화입니다.");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	
	public static void viewWishList(int userNo, int movieNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql="select * from 위시리스트 where 사용자고유번호 = ? and 영화고유번호 = ?";
		
		try {
			con =DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, User.getUserNo());     //1
			ps.setInt(2, movieNo); 				//2
			rs = ps.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				movieList.add(movie);
				
				for(Movie m : movieList) {
					System.out.println(movieList);
				}
				
			}catch (SQLException e) {
				FailView.errorMessage(e.getMessage());
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		
		
	}
}
