
/**
 * @author 김찬원
 * 
 */

package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Movie;

public interface SearchDAO {
	
	List<Movie> searchAll() throws SQLException;
	
	List<Movie> searchByName(String movieName) throws SQLException;
	
	List<Movie> searchByDirector(String director) throws SQLException;
	
	List<Movie> searchByActor(String actor) throws SQLException;
	
	List<Movie> searchByGenre(String genre) throws SQLException;
	
	List<Movie> searchByNation(String nation) throws SQLException;
	
	
	//////////////////////////////////////////////////
	
	Movie searchByPK(int movieNo) throws SQLException;
	
	List<String> recentSearch() throws SQLException;
	
}
