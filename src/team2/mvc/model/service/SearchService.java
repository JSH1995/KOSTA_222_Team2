
/**
 * @author 김찬원
 * 
 * 검색 및 출력 기능에 대한 Service 클래스
 * 
 */

package team2.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.exception.NotFoundException;
import team2.mvc.model.dao.SearchDAO;
import team2.mvc.model.dao.SearchDAOImpl;
import team2.mvc.model.dto.Evaluation;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.Search;

public class SearchService {
	
	SearchDAO searchDAO = new SearchDAOImpl();
	
	
	/**
	 * @author 김찬원
	 * 전체 DB 검색 및 결과를 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param sortType
	 * @return List<Search>
	 * @throws SQLException, NotFoundException
	 */

	
	
	public List<Search> searchAll(String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchAll(sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("DB에 영화가 등록 되어 있지 않습니다.");
		}
		
		return searchList;		
		
	}
	
	
	/**
	 * @author 김찬원
	 * 작품명을 토대로 검색 및 결과를 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param movieName
	 * @param sortType
	 * @return List<Search>
	 * @throws SQLException, NotFoundException
	 */
	
	public List<Search> searchByName(String movieName, String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchByName(movieName, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 작품명의 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;	
		
	}
	
	/**
	 * @author 김찬원
	 * 감독명을 토대로 검색 및 결과를 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param director
	 * @param sortType
	 * @return List<Search>
	 * @throws SQLException, NotFoundException
	 */
	
	public List<Search> searchByDirector(String director, String sortType) throws NotFoundException, SQLException{
		List<Search> searchList = searchDAO.searchByDirector(director, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 감독명의 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;	
		
	}
	
	/**
	 * @author 김찬원
	 * 배우명을 토대로 검색 및 결과를 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param actor
	 * @param sortType
	 * @return List<Search>
	 * @throws SQLException, NotFoundException
	 */
	
	public List<Search> searchByActor(String actor, String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchByActor(actor, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 배우가 포함되어 있는 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;	
		
	}
	
	/**
	 * @author 김찬원
	 * 장르명을 토대로 검색 및 결과를 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param genre
	 * @param sortType
	 * @return List<Search>
	 * @throws SQLException, NotFoundException
	 */
	
	public List<Search> searchByGenre(String genre, String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchByGenre(genre, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 장르의 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;
		
	}
	
	/**
	 * @author 김찬원
	 * 국가명을 토대로 검색 및 결과를 출력
	 * sortType을 입력을 통해 정렬 형태를 바꿔 결과 재출력 가능
	 * @param nation
	 * @param sortType
	 * @return List<Search>
	 * @throws SQLException, NotFoundException
	 */
	
	public List<Search> searchByNation(String nation, String sortType) throws NotFoundException, SQLException{
		
		List<Search> searchList = searchDAO.searchByNation(nation, sortType);
		
		if(searchList.size() == 0 || searchList.isEmpty()) {
			throw new NotFoundException("검색하신 국가의 영화는 등록 되어 있지 않습니다.");
		}
		
		return searchList;
		
	}
	
	/**
	 * @author 김찬원
	 * 영화 고유번호를 토대로 검색 및 데이터 담기
	 * @param movieNo
	 * @return Movie
	 * @throws SQLException, NotFoundException
	 */
	
	public Movie searchByPK(int movieNo) throws NotFoundException, SQLException{
		
		Movie movie =  searchDAO.searchByPK(movieNo);
		
		if(movie == null) {
			throw new NotFoundException("번호에 해당되는 영화를 찾을 수 없습니다.");
		}
		
		return movie;
		
	}
	
	/**
	 * @author 김찬원
	 * 작품명을 토대로 상세 영화 정보를 검색 및 결과를 출력
	 * @param movieName
	 * @return Search
	 * @throws SQLException, NotFoundException
	 */

	public Search showMovieDetail(String movieName) throws NotFoundException, SQLException {
		
		Search sd =  searchDAO.showMovieDetail(movieName);
		
		if(movieName == null) {
			throw new NotFoundException("해당 영화에 대한 상세 정보가 없습니다.");
		}
		
		return sd;
		

	}
	
	/**
	 * @author 김찬원
	 * 특정 영화에 대한 개인 평점/평가 날짜/코멘트를 출력하는 메소드
	 * @param movieName
	 * @return List<Evaluation>
	 * @throws SQLException, NotFoundException
	 */
	
	public List<Evaluation> showComment(String movieName) throws NotFoundException, SQLException{
	
		List<Evaluation> le = searchDAO.showComment(movieName);
		
		if(movieName == null) {
			throw new NotFoundException("아직 후기가 없네요~ 이미 상영하신 영화라면 후기 작성 부탁드려요!!");
		}
		return le;

	}
}
