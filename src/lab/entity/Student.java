package lab.entity;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	public Student(String studentId, String name, String major, int grade) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}
	public String getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if (grade >= 1 && grade <= 4) {
		    // 올바른 값 (아무 문제 없음)
		} else {
		    // 잘못된 값 -> 예외 처리
		    throw new IllegalArgumentException("학년은 1~4 사이여야 합니다.");
		}

	}
}
