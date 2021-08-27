
/**
 * @author 김찬원
 * 
 * 8/27(금)
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
	 * 영화 전체 검색 기능	 
	 */
	
	
	@Override
	public List<Movie> searchAll() throws SQLException {
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
	 * 작품명으로 검색
	 */
	
	@Override
	public List<Movie> searchByName() throws SQLException {
		
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
	public List<Movie> searchByDirector() throws SQLException {
		
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
	public List<Movie> searchByActor() throws SQLException {
		
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
	public List<Movie> searchByGenre() throws SQLException {
		
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
	public List<Movie> searchByNation() throws SQLException {

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
	public Movie searchByPK() throws SQLException {

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
	
//	/**
//	 * 최근 검색 키워드 리스트
//	 */
//	
//	@Override
//	public List<String> recentSearch(List) {
//		
//		List<String> keywordList = new ArrayList<String>();
//		
//		while(true)
//			for(String keyword : ) {
//				
//			}
//		
//		return keywordList;
//	}

	
}
