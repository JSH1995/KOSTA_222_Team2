
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
import team2.mvc.model.dto.Search;
import team2.mvc.model.dto.SearchDetail;
import team2.mvc.util.DbUtil;

public class SearchDAOImpl implements SearchDAO {

	
	
	/**
	 * DB에 들어가 있는 영화 전체 검색 기능	 
	 * 
	 * 	private int movieNo;
		private String movieName;
		private String director;
		private String movieRegDate;
		private int genreNo;
		
		고유번호
		장르번호
		작품명
		감독
		영화등록일자
		
	 */
	
	@Override
	public List<Search> searchAll(String sortType) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Search> searchList = new ArrayList<Search>();
		String sort = sortType;
		
		String sql = "SELECT 작품명, 감독, 주연1, 주연2, 장르이름, 국가, 개봉일자, 상영시간 FROM 영화"
				+ " JOIN 영화_상세 USING(영화_고유번호)"
				+ " JOIN 배우 USING(영화_고유번호)"
				+ " JOIN 장르_목록 USING(장르번호)"
				+ " ORDER BY " + sort;
		
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Search search = new Search(rs.getString(1), 
										   rs.getString(2), 
										   rs.getString(3), 
										   rs.getString(4),  
										   rs.getString(5), 
										   rs.getString(6), 
										   rs.getString(7), 
										   rs.getInt(8)); 
										   //rs.getInt(9));
				searchList.add(search);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return searchList;
	}

		
	/**
	 * 작품명으로 검색
	 */
	
	@Override
	public List<Search> searchByName(String movieName, String sortType) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Search> searchList = new ArrayList<Search>();
		String sort = sortType;
		
		String sql = "SELECT 작품명, 감독, 주연1, 주연2, 장르이름, 국가, 개봉일자, 상영시간 FROM 영화"
				+ " JOIN 영화_상세 USING(영화_고유번호)"
				+ " JOIN 배우 USING(영화_고유번호)"
				+ " JOIN 장르_목록 USING(장르번호)"
				+ " WHERE 작품명 LIKE ?"
				+ " ORDER BY " + sort;
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+movieName+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Search search = new Search(rs.getString(1), 
						   rs.getString(2), 
						   rs.getString(3), 
						   rs.getString(4),  
						   rs.getString(5), 
						   rs.getString(6), 
						   rs.getString(7), 
						   rs.getInt(8));
						   //rs.getInt(9));
				searchList.add(search);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return searchList;
	}
	
	/**
	 * 감독명으로 검색
	 */


	@Override
	public List<Search> searchByDirector(String director, String sortType) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Search> searchList = new ArrayList<Search>();
		String sort = sortType;
		
		String sql = "SELECT 작품명, 감독, 주연1, 주연2, 장르이름, 국가, 개봉일자, 상영시간 FROM 영화"
				+ " JOIN 영화_상세 USING(영화_고유번호)"
				+ " JOIN 배우 USING(영화_고유번호)"
				+ " JOIN 장르_목록 USING(장르번호)"
				+ " WHERE 감독 LIKE ?"
				+ " ORDER BY " + sort;
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+director+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Search search = new Search(rs.getString(1), 
						   rs.getString(2), 
						   rs.getString(3), 
						   rs.getString(4),  
						   rs.getString(5), 
						   rs.getString(6), 
						   rs.getString(7), 
						   rs.getInt(8));
						   //rs.getInt(9));
				searchList.add(search);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return searchList;
	}
	


	/**
	 * 주연, 조연명으로 검색
	 */
	
	@Override
	public List<Search> searchByActor(String actor, String sortType) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Search> searchList = new ArrayList<Search>();
		String sort = sortType;
		
		String sql = "SELECT 작품명, 감독, 주연1, 주연2, 조연1, 조연2, 조연3, 장르이름, 국가, 개봉일자, 상영시간 FROM 영화"
				+ " JOIN 영화_상세 USING(영화_고유번호)"
				+ " JOIN 배우 USING(영화_고유번호)"
				+ " JOIN 장르_목록 USING(장르번호)"
				+ " WHERE 주연1 LIKE ? OR 주연2 LIKE ? OR 조연1 LIKE ? OR 조연2 LIKE ? OR 조연3 LIKE ?"
				+ " ORDER BY " + sort;
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+actor+"%");
			ps.setString(2, "%"+actor+"%");
			ps.setString(3, "%"+actor+"%");
			ps.setString(4, "%"+actor+"%");
			ps.setString(5, "%"+actor+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Search search = new Search(rs.getString(1), 
						   rs.getString(2), 
						   rs.getString(3), 
						   rs.getString(4),  
						   rs.getString(5), 
						   rs.getString(6), 
						   rs.getString(7),
						   rs.getString(8),
						   rs.getString(9),
						   rs.getString(10),
						   rs.getInt(11));
						   //rs.getInt(9));
				searchList.add(search);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return searchList;
	}


	/**
	 * 장르이름으로 검색
	 */
	
	@Override
	public List<Search> searchByGenre(String genre, String sortType) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Search> searchList = new ArrayList<Search>();
		String sort = sortType;
		
		String sql = "SELECT 작품명, 감독, 주연1, 주연2, 장르이름, 국가, 개봉일자, 상영시간 FROM 영화"
				+ " JOIN 영화_상세 USING(영화_고유번호)"
				+ " JOIN 배우 USING(영화_고유번호)"
				+ " JOIN 장르_목록 USING(장르번호)"
				+ " WHERE 장르이름 LIKE ?"
				+ " ORDER BY " + sort;
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+genre+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Search search = new Search(rs.getString(1), 
						   rs.getString(2), 
						   rs.getString(3), 
						   rs.getString(4),  
						   rs.getString(5), 
						   rs.getString(6), 
						   rs.getString(7), 
						   rs.getInt(8));
						   //rs.getInt(9));
				searchList.add(search);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return searchList;
	}

	
	/**
	 * 국가로 검색
	 */

	@Override
	public List<Search> searchByNation(String nation, String sortType) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Search> searchList = new ArrayList<Search>();
		String sort = sortType;
		
		String sql = "SELECT 작품명, 감독, 주연1, 주연2, 장르이름, 국가, 개봉일자, 상영시간 FROM 영화"
				+ " JOIN 영화_상세 USING(영화_고유번호)"
				+ " JOIN 배우 USING(영화_고유번호)"
				+ " JOIN 장르_목록 USING(장르번호)"
				+ " WHERE 국가 LIKE ?"
				+ " ORDER BY " + sort;
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+nation+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Search search = new Search(rs.getString(1), 
						   rs.getString(2), 
						   rs.getString(3), 
						   rs.getString(4),  
						   rs.getString(5), 
						   rs.getString(6), 
						   rs.getString(7), 
						   rs.getInt(8));
						   //rs.getInt(9));
				searchList.add(search);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return searchList;
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
				movie = new Movie(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movie;
	}


	/**
	 * 상세 정보 보여주기
	 * 
	 * 평점, 사용자 태그 추가 필요
	 */
	
	
	@Override
	public Search showMovieDetail(String movieName) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		Search sd = null;
		
		String sql = "SELECT 작품명, 감독, 주연1, 주연2, 조연1, 조연2, 조연3, 장르이름, 국가, 개봉일자, 상영시간, 작품_줄거리 FROM 영화"
				+ " JOIN 영화_상세 USING(영화_고유번호)"
				+ " JOIN 배우 USING(영화_고유번호)"
				+ " JOIN 장르_목록 USING(장르번호)"
				+ " WHERE 작품명 = ?";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, movieName);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				// List<String> a = (List<String>)rs.getObject(13, ArrayList.class);						 
				sd = new SearchDetail(rs.getString(1), 
						   rs.getString(2), 
						   rs.getString(3), 
						   rs.getString(4),  
						   rs.getString(5), 
						   rs.getString(6), 
						   rs.getString(7),
						   rs.getString(8),
						   rs.getString(9),
						   rs.getString(10),
						   rs.getInt(11),
						   rs.getString(12));
						   //, a);
			}
			
		}finally {
			
			DbUtil.dbClose(con, ps, rs);
		}
		return sd;
	}
	
	
	
	
	
	

	@Override
	public List<Search> searchMovie(String keyword) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Search> movieList = new ArrayList<Search>();
		
//		if(keyword)
//		
//		
		String sql = "";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			//	Search movie = new Search(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			//	movieList.add(movie);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
			
		return movieList;
	}
	
}
