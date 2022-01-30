package edu.kh.tteutto.admin.model.vo;

public class AdminTeacher {
	// 강사 테이블
	private int memberNo;
	private String memberName;
	private String teacherImg;
	private String teacherIntro;
	private String teacherRequestDate;
	private int teacherStatus;

	public AdminTeacher() {
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getTeacherImg() {
		return teacherImg;
	}

	public void setTeacherImg(String teacherImg) {
		this.teacherImg = teacherImg;
	}

	public String getTeacherIntro() {
		return teacherIntro;
	}

	public void setTeacherIntro(String teacherIntro) {
		this.teacherIntro = teacherIntro;
	}

	public String getTeacherRequestDate() {
		return teacherRequestDate;
	}

	public void setTeacherRequestDate(String teacherRequestDate) {
		this.teacherRequestDate = teacherRequestDate;
	}

	public int getTeacherStatus() {
		return teacherStatus;
	}

	public void setTeacherStatus(int teacherStatus) {
		this.teacherStatus = teacherStatus;
	}

	@Override
	public String toString() {
		return "AdminTeacher [memberNo=" + memberNo + ", memberName=" + memberName + ", teacherImg=" + teacherImg
				+ ", teacherIntro=" + teacherIntro + ", teacherRequestDate=" + teacherRequestDate + ", teacherStatus="
				+ teacherStatus + "]";
	}

}
