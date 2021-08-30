package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.util.DbUtil;

public class RecommendDAOImpl implements RecommendDAO {

	/**
	 * 해당 나이대에 가장 많이 위시리스트에 담긴 영화를 추천
	 * 
	 * @param age
	 */
	@Override
	public List<Movie> recByAge(int age) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(
					"select 영화_고유번호 from (select 영화_고유번호, count(영화_고유번호) from 영화 where 나이 between ? and ? group by 영화_고유번호 order by count(영화번호) desc) where rownum<4");
			ps.setInt(1, (age / 10));
			ps.setInt(2, (age / 10) + 9);

			if (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public List<Movie> recByRank() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("sql");

			if (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public List<Movie> recByGenre(int userNo, int genreNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("sql");
			ps.setInt(1, userNo);
			ps.setInt(1, genreNo);

			if (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public List<Movie> recByTag(int userNo, int tagNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("sql");
			ps.setInt(1, userNo);
			ps.setInt(2, tagNo);

			if (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

}
