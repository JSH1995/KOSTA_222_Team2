
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

import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Movie;
import team2.mvc.util.DbUtil;

public class SearchDAOImpl implements SearchDAO {

	
	
	/**
	 * DB에 들어가 있는 영화 전체 검색 기능	 
	 */
	
	@Override
	public List<Movie> searchAll(String sortType) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sort = sortType;
		
		String sql = "SELECT 작품명 FROM 영화 JOIN 영화_상세 ORDER BY " + sort;
		
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
	public List<Movie> searchByName(String movieName, String sortType) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sort = sortType;
		
		String sql = "SELECT * FROM 영화 WHERE 작품명 = ? ORDER BY " + sort;
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, movieName);
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
	public List<Movie> searchByDirector(String director, String sortType) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sort = sortType;
		
		String sql = "SELECT * FROM 영화 WHERE 감독 = ? ORDER BY ";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, director);
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
	public List<Movie> searchByActor(String actor, String sortType) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sort = sortType;
		
		String sql = "SELECT * FROM 영화 JOIN 배우 USING(영화_고유번호) WHERE 주연1 = ? OR 주연2 = ? OR 조연1 = ? OR 조연2 = ? OR 조연3 = ?";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, actor);
			ps.setString(2, actor);
			ps.setString(3, actor);
			ps.setString(4, actor);
			ps.setString(5, actor);
			
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
	public List<Movie> searchByGenre(String genre, String sortType) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sort = sortType;
		
		String sql = "SELECT * FROM ";
		
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
	public List<Movie> searchByNation(String nation, String sortType) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String sort = sortType;
		
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
		String sql = "SELECT * FROM 영화 WHERE 영화_고유번호 = ?";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movieNo);
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

	/**
	 * 상세 정보 보여주기
	 */
	
	
	@Override
	public MovidDetail showMovieDetail(String movieName) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		MovidDetail md = null;
		
		String sql = "";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, movieName);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 List<String> a = (List<String>)rs.getObject(6, ArrayList.class);
				 md = new MovidDetail(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), a);
			}
			
		}finally {
			
			DbUtil.dbClose(con, ps, rs);
		}
		return md;
	}
	
	
}
