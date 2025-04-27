package lab.library.control;

import java.util.Scanner;

import lab.library.entity.*;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		LibraryManagementSystem acc = new LibraryManagementSystem();
		Library library = new Library("����õ�����");
		addSampleBooks(library);
		acc.Libraryinformation(library);
		acc.testCheckOut(library);
		acc.testFindBooks(library);
		acc.testReturn(library);
		acc.displayAvailableBooks(library);
	}
	
	private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}
	
	private void testFindBooks(Library library) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("��� å�� ã���ðڽ��ϱ�?");
	    System.out.println("1. �������� ã��");
	    System.out.println("2. ���ڷ� ã��");
	    int choice = scanner.nextInt();
	    scanner.nextLine();

	    if (choice == 1) {
	        System.out.print("å ������ �Է��ϼ���: ");
	        String bookName = scanner.nextLine();
	        Book foundBook = library.findBookByTitle(bookName);

	        if (foundBook != null) {
	            System.out.println("å ã�� ����: " + foundBook.toString());
	        } else {
	            System.out.println("å�� ã�� �� �����ϴ�.");
	        }
	    } else if (choice == 2) {
	        System.out.print("���� �̸��� �Է��ϼ���: ");
	        String authorName = scanner.nextLine();
	        Book foundBook = library.findBooksByAuthor(authorName);

	        if (foundBook != null) {
	            System.out.println("å ã�� ����: " + foundBook.toString());
	        } else {
	            System.out.println("å�� ã�� �� �����ϴ�.");
	        }
	    } else {
	        System.out.println("�߸��� �����Դϴ�. 1 �Ǵ� 2�� �����ϼ���.");
	    }
	}

	
	private void testCheckOut(Library library) {
	    String isbn = "978-89-01-12345-6";
		Book borrowedBook = library.findBooksByISBN(isbn);
		System.out.println("===== ���� ���� �׽�Ʈ =====");
	    if (borrowedBook != null && borrowedBook.isAvailable()) {
	    	library.checkOutBook(isbn);
	        System.out.println("���� ���� ����!");
	        System.out.println("����� ���� ����:");
	        System.out.println(borrowedBook.toString());  // ����� å ���� ���
	    } else {
	        System.out.println("���� ���� ����: �ش� ISBN�� å�� ã�� �� �����ϴ�.");
	    }

	    System.out.println("===== ������ ���� ���� =====");
	    BookCount(library);
	}

	
	private void testReturn(Library library) {
		String isbn = "978-89-01-12345-6";
		Book returnedBook = library.findBooksByISBN(isbn);
		System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
	    if (returnedBook != null && !returnedBook.isAvailable()) {
	    	library.returnBook(isbn);
	        System.out.println("���� �ݳ� ����!");
	        System.out.println("�ݳ��� ���� ����:");
	        System.out.println(returnedBook.toString());  // ����� å ���� ���
	    } else {
	        System.out.println("���� �ݳ� ����: �ش� ISBN�� ã�� �� �����ϴ�.");
	    }

	    System.out.println("===== ������ ���� ���� =====");
	    BookCount(library);

	}
	
	private void displayAvailableBooks(Library library) {
		System.out.println("===== ���� ������ ���� ��� =====");
		library.getAvailableBooks();
		
	}
	
	private void Libraryinformation(Library library) {
		System.out.println("=====" + library.getName() + "=====");
		BookCount(library);

	}
	
	private void BookCount(Library library) {
		System.out.println("��ü ���� ��: " + library.getTotalBooks());
	    System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
	    System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
	}
	
	
}
