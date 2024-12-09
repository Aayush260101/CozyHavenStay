package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;

import comparator.Student;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<>();
        books.add(new Book("Java Basics", "Alice Smith", 29.99, 2020));
        books.add(new Book("Advanced Java", "Bob Johnson", 39.99, 2022));
        books.add(new Book("Effective Java", "Joshua Bloch", 45.00, 2008));
        books.add(new Book("Java Streams", "Charlie Brown", 19.99, 2021));
        books.add(new Book("Java Concurrency", "Brian Goetz", 49.99, 2006));
        
        
        
        books.stream().filter((temp)->temp.getPublicationYear()>2000).forEach((temp2)->System.out.println(temp2.toString()));
        
        List<String> alltitles = books.stream().map((temp)->temp.getTitle()).collect(Collectors.toList());
        System.out.println(alltitles);
        
        books.stream().sorted(Comparator.comparingDouble(Book::getPrice)).forEach(System.out::println);
        
        OptionalDouble avg= books.stream().mapToDouble((temp)->temp.getPrice()).average();
        if (avg.isPresent()) {
            System.out.println("Average of Book Prices: " + avg.getAsDouble());
        } else {
            System.out.println("No prices in the list");
        }
        
        List<String> distinctauthors= books.stream().map(Book::getAuthor).distinct().collect(Collectors.toList());
        System.out.println(distinctauthors);
        
        long count = books.stream().filter((temp)->temp.getPrice()>30).count();
        System.out.println(count);
        
        Book maxBook = books.stream().max(Comparator.comparingDouble(Book::getPrice)).orElse(null);  // Returns null if the list is empty
        		 
        if (maxBook != null) {
        System.out.println("Book with highest price: " + maxBook);
        } else {
        System.out.println("No books available.");
        }
        
        Map<String,Long> mpp= books.stream().collect(Collectors.groupingBy(Book::getAuthor,Collectors.counting()));
        mpp.forEach((author, count1) -> 
        System.out.println("Author Name :" + author + " No. of Books : " + count1)
        );
        books.stream().filter((temp)-> temp.getTitle().contains("Java")).forEach((i)->System.out.println(i));
        
        System.out.print("Enter a year to find books published in that year: ");
        int year2 = sc.nextInt();
        abc(books, year2);
        
        System.out.print("Enter minimum price: ");
        double min = sc.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = sc.nextDouble();
        xyz(books, min, max);
        books.stream()
        .sorted((b1, b2) -> Integer.compare(b2.getPublicationYear(), b1.getPublicationYear())) 
        .forEach(System.out::println);
        
        
	}


public static void abc(List<Book> books, int year2) {
    List<Book> booksInYear = books.stream()
        .filter(book -> book.getPublicationYear() == year2)
        .collect(Collectors.toList());

    if (booksInYear.isEmpty()) {
        System.out.println("No books found for the year " + year2);
    } else {
        System.out.println("Books published in " + year2 + ":");
        booksInYear.forEach(System.out::println);
    }
}

public static void xyz(List<Book> books, double min, double max) {
    List<Book> booksInPriceRange = books.stream()
        .filter(book -> book.getPrice() >= min && book.getPrice() <= max)
        .collect(Collectors.toList());

    if (booksInPriceRange.isEmpty()) {
        System.out.println("No books found in the price range $" + min+ " - $" + max);
    } else {
        System.out.println("Books in the price range $" + min + " - $" + max + ":");
        booksInPriceRange.forEach(System.out::println);
    }
}
}
