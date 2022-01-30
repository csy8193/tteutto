package edu.kh.tteutto.member.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.member.model.service.MemberService;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@SessionAttributes({ "loginMember" })

@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService service;

	@Autowired
	private JavaMailSender mailSender;

	// 회원가입 페이지 이동
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signUp() {
		return "member/signup";
	}
	

	// 이메일 중복 검사
	@RequestMapping("emailDupCheck")
	@ResponseBody
	public int emailDupCheck(String inputEmail) {
		return service.emailDupCheck(inputEmail);
	}

	// 이메일 인증 번호
	@RequestMapping("sendMail")
	@ResponseBody
	public void sendMailTest(String inputEmail) {

		String temp = "";

		// 인증 번호 생성기
		Random rnd = new Random();
		for (int i = 0; i < 8; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp += (char) ((int) (rnd.nextInt(26)) + 97);
				break;
			case 1:
				// A-Z
				temp += (char) ((int) (rnd.nextInt(26)) + 65);
				break;
			case 2:
				// 0-9
				temp += (rnd.nextInt(10));
				break;
			}
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("inputEmail", inputEmail);
		map.put("temp", temp);

		int result2 = service.emailDupCheck2(inputEmail);
		int result = 0;
		
		if (result2 == 0) {
			result = service.sendMailTest(map);
		}else {
			result =service.updateMailTest(map);
		}
		if (result == 1) {
			String subject = "뜨또 회원가입 인증 이메일 입니다.";
			String content = "뜨또 홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 "
					+ "<span style='color : #BF5846; font-weight:bold; font-size: 18px;'>" + temp + "</span>" + " 입니다." + "<br><br>"
					+ "해당 인증번호를 인증번호 입력칸에 입력해 주세요.";
			String from = "sseungjoon0319@gmail.com";
			String to = inputEmail;
			try {
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
				// true는 멀티파트 메세지를 사용하겠다는 의미

				/*
				 * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 MimeMessageHelper mailHelper = new
				 * MimeMessageHelper(mail,"UTF-8");
				 */

				// mailHelper.setFrom(from);
				// 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
				// 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
				mailHelper.setFrom("뜨또 <sseungjoon0319@gmail.com>");
				mailHelper.setTo(to);
				mailHelper.setSubject(subject);
				mailHelper.setText(content, true);
				// true는 html을 사용하겠다는 의미입니다.

				/*
				 * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
				 */

				mailSender.send(mail);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	// 이메일 인증번호 확인
	@ResponseBody
	@RequestMapping("checkCert")
	public int checkCert(String inputCertify, String inputEmail) {
		
		System.out.println(inputCertify + " / " +inputEmail);
		Map<String, String> map = new HashMap<String, String>();
		map.put("inputEmail", inputEmail);
		map.put("inputCertify", inputCertify);
		
		int result = service.checkCert(map);
		
		return result;
	}

	// 회원가입
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signUp(Member member, RedirectAttributes ra) {

		int result = service.signUp(member);

		String title;
		String text;
		String icon;

		if (result > 0) { // 성공
			title = "회원 가입 성공";
			text = member.getMemberNm() + "님의 회원 가입을 환영합니다.";
			icon = "success"; // success, error, info, warning
		} else { // 실패
			title = "회원 가입 실패";
			text = "관리자에 문의해주세요";
			icon = "error"; // success, error, info, warning
		}

		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("text", text);
		ra.addFlashAttribute("icon", icon);

		return "redirect:/";
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	// 로그인
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Member member, Model model, RedirectAttributes ra,
			@RequestParam(value = "save", required = false) String save, HttpServletRequest req,
			HttpServletResponse resp) {

		Member loginMember = service.login(member);

		if (loginMember != null) {
			model.addAttribute("loginMember", loginMember);

			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());

			if (save != null) {
				cookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				cookie.setMaxAge(0);
			}
			cookie.setPath(req.getContextPath());
			resp.addCookie(cookie);
		} else {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호를 확인해주세요.");

		}
		return "redirect:/";
	}

	// 로그아웃
	@RequestMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete();

		return "redirect:/";
	}

	// 비밀번호 찾기 페이지 이동
	@RequestMapping(value = "findPw", method = RequestMethod.GET)
	public String findPw() {
		return "member/findPw";
	}

	// 비밀번호 찾기 링크 보내기
	@RequestMapping("sendEmail")
	@ResponseBody
	public String sendEmail(String inputEmail, RedirectAttributes ra) {
		
		String temp = "";
		String text = "";
		String icon = "";
		
		// 인증 번호 생성기
		Random rnd = new Random();
		for (int i = 0; i < 8; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp += (char) ((int) (rnd.nextInt(26)) + 97);
				break;
			case 1:
				// A-Z
				temp += (char) ((int) (rnd.nextInt(26)) + 65);
				break;
			case 2:
				// 0-9
				temp += (rnd.nextInt(10));
				break;
			}
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("inputEmail", inputEmail);
		map.put("temp", temp);

		
		int result =service.updateMailTest(map);
		String url = "http://localhost:8080/tteutto/member/changePw?memberEmail=" +inputEmail+"&certCd="+ temp;
		if (result == 1) {
			
			text = "이메일 링크 전송 성공";
			icon = "success";
			
			String subject = "뜨또 비밀번호 찾기 입니다.";
			String content = 
				"<div style='width: 500px; border: 1px solid #ddd; border-radius: 5px; padding: 30px;\'>" +
				"<h1>뜨또</h1>"+
				"<div style='margin: 20px 0; display: flex;'>"+
				"<div>"+
				"<p>비밀번호 변경 안내</p>"+
				"<p style='color: #989696; font-size: 14px;'>안녕하세요 회원님!</p>"+
				"</div>"+
				"<div style='margin-left: 15px;'>"+
				"<img src='https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61eac6a1f7ea86892aac80df/download/TTEUTTO_ver.4_(favicon).png' style='height: 40px;'>"+
				"</div>"+
				"</div>"+
				"<div style='background-color: rgb(255, 250, 218); padding: 10px;'>"+
				"<h4>꼭 확인해주세요!</h4>"+
				"<p style='margin:5px 0; font-size: 13px;'>- 아래 링크를 통해 비밀번호를 변경해주세요.</p>"+
				"<p style='margin:5px 0; font-size: 13px;'>- 아래 링크는 비밀번호 찾기를 신청 한 후 6시간이 지나면 소멸됩니다.</p>"+
				"<p style='margin:5px 0; font-size: 13px;'>- 만일 본인이 신청하지 않았다면 help@tteutto.com으로 문의 해주세요</p>"+
				"</div>"+      
				"<a  href="+url+" style='margin-top: 20px; display:block; background-color: #FFDF3E; border:0; font-size: 16px; cursor: pointer; text-decoration:none; color:black; text-align:center; padding:10px'>비밀번호 변경</a>"+
				"</div>";
			String from = "sseungjoon0319@gmail.com";
			String to = inputEmail;
			try {
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
				// true는 멀티파트 메세지를 사용하겠다는 의미

				/*
				 * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 MimeMessageHelper mailHelper = new
				 * MimeMessageHelper(mail,"UTF-8");
				 */

				// mailHelper.setFrom(from);
				// 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
				// 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
				mailHelper.setFrom("뜨또 <sseungjoon0319@gmail.com>");
				mailHelper.setTo(to);
				mailHelper.setSubject(subject);
				mailHelper.setText(content, true);
				// true는 html을 사용하겠다는 의미입니다.

				/*
				 * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
				 */
				mailSender.send(mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			text = "이메일을 확인해주세요.";
			icon = "error";
		}
		
		ra.addFlashAttribute("text", text);
		ra.addFlashAttribute("icon", icon);

		return "redirect:/";
	}
	
	// 비밀번호 변경
	@RequestMapping(value= "changePw", method=RequestMethod.GET)
	public String changePw() {
		return "member/changePw";
	}
	
	// 비밀번호 변경
	@RequestMapping(value="changePw", method=RequestMethod.POST)
	public String changePw(Member member, Certified certified, RedirectAttributes ra) {
		
		int result = service.changeConfirm(certified);
		String title = "";
		String text = "";
		String icon = "";
		String path = "";
		
		if(result == 1) {
			int result2 = service.changePw(member);
			
			if(result2 == 1) { // 성공
				title = "비밀번호 변경 성공";
				text = "다시 로그인 해주세요.";
				icon = "success"; 
				path = "redirect:/member/login";
				
			} else { // 실패
				title = "비밀번호 변경 실패";
				text = "관리자에 문의해주세요";
				icon = "error";
				path = "redirect:/";
			}
		
		}else {
			title = "비밀번호 변경 실패";
			text = "관리자에 문의해주세요";
			icon = "error";
			path = "redirect:/";
		}
		
		
		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("icon", icon);
		
		return path;
	}
	
	
	// 학생 마이페이지 클래스 목록 이동
	@RequestMapping(value = "studentClassList", method = RequestMethod.GET)
	public String studentClassList() {
		return "member/studentClassList";
	}

	// 학생 마이페이지 후기 목록 이동
	@RequestMapping(value = "studentCommentList", method = RequestMethod.GET)
	public String studentCommentList() {
		return "member/studentCommentList";
	}

	// 학생 마이페이지 후기 목록 이동
	@RequestMapping(value = "studentWishList", method = RequestMethod.GET)
	public String studentWishList() {
		return "member/studentWishList";
	}

	// 학생 프로필 페이지 이동
	@RequestMapping(value = "studentProfile", method = RequestMethod.GET)
	public String studentProfile() {
		return "member/studentProfile";
	}

	// 강사 프로필 페이지 이동
	@RequestMapping(value = "teacherProfile", method = RequestMethod.GET)
	public String teacherProfile(Model model, HttpSession session) {

//		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		int memberNo = 3;

		Teacher teacher = service.selectTeacherProfile(memberNo);
		List<Career> careerList = service.selectTeacherCareer(memberNo);

		System.out.println("careerList: " + careerList);

		model.addAttribute("careerList", careerList);
		model.addAttribute("teacher", teacher);

		return "member/teacherProfile";

	}

	// 강사 신청 페이지 이동
	@RequestMapping(value = "teacherRegister", method = RequestMethod.GET)
	public String teacherRegister() {
		return "member/teacherRegister";
	}
}
