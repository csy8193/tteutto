package edu.kh.tteutto.classRoom.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;
import edu.kh.tteutto.classRoom.model.vo.ClassRegister;
import edu.kh.tteutto.classRoom.model.vo.ClassReview;
import edu.kh.tteutto.classRoom.model.vo.EpisodeSchedule;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.classRoom.model.vo.TeacherIntro;
import edu.kh.tteutto.main.model.vo.ClassList;


@Repository
public class ClassDetailDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 클래스 상세페이지 조회(결제박스만)
	public ClassDetailRight selectClassDetail(int classNo) {
		return sqlSession.selectOne("classDetailMapper.selectClassDetail", classNo);
	}

	// 클래스 상세페이지 - 회차, 스케쥴 일정 조회
	public List<EpisodeSchedule> selectEpisodeSchedule(int classNo) {
		
		
		return sqlSession.selectList("classDetailMapper.selectEpisodeSchedule", classNo);
	}

	// 클래스 신청 여부 조회
	public String selectRegisterDt(Map<String, Integer> map) {
		return sqlSession.selectOne("classDetailMapper.selectRegisterDt", map);
	}

	// 클래스 후기 평점 조회
	public ClassReview selectReviewAvg(int classNo) {
		return sqlSession.selectOne("classDetailMapper.selectReviewAvg", classNo);
	}

	// 결제(신청) DB삽입
	public int insertRegister(ClassRegister classReg) {
		return sqlSession.insert("classDetailMapper.insertRegister", classReg);
	}
	
	// 찜에 추가
	public int insertWish(Map<String, Integer> map) {
		
		return sqlSession.insert("classDetailMapper.insertWish", map);
	}

	// 찜에서 삭제
	public int deletetWish(Map<String, Integer> map) {
		return sqlSession.delete("classDetailMapper.deleteWish", map);
	}
	
	// 차트 성별 조회
	public List<Member> genderChart(int classNo) {
		return sqlSession.selectList("classDetailMapper.genderChart", classNo);
	}

	// 차트 연령대 조회
	public List<Member> ageChart(int classNo) {
		return sqlSession.selectList("classDetailMapper.ageChart", classNo);

	}
	
	// 찜 여부
	public int selectWishFlag(Map<String, Integer> map) {
		return sqlSession.selectOne("classDetailMapper.selectWishFlag", map);
	}

	// 강사 소개 조회
	public TeacherIntro selectTeacher(int classNo) {
		return sqlSession.selectOne("classDetailMapper.selectTeacher", classNo);
	}
	
	

}
