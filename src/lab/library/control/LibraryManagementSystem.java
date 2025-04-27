package lab.library.control;

import java.util.Scanner;

import lab.library.entity.*;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		LibraryManagementSystem acc = new LibraryManagementSystem();
		Library library = new Library("광명시도서관");
		addSampleBooks(library);
		acc.Libraryinformation(library);
		acc.testCheckOut(library);
		acc.testFindBooks(library);
		acc.testReturn(library);
		acc.displayAvailableBooks(library);
	}
	
	private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}
	
	private void testFindBooks(Library library) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("어떻게 책을 찾으시겠습니까?");
	    System.out.println("1. 제목으로 찾기");
	    System.out.println("2. 저자로 찾기");
	    int choice = scanner.nextInt();
	    scanner.nextLine();

	    if (choice == 1) {
	        System.out.print("책 제목을 입력하세요: ");
	        String bookName = scanner.nextLine();
	        Book foundBook = library.findBookByTitle(bookName);

	        if (foundBook != null) {
	            System.out.println("책 찾기 성공: " + foundBook.toString());
	        } else {
	            System.out.println("책을 찾을 수 없습니다.");
	        }
	    } else if (choice == 2) {
	        System.out.print("저자 이름을 입력하세요: ");
	        String authorName = scanner.nextLine();
	        Book foundBook = library.findBooksByAuthor(authorName);

	        if (foundBook != null) {
	            System.out.println("책 찾기 성공: " + foundBook.toString());
	        } else {
	            System.out.println("책을 찾을 수 없습니다.");
	        }
	    } else {
	        System.out.println("잘못된 선택입니다. 1 또는 2를 선택하세요.");
	    }
	}

	
	private void testCheckOut(Library library) {
	    String isbn = "978-89-01-12345-6";
		Book borrowedBook = library.findBooksByISBN(isbn);
		System.out.println("===== 도서 대출 테스트 =====");
	    if (borrowedBook != null && borrowedBook.isAvailable()) {
	    	library.checkOutBook(isbn);
	        System.out.println("도서 대출 성공!");
	        System.out.println("대출된 도서 정보:");
	        System.out.println(borrowedBook.toString());  // 대출된 책 정보 출력
	    } else {
	        System.out.println("도서 대출 실패: 해당 ISBN의 책을 찾을 수 없습니다.");
	    }

	    System.out.println("===== 도서관 현재 상태 =====");
	    BookCount(library);
	}

	
	private void testReturn(Library library) {
		String isbn = "978-89-01-12345-6";
		Book returnedBook = library.findBooksByISBN(isbn);
		System.out.println("===== 도서 반납 테스트 =====");
	    if (returnedBook != null && !returnedBook.isAvailable()) {
	    	library.returnBook(isbn);
	        System.out.println("도서 반납 성공!");
	        System.out.println("반납된 도서 정보:");
	        System.out.println(returnedBook.toString());  // 대출된 책 정보 출력
	    } else {
	        System.out.println("도서 반납 실패: 해당 ISBN를 찾을 수 없습니다.");
	    }

	    System.out.println("===== 도서관 현재 상태 =====");
	    BookCount(library);

	}
	
	private void displayAvailableBooks(Library library) {
		System.out.println("===== 대출 가능한 도서 목록 =====");
		library.getAvailableBooks();
		
	}
	
	private void Libraryinformation(Library library) {
		System.out.println("=====" + library.getName() + "=====");
		BookCount(library);

	}
	
	private void BookCount(Library library) {
		System.out.println("전체 도서 수: " + library.getTotalBooks());
	    System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
	    System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
	}
	
	
}
