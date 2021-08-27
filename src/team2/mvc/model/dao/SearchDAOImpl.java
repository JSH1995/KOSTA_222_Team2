
/**
 * 
 * SearchDAO에서 추상화 시켰던 기능들을 실질적으로 구현해주는 클래스.
 * 
 * @author 김찬원
 * @version 1.0 : 21/08/27
 *  - 반복 되는 메소드가 많으므로 단축 방향 고민 중
 *  - 최근 검색 리스트 미구현
 * 
 */

package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.util.DbUtil;

public class SearchDAOImpl implements SearchDAO {

	
	
	/**
	 * DB에 들어가 있는 영화 전체 검색 기능	 
	 */
	
	@Override
	public List<Movie> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "SELECT * FROM 영화 ORDER BY 작품명";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
				movieList.add(movie);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movieList;
	}

		
	/**
	 * 작품명으로 검색
	 */
	
	@Override
	public List<Movie> searchByName(String movieName) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
				movieList.add(movie);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movieList;
	}
	
	/**
	 * 감독명으로 검색
	 */


	@Override
	public List<Movie> searchByDirector(String director) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
				movieList.add(movie);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movieList;
	}
	


	/**
	 * 주연, 조연명으로 검색
	 */
	
	@Override
	public List<Movie> searchByActor(String actor) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
				movieList.add(movie);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movieList;
	}


	/**
	 * 장르이름으로 검색
	 */
	
	@Override
	public List<Movie> searchByGenre(String genre) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
				movieList.add(movie);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movieList;
	}

	
	/**
	 * 국가로 검색
	 */

	@Override
	public List<Movie> searchByNation(String nation) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
				movieList.add(movie);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movieList;
	}

	
	/**
	 * 영화 고유번호로 검색
	 */

	@Override
	public Movie searchByPK(int movieNo) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Movie movie = null;
		String sql = "";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movie;
	}

	
	/**
	 * 최근 검색 키워드 리스트
	 */

	@Override
	public List<String> recentSearch() throws SQLException {
		return null;
	}
	
	
}
