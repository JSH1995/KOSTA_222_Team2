package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import team2.mvc.model.dto.Movie;
import team2.mvc.util.DbUtil;

public class MovieDAOImpl implements MovieDAO {
	
	private Properties proFile = DbUtil.getProFile();
	
	public MovieDAOImpl() {
		
	}
	
	/**
	 * 영화 등록
	 * */
	public int registerMovie(Movie movie) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//영화_고유번호_seq.nextval
		String sql=proFile.getProperty("insert into 영화(영화_고유번호, 장르번호, 작품명, 감독, 영화등록일자) values(?, ?, ?, ?, sysdate)");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, movie.getMovieNo());
			ps.setInt(2, movie.getGenreNo());
			ps.setString(3, movie.getMovieName());
			ps.setString(4, movie.getDirector());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 영화_고유번호에 해당하는 영화정보 수정
	 * */
	public int updateMovie(Movie movie) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=proFile.getProperty("update 영화 set 작품명=?, 감독=?, 장르번호=?, 영화등록일자=sysdate where 영화_고유번호=?");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, movie.getMovieName());
			ps.setString(2, movie.getDirector());
			ps.setInt(3, movie.getGenreNo());
			ps.setInt(4, movie.getMovieNo());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 영화_고유번호에 해당하는 영화 삭제
	 * */
	public int deleteMovie(int movieNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=proFile.getProperty("delete from 영화 where 영화_고유번호=?");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieNo);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
