package team2.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Movie;

public interface SearchDAO {
	
	List<Movie> searchAll() throws SQLException;
	
	List<Movie> recentSearch() throws SQLException;
	
	List<Movie> searchByName() throws SQLException;
	
	List<Movie> searchByDirector() throws SQLException;
	
	List<Movie> searchByActor() throws SQLException;
	
	List<Movie> searchByGenre() throws SQLException;
	
	List<Movie> searchByNation() throws SQLException;

}
