package myPackage;

import java.util.ArrayList;
import java.util.Scanner;
 
public class LibMain {
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<Member> memberList = new ArrayList<>();
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
 
        do {
            System.out.println("\n--- Book Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. View All Books");
            System.out.println("5. Add Member");
            System.out.println("6. Remove Member");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
 
            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    viewAllBooks();
                    break;
                case 5:
                	addMember(scanner);
                	break;
                case 6:
                	removeMember(scanner);
                	break;
                case 7:
                	issueBook(scanner);
                	break;
                case 8:
                	System.out.println("Yet to be implemented");
                	break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 9);
 
        scanner.close();
    }
 
    // Method to add a new book
    public static void addBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Book Price: ");
        double price = scanner.nextDouble();
 
        Book newBook = new Book(id, title, author, price);
        bookList.add(newBook);
        System.out.println("Book added successfully!");
    }
    
    //Method to add a new member
    public static void addMember(Scanner scanner) {
    	System.out.print("Enter Member Id:");
    	int memid = scanner.nextInt();
    	scanner.nextLine();  
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        Member newMember = new Member(memid,name);
        memberList.add(newMember);
        System.out.println("Member added successfully!");
    }
 
    // Method to remove a book by ID
    public static void removeBook(Scanner scanner) {
        System.out.print("Enter Book ID to remove: ");
        int id = scanner.nextInt();
 
        Book bookToRemove = null;
        for (Book book : bookList) {
            if (book.getId() == id) {
                bookToRemove = book;
                break;
            }
        }
 
        if (bookToRemove != null) {
            bookList.remove(bookToRemove);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
    
    //Method to remove a member by Id
    public static void removeMember(Scanner scanner) {
    	System.out.print("Enter Member ID to remove: ");
        int memid = scanner.nextInt();
        Member membertoremove=null;
        for(Member member : memberList) {
        	if(member.getMemberId()==memid) {
        		membertoremove=member;
        		break;
        	}
        }
        if(membertoremove!=null) {
        	memberList.remove(membertoremove);
        	System.out.println("Member removed successfully!");
        } else {
            System.out.println("Member not found!");
        }
        	
    }
    
    public static void issueBook(Scanner scanner)
    {
    	System.out.print("Enter Member ID to issue book to");
    	int memid = scanner.nextInt();
    	scanner.nextLine();
    	System.out.print("Ente BookId to issue");
    	int id = scanner.nextInt();
    	
    	Boolean flag1=false,flag2=false;
    	 for(Member member : memberList) {
         	if(member.getMemberId()==memid) {
         		flag1=true;
         		break;
         	}
         }
    	 for(Book book : bookList) {
          	if(book.getId()==id) {
          		flag2=true;
          		break;
          	}
          }
    	 if(flag1==true && flag2==true)
    	 {
    		 System.out.println("Book Issued");
    	 }
    	 else
    		 System.out.println("Book Not Issued");
        
    }
 
    // Method to update a book's details by ID
    public static void updateBook(Scanner scanner) {
        System.out.print("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
 
        for (Book book : bookList) {
            if (book.getId() == id) {
                System.out.print("Enter new title: ");
                book.setTitle(scanner.nextLine());
                System.out.print("Enter new author: ");
                book.setAuthor(scanner.nextLine());
                System.out.print("Enter new price: ");
                book.setPrice(scanner.nextDouble());
                System.out.println("Book updated successfully!");
                return;
            }
        }
 
        System.out.println("Book not found!");
    }
 
    // Method to view all books
    public static void viewAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }
}
