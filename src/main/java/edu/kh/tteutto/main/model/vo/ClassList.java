package edu.kh.tteutto.main.model.vo;

public class ClassList {
	private int classNo;		// 클래스번호
	private String classArea;	// 수업등록지역
	private int classType;		// 수업형태
	private String className;	// 수업제목
	
	private String thumbnailImageName;	// 썸네일이미지명
	private String categoryName;		// 카테고리명
	
	private String teacherImage;		// 프로필사진
	private String memberName;			// 회원명
	private int episodePrice;			// 수업료
	private String categoryDetailName;	// 세부카테고리명
	
	private double starAverage;	// 별점 평균
	private int heartFlag;		// 찜 여부
	private int heartCount;		// 찜 개수
	
	public ClassList() {}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getClassArea() {
		return classArea;
	}

	public void setClassArea(String classArea) {
		this.classArea = classArea;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getThumbnailImageName() {
		return thumbnailImageName;
	}

	public void setThumbnailImageName(String thumbnailImageName) {
		this.thumbnailImageName = thumbnailImageName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTeacherImage() {
		return teacherImage;
	}

	public void setTeacherImage(String teacherImage) {
		this.teacherImage = teacherImage;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getEpisodePrice() {
		return episodePrice;
	}

	public void setEpisodePrice(int episodePrice) {
		this.episodePrice = episodePrice;
	}

	public String getCategoryDetailName() {
		return categoryDetailName;
	}

	public void setCategoryDetailName(String categoryDetailName) {
		this.categoryDetailName = categoryDetailName;
	}

	public double getStarAverage() {
		return starAverage;
	}

	public void setStarAverage(double starAverage) {
		this.starAverage = starAverage;
	}

	public int getHeartFlag() {
		return heartFlag;
	}

	public void setHeartFlag(int heartFlag) {
		this.heartFlag = heartFlag;
	}

	public int getHeartCount() {
		return heartCount;
	}

	public void setHeartCount(int heartCount) {
		this.heartCount = heartCount;
	}

	@Override
	public String toString() {
		return "ClassList [classNo=" + classNo + ", classArea=" + classArea + ", classType=" + classType
				+ ", className=" + className + ", thumbnailImageName=" + thumbnailImageName + ", categoryName="
				+ categoryName + ", teacherImage=" + teacherImage + ", memberName=" + memberName + ", episodePrice="
				+ episodePrice + ", categoryDetailName=" + categoryDetailName + ", starAverage=" + starAverage
				+ ", heartFlag=" + heartFlag + ", heartCount=" + heartCount + "]";
	}
}
