package lab.control;

import lab.entity.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student student = new Student("20191457","��μ�", "��ǻ�Ͱ���", 3);
		System.out.println("�й�  : " + student.getStudentId());
		System.out.println("�̸�  : " + student.getName());
		System.out.println("����  : " + student.getMajor());
		System.out.println("�г�  : " + student.getGrade());
		
		System.out.println("5�г����� ����");
		try {
		    student.setGrade(5);
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}

	}

}
