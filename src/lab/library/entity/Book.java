package lab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
		isAvailable = true;
	}

	public Book(String title, String author, String isbn, int publishYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		isAvailable = true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public boolean checkout() {
		if(isAvailable) {
			isAvailable = false;
			return true;
		}else {
			return false;
		}
	}
	
	public void returnBook() {
		if(isAvailable == false) {
			isAvailable = true;
		}else {
			System.out.println("�� å�� ������� �ʾҽ��ϴ�.");
		}
	}
	
	@Override
	public String toString() {
		String availabilityStatus = isAvailable ? "����" : "���� ��";
		return "å����: " + getTitle() + "����: " + getAuthor() + "ISBN: " + getIsbn() + "���ǳ⵵: " + getPublishYear() +"���� ���� ����: " + availabilityStatus ;
	}
	
}
