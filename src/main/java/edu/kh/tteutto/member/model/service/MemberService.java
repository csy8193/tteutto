package edu.kh.tteutto.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.chat.model.vo.ChatRoom;
import edu.kh.tteutto.classRoom.model.vo.ClassRefund;
import edu.kh.tteutto.classRoom.model.vo.ClassRegister;
import edu.kh.tteutto.classRoom.model.vo.ClassReport;
import edu.kh.tteutto.classRoom.model.vo.ClassReview;
import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.member.model.vo.Sns;

public interface MemberService {

	/** 로그인
	 * @param member
	 * @return loginMember
	 */
	Member login(Member member);

	
	/** 이메일 중복 검사
	 * @param inputEmail
	 * @return result
	 */
	int emailDupCheck(String inputEmail);

	/** 회원가입
	 * @param member
	 * @return result
	 */
	int signUp(Member member);
	
	/** 강사 정보 조회
	 * @param memberNo 
	 * @param memberNo
	 * @return techer
	 */
	Teacher selectTeacherProfile(int memberNo);

	/** 강사 이력 조회
	 * @param memberNo
	 * @return career
	 */
	List<Career> selectTeacherCareer(int memberNo);
	
	/** 강사 sns 조회
	 * @param memberNo
	 * @return snsList
	 */
	List<Sns> selectTeacherSns(int memberNo);

	/** 회원 인증테이블에 이메일 중복 확인
	 * @param inputEmail
	 * @return result
	 */
	int emailDupCheck2(String inputEmail);

	/** 회원가입 이메일 인증번호 저장
	 * @param map
	 * @return result
	 */
	int sendMailTest(Map<String, String> map);

	/** 회원가입 이메일 인증번호 수정
	 * @param map
	 * @return
	 */
	int updateMailTest(Map<String, String> map);

	/** 이메일 인증 확인
	 * @param map
	 * @return result
	 */
	int checkCert(Map<String, String> map);

	/** 비밀번호 변경전 확인
	 * @param certified
	 * @return result
	 */
	int changeConfirm(Certified certified);

	/** 비밀번호 변경
	 * @param member
	 * @return result
	 */
	int changePw(Member member);


	/** 인증번호 지우기
	 * @param certified
	 * @return result
	 */
	int updateCert(Certified certified);


	/** 강사 프로필 수정
	 * @param teacher
	 * @param phone
	 * @param snsList
	 * @param profileInput
	 * @param images
	 * @param webPath 
	 * @param serverPath 
	 * @return result
	 */
	int teacherProfileUpdate(Teacher teacher, String phone, List<Sns> snsList, List<String> profileInput,
			List<MultipartFile> images, String webPath, String serverPath);

	/** 강사 신청
	 * @param teacher
	 * @param image 
	 * @param careerContent
	 * @param snsList
	 * @param serverPath 
	 * @param webPath 
	 * @return
	 */
	int teacherRegisterInsert(Teacher teacher, List<MultipartFile> images, MultipartFile image, String careerContent, List<Sns> snsList, String serverPath, String serverPath2);


	/** 강사 신청 - 이력 수정 x
	 * @param teacher
	 * @param phone
	 * @param snsList
	 * @return result
	 */
	int teacherProfileUpdate2(Teacher teacher, String phone, List<Sns> snsList);

	/**  강사 이력 삭제
	 * @param id
	 * @param serverPath 
	 * @param webPath 
	 * @return result
	 */
	int teacherProfiledelete(String id, String webPath, String serverPath);


	/** 학생 프로필 수정
	 * @param member
	 * @return result
	 */
	int studentProfileUpdate(Member member);


	/** 회원 탈퇴
	 * @param memberNo
	 * @return result
	 */
	int memberResign(int memberNo);

	/** 클래스 개수 조회 + 페이지네이션
	 * @param page
	 * @return pagination
	 */
	public Pagination getPagination(int memberNo, int page);
	
	/** 클래스 카드 목록 조회
	 * @param memberNo
	 * @return wishList
	 */
	public List<ClassList> selectWishList(Pagination pagination, int memberNo);


	/** 학생 수강신청 목록
	 * @param memberNo
	 * @return register
	 */
	List<ClassRegister> studentClassList(int memberNo);


	/** 학생 클래스 신고
	 * @param classReport
	 * @return result
	 */
	int insertReport(ClassReport classReport);


	/** 학생 후기 작성
	 * @param classReview
	 * @return result
	 */
	int insertComment(ClassReview classReview);


	/** 학생 작성한 후기 목록 조회
	 * @param memberNo
	 * @return review
	 */
	List<ClassReview> studentCommentList(int memberNo);


	/** 학생 후기 수정
	 * @param classReview
	 * @return result
	 */
	int updateReport(ClassReview classReview);


	/** 학생 대 강사 채팅방 생성
	 * @param chatRoom
	 * @return result
	 */
	int insertChatRoom(ChatRoom chatRoom);


	/** 채팅방이 이미 있는지 확인
	 * @param chatRoom
	 * @return check
	 */
	int checkChatRoom(ChatRoom chatRoom);


	/** 클래스 환불 신청
	 * @param refund
	 * @return result
	 */
	int refundClass(ClassRefund refund);


	/** 학생 후기 삭제
	 * @param regNo
	 * @return result
	 */
	int deleteReview(int reviewNo);





	
}
