package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import team2.mvc.model.dto.Actor;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.Tag;
import team2.mvc.util.DbUtil;

public class MovieDAOImpl implements MovieDAO {
	
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
		String sql="insert into 영화(영화_고유번호, 장르번호, 작품명, 감독, 영화등록일자) values(?, ?, ?, ?, sysdate)";
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
		String sql="update 영화 set 장르번호=?, 작품명=?, 감독=?, 영화등록일자=sysdate where 영화_고유번호=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, movie.getGenreNo());
			ps.setString(2, movie.getMovieName());
			ps.setString(3, movie.getDirector());
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
		String sql="delete from 영화 where 영화_고유번호=?";
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
	
	
	/**
	 * 배우 등록
	 * */
	public int registerActor(Actor actor) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="insert into 배우(주연1, 주연2, 조연1, 조연2, 조연3) values(?, ?, ?, ?, ?)";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, actor.getMainActor1());
			ps.setString(2, actor.getMainActor2());
			ps.setString(3, actor.getSupActor1());
			ps.setString(4, actor.getSupActor2());
			ps.setString(5, actor.getSupActor3());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 영화_고유번호에 해당하는 배우정보 수정
	 * */
	public int updateActor(Actor actor) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="update 배우 set 주연1=?, 주연2=?, 주연1=?, 조연2=?, 조연3=? where 영화_고유번호=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, actor.getMainActor1());
			ps.setString(2, actor.getMainActor2());
			ps.setString(3, actor.getSupActor1());
			ps.setString(4, actor.getSupActor2());
			ps.setString(5, actor.getSupActor3());
			ps.setInt(6, actor.getMovieNo());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 영화_고유번호에 해당하는 배우 삭제
	 * */
	public int deleteActor(int movieNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete from 배우 where 영화_고유번호=?";
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
	
	/**
	 * 태그 등록
	 * */
	public int registerTag(Tag tag) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="insert into 태그(영화_고유번호, 태그번호) values(?, ?)";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, tag.getMovieNo());
			ps.setInt(2, tag.getTagNo());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 영화_고유번호에 해당하는 태그정보 수정
	 * */
	public int updateTag(Tag tag) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="update 태그 set 태그번호=? where 영화_고유번호=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, tag.getTagNo());
			ps.setInt(2, tag.getMovieNo());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 영화_고유번호에 해당하는 태그 삭제
	 * */
	public int deleteTag(int movieNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete from 태그 where 영화_고유번호=?";
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
	
	
	/**
	 * 영화상세정보 등록
	 * */
	public int registerMovieDetail(MovidDetail movieDetail) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//int movieNo, String content, int runtime, String releaseDate, String nation,
		//List<String> userTag
		String sql="insert into 영화_상세(영화_고유번호, 작품_줄거리, 상영시간, 개봉일자, 국가, 사용자_태그) values(?, ?, ?, ?, ?, ?)";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieDetail.getMovieNo());
			ps.setString(2, movieDetail.getContent());
			ps.setInt(3, movieDetail.getRuntime());
			ps.setString(4, movieDetail.getReleaseDate());
			ps.setString(5, movieDetail.getNation());
			ps.setString(6, movieDetail.getUserTag()); //???
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 영화_고유번호에 해당하는 영화상세정보 수정
	 * */
	public int updateMovieDetail(MovidDetail movieDetail) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="update 영화_상세 set 작품_줄거리=?, 상영시간=?, 개봉일자=?, 국가=?, 사용자_태그=? where 영화_고유번호=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);

			ps.setString(1, movieDetail.getContent());
			ps.setInt(2, movieDetail.getRuntime());
			ps.setString(3, movieDetail.getReleaseDate());
			ps.setString(4, movieDetail.getNation());
			ps.setString(5, movieDetail.getUserTag()); //???
			ps.setInt(6, movieDetail.getMovieNo());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 영화_고유번호에 해당하는 영화상세정보 삭제
	 * */
	public int deleteMovieDetail(int movieNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete from 영화_상세 where 영화_고유번호=?";
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
