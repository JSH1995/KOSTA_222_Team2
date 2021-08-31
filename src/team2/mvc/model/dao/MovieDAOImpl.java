package team2.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import team2.mvc.model.dto.Actor;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.MovieSub;
import team2.mvc.model.dto.Tag;
import team2.mvc.util.DbUtil;

public class MovieDAOImpl implements MovieDAO {
	
	public MovieDAOImpl() {
		
	}
	
	/**
	 * 영화 등록
	 * */
	public int registerMovie(int movieNo, int genreNo, String movieName, String director, String date1) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//영화_고유번호_seq.nextval
		String sql="insert into 영화(영화_고유번호, 장르번호, 작품명, 감독, 영화등록일자) values(?, ?, ?, ?, sysdate)";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieNo);
			ps.setInt(2, genreNo);
			ps.setString(3, movieName);
			ps.setString(4, director);
			
			try {
				result = ps.executeUpdate();
			}catch(Exception e) {
				System.out.println("영화고유번호가 중복되어");
			}
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result; 
	}
	
	/**
	 * 영화_고유번호에 해당하는 영화정보 수정
	 * */
	public int updateMovie(int movieNo, int genreNo, String movieName, String director, String date1) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="update 영화 set 장르번호=?, 작품명=?, 감독=?, 영화등록일자=sysdate where 영화_고유번호=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, genreNo);
			ps.setString(2, movieName);
			ps.setString(3, director);
			ps.setInt(4, movieNo);
			
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
		String sql="delete 영화 where 영화_고유번호=?";
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
		String sql="insert into 배우(영화_고유번호, 주연1, 주연2, 조연1, 조연2, 조연3) values(?, ?, ?, ?, ?, ?)";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, actor.getMovieNo());
			ps.setString(2, actor.getMainActor1());
			ps.setString(3, actor.getMainActor2());
			ps.setString(4, actor.getSupActor1());
			ps.setString(5, actor.getSupActor2());
			ps.setString(6, actor.getSupActor3());
			
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
		String sql="update 배우 set 주연1=?, 주연2=?, 조연1=?, 조연2=?, 조연3=? where 영화_고유번호=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(6, actor.getMovieNo());
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
		String sql="delete 태그 where 영화_고유번호=?";
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
		String sql="delete 영화_상세 where 영화_고유번호=?";
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
	 * Menuview UI 에 사용할 부수적인 메소드들
	 *     1. 영화 고유번호에 해당하는 레코드 검색
	 * */

	public List<MovieSub> selectByMovieNo(int movieNo) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<MovieSub> movieList=new ArrayList<MovieSub>();
		String sql="select * from 영화 where 영화_고유번호=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieNo);
			rs=ps.executeQuery();
			while(rs.next()) {
				MovieSub movie = new MovieSub(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				movieList.add(movie);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return movieList;
	}

	public List<Tag> tagListByMovieNo(int movieNo) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Tag> tagList=new ArrayList<Tag>();
		String sql="select * from 영화 where 영화_고유번호=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieNo);
			rs=ps.executeQuery();
			while(rs.next()) {
				Tag tag = new Tag(rs.getInt(1), rs.getInt(2));
				tagList.add(tag);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return tagList;
	}
}
