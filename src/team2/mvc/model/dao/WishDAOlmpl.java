package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.util.DbUtil;
import team2.mvc.view.FailView;

public class WishDAOlmpl implements WishDAO {
	@Override
	public List<Movie> viewWishList(int userNo, int movieNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql="select * from 위시리스트 where 사용자고유번호 = ? and 영화고유번호 = ?";
		
		try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, userNo);
				ps.setInt(2, movieNo);
				rs= ps.executeQuery();
				
				while(rs.next()) {
					Movie movie = new Movie(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
					movieList.add(movie);
				
				}
				
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
	
		return movieList;
	}

	@Override
	public int putWishList(int userNo, int movieNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
