package streams;

import java.util.Scanner;

public class Book {
	
    private String title;
    private String author;
    private double price;
    private int publicationYear;

    public Book(String title, String author, double price, int publicationYear) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', price=%.2f, publicationYear=%d}", title, author, price, publicationYear);
    }
    
    public int booksinyear() {
		return publicationYear;
    	
    }
}
