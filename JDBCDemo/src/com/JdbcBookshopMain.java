package com;

import com.dao.BookDao;
import com.dao.CustomerDao;
import com.models.Book;
import com.models.Customer;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class JdbcBookshopMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = -1;

		do {
			System.out.println("\n--- Bookshop Menu ---");
			System.out.println("1. Add New Book");
			System.out.println("2. Update Book");
			System.out.println("3. Delete Book");
			System.out.println("4. View All Books");
			System.out.println("5. Search Book by ID");
			System.out.println("6. Search Books by Subject");
			System.out.println("7. View All Book Subjects");
			System.out.println("8. Search Customer by Email");
			System.out.println("9. Add New Customer");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					addNewBook(sc);
					break;
				case 2:
					updateBook(sc);
					break;
				case 3:
					deleteBook(sc);
					break;
				case 4:
					viewAllBooks();
					break;
				case 5:
					searchBookById(sc);
					break;
				case 6:
					searchBooksBySubject(sc);
					break;
				case 7:
					viewAllSubjects();
					break;
				case 8:
					searchCustomerByEmail(sc);
					break;
				case 9:
					addNewCustomer(sc);
					break;
				case 0:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);

		sc.close();
	}

	private static void addNewBook(Scanner sc) {
		System.out.print("Enter Book Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Book Author: ");
		String author = sc.nextLine();
		System.out.print("Enter Book Subject: ");
		String subject = sc.nextLine();
		System.out.print("Enter Book Price: ");
		double price = sc.nextDouble();

		Book newBook = new Book(0, name, author, subject, price);
		try (BookDao bookDao = new BookDao()) {
			int count = bookDao.save(newBook);
			System.out.println("Books Saved: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void updateBook(Scanner sc) {
		System.out.print("Enter Book ID to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter New Book Name: ");
		String name = sc.nextLine();
		System.out.print("Enter New Book Author: ");
		String author = sc.nextLine();
		System.out.print("Enter New Book Subject: ");
		String subject = sc.nextLine();
		System.out.print("Enter New Book Price: ");
		double price = sc.nextDouble();

		Book updatedBook = new Book(id, name, author, subject, price);
		try (BookDao bookDao = new BookDao()) {
			int count = bookDao.update(updatedBook);
			System.out.println("Books Updated: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteBook(Scanner sc) {
		System.out.print("Enter Book ID to delete: ");
		int id = sc.nextInt();

		try (BookDao bookDao = new BookDao()) {
			int count = bookDao.deleteById(id);
			System.out.println("Books Deleted: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void viewAllBooks() {
		try (BookDao bookDao = new BookDao()) {
			List<Book> list = bookDao.findAll();
			for (Book bk : list) {
				System.out.println(bk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void searchBookById(Scanner sc) {
		System.out.print("Enter Book ID to search: ");
		int id = sc.nextInt();

		try (BookDao bookDao = new BookDao()) {
			Book book = bookDao.findById(id);
			if (book != null) {
				System.out.println("Found: " + book);
			} else {
				System.out.println("Book Not Found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void searchBooksBySubject(Scanner sc) {
		System.out.print("Enter Book Subject to search: ");
		String subject = sc.nextLine();

		try (BookDao bookDao = new BookDao()) {
			List<Book> books = bookDao.findBySubject(subject);
			if (!books.isEmpty()) {
				for (Book bk : books) {
					System.out.println(bk);
				}
			} else {
				System.out.println("No books found for subject: " + subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void viewAllSubjects() {
		try (BookDao bookDao = new BookDao()) {
			List<String> subjects = bookDao.findAllSubjects();
			System.out.println("Available Subjects: " + subjects);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void searchCustomerByEmail(Scanner sc) {
		System.out.print("Enter Customer Email: ");
		String email = sc.next();

		try (CustomerDao custDao = new CustomerDao()) {
			Customer customer = custDao.findByEmail(email);
			if (customer != null) {
				System.out.println("Found Customer: " + customer);
			} else {
				System.out.println("Customer Not Found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addNewCustomer(Scanner sc) {
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Address: ");
		String address = sc.nextLine();
		System.out.print("Enter Email: ");
		String email = sc.next();
		System.out.print("Enter Mobile: ");
		String mobile = sc.next();
		System.out.print("Enter Password: ");
		String password = sc.next();
		System.out.print("Enter Birthdate (yyyy-MM-dd): ");
		String birth = sc.next();
		Date birthDate = Date.valueOf(birth);

		Customer newCust = new Customer(0, name, password, email, address, mobile, birthDate);
		try (CustomerDao custDao = new CustomerDao()) {
			int count = custDao.save(newCust);
			System.out.println("Customers Saved: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
