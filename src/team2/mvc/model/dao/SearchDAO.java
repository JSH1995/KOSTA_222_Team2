
/**
 * @author 김찬원
 * 
 */

package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.Search;
import team2.mvc.model.dto.SearchDetail;

public interface SearchDAO {
	
	List<Search> searchAll(String sortType) throws SQLException;
	
	List<Search> searchByName(String movieName, String sortType) throws SQLException;
	
	List<Search> searchByDirector(String director, String sortType) throws SQLException;
	
	List<Search> searchByActor(String actor, String sortType) throws SQLException;
	
	List<Search> searchByGenre(String genre, String sortType) throws SQLException;
	
	List<Search> searchByNation(String nation, String sortType) throws SQLException;
	
	
	//////////////////////////////////////////////////
	
	Movie searchByPK(int movieNo) throws SQLException;
	
	Search showMovieDetail(String movieName) throws SQLException;

	List<Search> searchMovie(String keyword) throws SQLException;
}
