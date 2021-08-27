
/**
 * @author 김찬원
 * 
 * 8/27(금)
 *  - 반복 되는 메소드가 많으므로 이후 단축 시킬 예정
 *  - 최근 검색 리스트 미구현
 * 
 */


package team2.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import team.mvc.exception.NotFoundException;
import team2.mvc.model.dao.SearchDAO;
import team2.mvc.model.dao.SearchDAOImpl;
import team2.mvc.model.dto.Movie;

public class SearchService {
	
	SearchDAO searchDAO = new SearchDAOImpl();
	
	public List<Movie> searchAll() throws NotFoundException, SQLException{
		
		List<Movie> movieList = searchDAO.searchAll();
		
		if(movieList.size() == 0 || movieList.isEmpty()) {
			throw new NotFoundException("DB에 영화가 등록 되어 있지 않습니다.");
		}
		
		return movieList;		
		
	}
	
	public List<Movie> recentSearch(){
		return null;
		
	}
	
	public List<Movie> searchByName(String movieName) throws NotFoundException, SQLException{
		
		List<Movie> movieList = searchDAO.searchByName(movieName);
		
		if(movieList.size() == 0 || movieList.isEmpty()) {
			throw new NotFoundException("검색하신 작품명의 영화는 등록 되어 있지 않습니다.");
		}
		
		return movieList;	
		
	}
	
	public List<Movie> searchByDirector(String director) throws NotFoundException, SQLException{
		List<Movie> movieList = searchDAO.searchByDirector(director);
		
		if(movieList.size() == 0 || movieList.isEmpty()) {
			throw new NotFoundException("검색하신 감독명의 영화는 등록 되어 있지 않습니다.");
		}
		
		return movieList;	
		
	}
	
	public List<Movie> searchByActor(String actor) throws NotFoundException, SQLException{
		
		List<Movie> movieList = searchDAO.searchByActor(actor);
		
		if(movieList.size() == 0 || movieList.isEmpty()) {
			throw new NotFoundException("검색하신 배우가 포함되어 있는 영화는 등록 되어 있지 않습니다.");
		}
		
		return movieList;	
		
	}
	
	public List<Movie> searchByGenre(String genre) throws NotFoundException, SQLException{
		
		List<Movie> movieList = searchDAO.searchByGenre(genre);
		
		if(movieList.size() == 0 || movieList.isEmpty()) {
			throw new NotFoundException("검색하신 감독명의 영화는 등록 되어 있지 않습니다.");
		}
		
		return movieList;
		
	}
	
	public List<Movie> searchByNation(String nation) throws NotFoundException, SQLException{
		
		List<Movie> movieList = searchDAO.searchByNation(nation);
		
		if(movieList.size() == 0 || movieList.isEmpty()) {
			throw new NotFoundException("검색하신 감독명의 영화는 등록 되어 있지 않습니다.");
		}
		
		return movieList;
		
	}
	
	public Movie searchByPK(int movieNo) throws NotFoundException, SQLException{
		
		Movie movie =  searchDAO.searchByPK(movieNo);
		
		if(movie == null) {
			throw new NotFoundException("번호에 해당되는 영화를 찾을 수 없습니다.");
		}
		
		return movie;
		
	}

}
