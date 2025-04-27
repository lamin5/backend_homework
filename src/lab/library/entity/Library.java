package lab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books = new ArrayList<>();
	private String name;

	public Library(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book);
	}
	
	public Book findBookByTitle(String title) {
		for(Book book : books) {
			if(book.getTitle().contentEquals(title)) {
				return book;
			}
		}
		return null;

	}
	
	public Book findBooksByAuthor(String author) {
		for(Book book : books) {
			if(book.getAuthor().contentEquals(author)) {
				return book;
			}
		}
		return null;
	}
	
	public Book findBooksByISBN(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().contentEquals(isbn)) {
				return book;
			}
		}
		return null;
	}
	
	public boolean checkOutBook(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().contentEquals(isbn)) {
				return book.checkout();
			}
		}
		return false;
	}
	
	public void returnBook(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().contentEquals(isbn)) {
				book.returnBook();
				return;
			}
		}
		System.out.println("이 책은 대출되지 않았습니다.");
	}
	
	public List<Book> getAvailableBooks() {
	    List<Book> availableBooks = new ArrayList<>();
	    for (Book book : books) {
	        if (book.isAvailable()) {
	            availableBooks.add(book);
	            System.out.println(book.toString());
	            System.out.println("------------------------");
	        }
	    }
	    return availableBooks;
	}

	
	public List<Book> getAllBooks() {
		List<Book> AllBooks = new ArrayList<>();
	    for (Book book : books) {
	        AllBooks.add(book);
	    }
	    return AllBooks;
	}
	
	public int getTotalBooks() {
		return books.size();
	}
	
	public int getAvailableBooksCount() {
		int total = 0;
	    for (Book book : books) {
	        if(book.isAvailable()) {
	        	total += 1;
	        }
	    }
	    return total;
	}
	
	public int  getBorrowedBooksCount() {
		int total = 0;
	    for (Book book : books) {
	        if(!book.isAvailable()) {
	        	total += 1;
	        }
	    }
	    return total;
	}
	
}
