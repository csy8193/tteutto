package edu.kh.tteutto.main.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.main.model.dao.ClassListDAO;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

@Service
public class ClassListServiceImpl implements ClassListService {

	@Autowired
	private ClassListDAO dao;

	// 클래스 개수 조회 + 페이지네이션
	@Override
	public Pagination getPagination(String search, int page) {
		int searchListCount = dao.getSearchListCount(search);
		return new Pagination(searchListCount, page);
	}
	
	// 클래스 카드 목록 조회
	@Override
	public List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map) {
		return dao.selectSearchList(pagination, map);
	}
}
