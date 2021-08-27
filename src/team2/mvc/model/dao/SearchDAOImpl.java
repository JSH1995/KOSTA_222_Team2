
/**
 * @author 김찬원
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

	
	@Override
	public List<Movie> recentSearch() {
		return null;
	}

	@Override
	public List<Movie> searchByName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> searchByDirector() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> searchByActor() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> searchByGenre() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> searchByNation() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
