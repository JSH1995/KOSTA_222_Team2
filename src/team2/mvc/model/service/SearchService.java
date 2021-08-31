
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

import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dao.SearchDAO;
import team2.mvc.model.dao.SearchDAOImpl;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.Search;

public class SearchService {
	
	SearchDAO searchDAO = new SearchDAOImpl();
	
	public List<Search> searchAll(String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchAll(sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("DB에 영화가 등록 되어 있지 않습니다.");
		}
		
		return searchList;		
		
	}
	
	public List<Movie> recentSearch(){
		return null;
		
	}
	
	public List<Search> searchByName(String movieName, String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchByName(movieName, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 작품명의 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;	
		
	}
	
	public List<Search> searchByDirector(String director, String sortType) throws NotFoundException, SQLException{
		List<Search> searchList = searchDAO.searchByDirector(director, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 감독명의 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;	
		
	}
	
	public List<Search> searchByActor(String actor, String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchByActor(actor, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 배우가 포함되어 있는 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;	
		
	}
	
	public List<Search> searchByGenre(String genre, String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchByGenre(genre, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 장르의 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;
		
	}
	
	public List<Search> searchByNation(String nation, String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchByNation(nation, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 국가의 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;
		
	}
	
	public Movie searchByPK(int movieNo) throws NotFoundException, SQLException{
		
		Movie movie =  searchDAO.searchByPK(movieNo);
		
		if(movie == null) {
			throw new NotFoundException("번호에 해당되는 영화를 찾을 수 없습니다.");
		}
		
		return movie;
		
	}

	public Search showMovieDetail(String movieName) throws NotFoundException, SQLException {
		
		Search sd =  searchDAO.showMovieDetail(movieName);
		
		if(movieName == null) {
			throw new NotFoundException("해당 영화에 대한 상세 정보가 없습니다.");
		}
		
		return sd;

	}

}
