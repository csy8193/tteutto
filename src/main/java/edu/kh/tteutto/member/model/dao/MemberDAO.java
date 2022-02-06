package edu.kh.tteutto.member.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.member.model.vo.Sns;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 로그인
	 * @param memberEmail
	 * @return loginMember
	 */
	public Member login(String memberEmail) {
		return sqlSession.selectOne("memberMapper.login", memberEmail);
	}
	
	/** 이메일 중복 검사
	 * @param inputEmail
	 * @return result
	 */
	public int emailDupCheck(String inputEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck", inputEmail);
	}
	
	/** 강사 정보 조회
	 * @param memberNo
	 * @return teacher
	 */
	public Teacher selectTeacherProfile(int memberNo) {
		return sqlSession.selectOne("memberMapper.selectTeacherProfile", memberNo);
	}

	/** 강사 이력 조회
	 * @param memberNo
	 * @return career
	 */
	public List<Career> selectTeacherCareer(int memberNo) {
		return sqlSession.selectList("memberMapper.selectTeacherCareer", memberNo);
	}

	/** 강사 sns 조회
	 * @param memberNo
	 * @return snsList
	 */
	public List<Sns> selectTeacherSns(int memberNo) {
		return sqlSession.selectList("memberMapper.selectTeacherSns", memberNo);
	}
	
	/** 회원가입
	 * @param member
	 * @return result
	 */
	public int signUp(Member member) {
		return sqlSession.insert("memberMapper.signUp", member);
	}

	/** 회원 인증테이블에 이메일 중복 확인
	 * @param inputEmail
	 * @return result
	 */
	public int emailDupCheck2(String inputEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck2", inputEmail);
	}
	
	/** 회원가입 이메일 인증번호 저장
	 * @param map
	 * @return result
	 */
	public int sendMailTest(Map<String, String> map) {
		return sqlSession.insert("memberMapper.sendMailTest", map);
	}

	/** 회원가입 이메일 인증번호 수정
	 * @param map
	 * @return
	 */
	public int updateMailTest(Map<String, String> map) {
		return sqlSession.update("memberMapper.updateMailTest", map);
	}
	
	/** 이메일 인증 번호 확인
	 * @param map
	 * @return result
	 */
	public int checkCert(Map<String, String> map) {
		return sqlSession.selectOne("memberMapper.checkCert", map);
	}

	public int changeConfirm(Certified certified) {
		return sqlSession.selectOne("memberMapper.changeConfirm", certified);
	}

	public int changePw(Member member) {
		return sqlSession.update("memberMapper.changePw", member);
	}

	public int updateCert(Certified certified) {
		return sqlSession.update("memberMapper.updateCert", certified);
	}


	/** 강사 정보 수정 - 전화번호
	 * @param map1
	 * @return result1
	 */
	public int teacherPhoneUpdate(Map<String, Object> map1) {
		return sqlSession.update("memberMapper.teacherPhoneUpdate", map1);
	}

	/** 강사 정보 수정 - 강사 소개
	 * @param teacher
	 * @return result2
	 */
	public int teacherIntroduceUpdate(Teacher teacher) {
		return sqlSession.update("memberMapper.teacherIntroduceUpdate", teacher);
	}

	/** 강사 정보 수정 - sns 삭제
	 * @param memberNo
	 * @return result3
	 */
	public int teacherSnsDelete(int memberNo) {
		return sqlSession.delete("memberMapper.teacherSnsDelete", memberNo);
	}

	/** 강사 정보 수정 - sns 삽입
	 * @param sns
	 * @return result4
	 */
	public int teacherSnsInsert(Sns sns) {
		return sqlSession.insert("memberMapper.teacherSnsInsert", sns);
	}

	/** 강사 정보 수정 - 이력 삭제
	 * @param memberNo
	 * @return result
	 */
	public int teacherProfileDelete(int memberNo) {
		return sqlSession.delete("memberMapper.teacherProfileDelete", memberNo);
	}

	/** 강사 정보 수정 - 이력 삽입
	 * @param career
	 * @return result
	 */
	public int teacherProfileInsert(Career career) {
		return sqlSession.insert("memberMapper.teacherProfileInsert", career);
	}

	/** 강사 신청
	 * @param teacher
	 * @param career
	 * @param sns
	 * @return result
	 */
	public int teacherRegisterInsert(Teacher teacher) {
		return sqlSession.insert("memberMapper.teacherRegisterInsert", teacher);
	}

	
	/** 이력 삽입
	 * @param car
	 * @return result
	 */
	public int insertTeacherCareer(Career car) {
		return sqlSession.insert("memberMapper.insertTeacherCareer", car);
	}

	/** 강사 이력 삭제
	 * @param id
	 * @return result
	 */
	public int teacherProfiledelete(String id) {
		return sqlSession.insert("memberMapper.teacherProfiledelete", id);
	}

	/** 강사 이력 이미지 조회
	 * @param id
	 * @return selectImgName
	 */
	public String selectImgName(String id) {
		return sqlSession.selectOne("memberMapper.selectImgName", id);
	}

	/** 학생 프로필 수정
	 * @param member
	 * @return result
	 */
	public int studentProfileUpdate(Member member) {
		return sqlSession.update("memberMapper.studentProfileUpdate", member);
	}
	
	/** 회원 탈퇴
	 * @param memberNo
	 * @return result
	 */
	public int memberResign(int memberNo) {
		return sqlSession.update("memberMapper.memberResign", memberNo);
	}



	

}
