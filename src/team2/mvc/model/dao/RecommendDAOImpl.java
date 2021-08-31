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
		String sql = "select distinct 영화_고유번호, 영화.장르번호, 영화.작품명, 영화.감독, 영화.영화등록일자 from 영화 join 위시리스트 using (영화_고유번호) join 사용자 using(사용자_고유번호) where 나이 between ? and ? order by 영화_고유번호 desc";
		;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int) (age / 10) * 10);
			ps.setInt(2, (int) (age / 10) * 10 + 9);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	/**
	 * 위시리스트에 가장 많이 담긴 영화를 추천
	 */
	@Override
	public List<Movie> recByRank() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList();
		String sql = "select 영화_고유번호, 장르번호, 작품명, 감독, 영화등록일자 from(select count(영화_고유번호), 영화_고유번호, 장르번호, 작품명, 감독, 영화등록일자 "
				+ "from 위시리스트 join 영화 using (영화_고유번호) group by 영화_고유번호, 장르번호, 작품명, 감독, 영화등록일자 order by count(영화_고유번호) desc) where rownum<16";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	/**
	 * 사용자가 선호하는 장르의 영화를 추천
	 */
	@Override
	public List<Movie> recByGenre(int userNo) throws SQLException, NullPointerException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int genreNo = 0;
		List<Movie> list = new ArrayList<>();
		String sql = "select 장르번호 from (select 장르번호, count(장르번호) from 영화 join 위시리스트 using (영화_고유번호) where 사용자_고유번호 = ? group by 장르번호) where rownum < 2";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			if(existWishList(userNo)) {
				rs = ps.executeQuery();
				if (rs.next()) {
					genreNo = rs.getInt(1);
				}
				list = getRecListByTag(con, genreNo);
			} else {
				list = recByFavGenre(userNo);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);

		}
		return list;
	}

	public List<Movie> getRecListByGenre(Connection con, int genreNo) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList();
		String sql2 = "select * from 영화 where 장르번호 = ? and rownum < 16";

		try {
			ps = con.prepareStatement(sql2);
			ps.setInt(1, genreNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(null, ps, rs);
		}
		return list;
	}

	/**
	 * 사용자가 선호하는 태그의 영화를 추천
	 */
	@Override
	public List<Movie> recByTag(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int tagNo = 0;
		List<Movie> list = new ArrayList();
		String sql = "select 태그번호 from (select 태그번호, count(태그번호) from 영화 join 태그 using (영화_고유번호) join 위시리스트 using (영화_고유번호) where 사용자_고유번호 = ? group by 태그번호 order by count(태그번호) desc) where rownum<2";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			
			if(existWishList(userNo)) {
				rs = ps.executeQuery();
				if (rs.next()) {
					tagNo = rs.getInt(1);
				}
				list = getRecListByTag(con, tagNo);
			} else {
				list = recByFavTag(userNo);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	public List<Movie> getRecListByTag(Connection con, int tagNo) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList();
		String sql2 = "select * from 영화 join 태그 using (영화_고유번호) where 태그번호  = ?";

		try {
			ps = con.prepareStatement(sql2);
			ps.setInt(1, tagNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(null, ps, rs);
		}
		return list;
	}
	
	/**
	 * 위시리스트가 존재하는지 판단하는 메서드
	 * @param userNo
	 * @return true if wish-list exist, false if not
	 * @throws SQLException
	 */
	public boolean existWishList(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "select 영화_고유번호, 장르번호, 작품명, 감독, 영화등록일자 from 위시리스트 join 영화 using(영화_고유번호) where 사용자_고유번호 = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}else {
				result = false;
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	public List<Movie> recByFavGenre(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList<>();
		String sql = "select * from 영화 where 장르번호 = (select 장르번호 from 사용자 where 사용자_고유번호 = ?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	public List<Movie> recByFavTag(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList<>();
		String sql = "select * from 영화 join 태그 using(영화_고유번호) where 태그번호 = (select 태그번호 from 사용자 where 사용자_고유번호 = ?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	

}
