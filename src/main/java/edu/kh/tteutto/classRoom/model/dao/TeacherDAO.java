package edu.kh.tteutto.classRoom.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;
import edu.kh.tteutto.classRoom.model.vo.OngingClass;
import edu.kh.tteutto.classRoom.model.vo.Receipt;
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.vo.Member;

@Repository
public class TeacherDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 클래스 조회
	public List<ClassDetail> selectClassList(Pagination pagination, int memberNo) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("classMapper.selectClassList", memberNo, rowBounds);
	}

	// 회차별 클래스 조회
	public List<EpisodeClass> selectClassEpisode(int memberNo) {
		return sqlSession.selectList("classMapper.selectClassEpisode", memberNo);
	}

	// 영수증 조회
	public List<Receipt> selectReceipt(String epNo) {
		return sqlSession.selectList("classMapper.selectReceipt", epNo);
	}

	// 클래스 삭제 가능여부 조회
	public int selectDeleteClass(String epNo) {
		return sqlSession.selectOne("classMapper.selectDeleteClass", epNo);
	}

	// 클래스 삭제
	public int deletClass(String epNo) {
		return sqlSession.delete("classMapper.deletClass", epNo);
	}

	// 진행 중인 클래스 학생 목록 조회
	public List<OngingClass> selectOngoingClass(Pagination pagination, int epNo) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("classMapper.selectOngoingClass", epNo, rowBounds);
	}

	// 학생 신고
	public int reportStudent(Map<String, String> map) {
		return sqlSession.insert("classMapper.reportStudent", map);
	}

	// 정산 신청
	public int calculate(String epNo) {
		return sqlSession.insert("classMapper.calculate", epNo);
	}

	// 클래스 신청 - 기존 클래스 목록 조회
	public List<ClassDetail> existingClassList(int memberNo) {
		return sqlSession.selectList("classMapper.existingClassList", memberNo);
	}

	// 클래스 교육 예정
	public List<Member> studentListExpect(Pagination pagination, int epNo) {

		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("classMapper.studentListExpect", epNo, rowBounds);
	}

	// 수강 거절
	public int rejectStudent(Map<String, String> map) {
		return sqlSession.update("classMapper.rejectStudent", map);
	}

	// 수강 거절 - 메시지 삽입
	public int insertMessage(Map<String, String> map) {
		return sqlSession.insert("classMapper.insertMessage", map);
	}

	// 강사 여부 조회
	public String selectTeacher(int memberNo) {
		return sqlSession.selectOne("classMapper.selectTeacher", memberNo);
	}

	// 클래스 목록 개수 조회
	public int selectClassListCount(int memberNo) {
		return sqlSession.selectOne("classMapper.selectClassListCount", memberNo);
	}

	// 학생 수 조회(수강 예정)
	public int studentListCount(int epNo) {
		return sqlSession.selectOne("classMapper.studentListExpectCount", epNo);
	}

	// 학생 수 조회(진행 중)
	public List<OngingClass> selectOngoingClassListCount(int epNo) {
		return sqlSession.selectList("classMapper.selectOngoingClass", epNo);
	}
	

}
