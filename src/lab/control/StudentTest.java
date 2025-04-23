package lab.control;

import lab.entity.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student student = new Student("20191457","김민수", "컴퓨터공학", 3);
		System.out.println("학번  : " + student.getStudentId());
		System.out.println("이름  : " + student.getName());
		System.out.println("전공  : " + student.getMajor());
		System.out.println("학년  : " + student.getGrade());
		
		System.out.println("5학년으로 변경");
		try {
		    student.setGrade(5);
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}

	}

}
