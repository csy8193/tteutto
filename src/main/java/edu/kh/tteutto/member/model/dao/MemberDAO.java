package edu.kh.tteutto.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 로그인
	 * @param memberEmail
	 * @return loginMember
	 */
	public Member login(String memberEmail) {
		
		Member loginMember = sqlSession.selectOne("memberMapper.login", memberEmail);
		
		return loginMember;
	}

}
