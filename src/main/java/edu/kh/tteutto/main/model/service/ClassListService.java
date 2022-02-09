package edu.kh.tteutto.main.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

public interface ClassListService {
	
	/** 클래스 개수 조회
	 * @param map
	 * @param page
	 * @return pagination
	 */
	Pagination getPagination(Map<String, Object> map, int page);
	
	/** 클래스 카드 조회
	 * @param pagination
	 * @param map
	 * @return searchList
	 */
	List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map);
	
	
	
	
	
	/** 신규 클래스 추천 목록 조회
	 * @param memberNo
	 * @return newList
	 */
	List<ClassList> selectNewList(int memberNo);

	/** 클래스 추천 목록 조회
	 * @param memberNo
	 * @return recommendList
	 */
	List<ClassList> selectRecoList(int memberNo);
}
