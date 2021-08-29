package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.request.ClassPrepareRequest;

import team2.mvc.exception.DuplicateException;
import team2.mvc.model.dto.Movie;
import team2.mvc.util.DbUtil;
import team2.mvc.view.FailView;

public class WishDAOlmpl implements WishDAO {
	@Override
	public List<Movie> viewWishList(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "select * from 위시리스트 where 사용자고유번호";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				movieList.add(movie);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return movieList;
	}

	@Override
	public int putWishList(int userNo, int movieNo) throws SQLException, DuplicateException {
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>(); 
		String sql1 = "select distinct 영화_고유번호 from 위시리스트";
		String sql2 = "insert into 위시리스트 values(?,?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps1 = con.prepareStatement(sql1);
			rs = ps1.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
			ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, userNo);
			ps2.setInt(2, movieNo);
			result = ps2.executeUpdate();
			if(list.contains(movieNo)) {
				throw new DuplicateException("이미 존재하는 영화입니다.");
			}
			if(result == 0) {
				throw new SQLException("등록에 실패했습니다.");
			}
		}finally {
			DbUtil.dbClose(con, ps2, rs);
		}
		
		return result;
	}

}
