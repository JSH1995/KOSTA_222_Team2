package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.mvc.exception.DuplicateException;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.WishList;
import team2.mvc.util.DbUtil;

public class WishDAOlmpl implements WishDAO {
	@Override
	public List<Movie> viewWishList(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "select 영화_고유번호, 장르번호, 작품명, 감독, 영화등록일자 from 위시리스트 join 영화 using(영화_고유번호) where 사용자_고유번호 = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				Movie movie = new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				movieList.add(movie);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return movieList;
	}

	@Override
	public void putWishList(int userNo, int movieNo) throws SQLException, DuplicateException {
		Connection con = null;
		PreparedStatement ps = null;
		List<WishList> list = new ArrayList<WishList>();
		String sql = "insert into 위시리스트 values(?,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, movieNo);
			list = checkWishDuplicate(con);

			for (WishList w : list) {
				if (w.getUserNo() == userNo && w.getMovieNo() == movieNo) {
					throw new DuplicateException("이미 존재하는 영화입니다.");
				}
			}
			ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
	}

	public List<WishList> checkWishDuplicate(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<WishList> list = new ArrayList<>();
		String sql = "select * from 위시리스트";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new WishList(rs.getInt(1), rs.getInt(2)));
			}
		} finally {
			DbUtil.dbClose(null, ps, rs);
		}
		return list;
	}

}
