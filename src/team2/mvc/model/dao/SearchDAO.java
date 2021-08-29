
/**
 * @author 김찬원
 * 
 */

package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Movie;

public interface SearchDAO {
	
	List<Movie> searchAll(String sortType) throws SQLException;
	
	List<Movie> searchByName(String movieName, String sortType) throws SQLException;
	
	List<Movie> searchByDirector(String director, String sortType) throws SQLException;
	
	List<Movie> searchByActor(String actor, String sortType) throws SQLException;
	
	List<Movie> searchByGenre(String genre, String sortType) throws SQLException;
	
	List<Movie> searchByNation(String nation, String sortType) throws SQLException;
	
	
	//////////////////////////////////////////////////
	
	Movie searchByPK(int movieNo) throws SQLException;
	
	List<String> recentSearch() throws SQLException;
	
	MovidDetail showMovieDetail(String movieName) throws SQLException;
	
}
