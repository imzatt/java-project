package com.mmit.model.enity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

	public static Connection createConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/library_mangement_system","root","");
		
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		
		createConnection();
		System.out.println("Success");
	}
	
	public static Librarian Login(String email, String pass) {
		  
		Librarian lib = null;
		try(var con = createConnection()) {
			var query = "SELECT * FROM librarians WHERE email = ? AND password = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, email);
			pstm.setString(2, pass);
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				lib = new Librarian();
				lib.setEmail(rs.getString("email"));
				lib.setPassword(rs.getString("id"));
				lib.setId(rs.getInt("id"));
			}
		} 
		catch (Exception e) {
			lib = null;
		}
		return lib;
	}


	public static List<Category> findAllCategory() {
		
		List<Category> data = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM categories ORDER BY id";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var cat = new Category();
				
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				
				data.add(cat);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
				
		return data;
	}

	public static void saveCategory(String name) throws Exception {
		
		try(var con = createConnection()) {
			var query = "INSERT INTO categories(name)VALUES(?)";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, name);
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

	public static void updateCategory(Category cat) throws Exception {
		
		try(var con = createConnection()) {
			var query = "UPDATE categories SET name = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, cat.getName());
			pstm.setInt(2, cat.getId());
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

	public static void deleteCategory(int id) {
		
		try(var con = createConnection()) {
			var query = "DELETE FROM categories WHERE id = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static List<Author> findAllAuthor() {
		
		List<Author> data = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM authors";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var auth = new Author();
				
				auth.setId(rs.getInt("id"));
				auth.setName(rs.getString("name"));
				auth.setCity(rs.getString("city"));
				auth.setBirthday(LocalDate.parse(rs.getString("birthday")));
				
				data.add(auth);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}

	public static void saveAuthor(Author auth) throws Exception {
		
		try(var con = createConnection()) {
			var query = "INSERT INTO authors(name,city,birthday)VALUES(?, ?, ?)";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, auth.getName());
			pstm.setString(2, auth.getCity());
			pstm.setDate(3, Date.valueOf(auth.getBirthday()));
			
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

	public static void updateAuthor(Author auth) throws Exception {
		
		try(var con = createConnection()) {
			var query = "UPDATE authors SET name = ?, city = ?, birthday = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, auth.getName());
			pstm.setString(2, auth.getCity());
			pstm.setDate(3, Date.valueOf(auth.getBirthday()));
			pstm.setInt(4, auth.getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
		
	}

	public static void deleteAuthor(int id) {
		
		try(var con = createConnection()) {
			var query = "DELETE FROM authors WHERE id = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static List<Book> findAllBook() {
		
		List<Book> data = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT b.code,b.title,b.publish_date,c.name 'categoryName',a.name 'authorName',b.available,l.email 
					FROM books b, categories c, authors a, librarians l 
					WHERE b.category_id = c.id AND b.author_id = a.id AND b.created_by = l.id
					""";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var book = new Book();
				
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
				book.setAvailable(rs.getInt("available"));
				
				var author = new Author();
				author.setName(rs.getString("authorName"));
				book.setAuthor(author);
				
				var category = new Category();
				category.setName(rs.getString("categoryName"));
				book.setCategory(category);
				
				var created_by = new Librarian();
				created_by.setEmail(rs.getString("email"));
				book.setCreate_by(created_by);
				
				data.add(book);
				
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}


	public static void addBook(Book book) throws Exception {
		
		try(var con = createConnection()) {
			var query = """
					INSERT INTO books(code, title, publish_date, author_id, category_id, available, created_by)
					VALUES (?, ?, ?, ?, ?, ?, ?)
					""";
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setDate(3, Date.valueOf(book.getPublishDate()));
			pstm.setInt(4, book.getAuthor().getId());
			pstm.setInt(5, book.getCategory().getId());
			pstm.setInt(6, book.getAvailable());
			pstm.setInt(7, book.getCreate_by().getId());
			
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

	public static void editBook(Book book) throws Exception {
		
		try(var con = createConnection()) {
			var query = """
					UPDATE books
					SET title = ?, publish_date = ?,  author_id = ?, category_id = ?, available = ?
					WHERE code = ?
					""";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, book.getTitle());
			pstm.setDate(2, Date.valueOf(book.getPublishDate()));
			pstm.setInt(3, book.getAuthor().getId());
			pstm.setInt(4, book.getCategory().getId());
			pstm.setInt(5, book.getAvailable());
			pstm.setInt(6, book.getCode());
			
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
	}

	public static boolean deleteBook(int id) throws Exception{
		
		boolean result = false;
		try(var con = createConnection()) {
			var query = "DELETE FROM books WHERE code = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, id);
			
			var i = pstm.executeUpdate();
			if(i > 0) 
				result = true;
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public static List<Book> searchBook(String title, String author, String category) {
		
		List<Book> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT b.code,b.title,b.publish_date,a.name 'authorName',c.name 'categoryName',b.available,l.email
					FROM books b, categories c, authors a, librarians l
					WHERE b.category_id = c.id AND b.author_id = a.id AND b.created_by = l.id
					""";
			var params = new ArrayList<Object>();
			if(title != null && !title.isEmpty()) {
				query += " AND b.title LIKE ?";
				params.add("%" + title + "%");
			}
			if(author != null && !author.isEmpty()) {
				query += " AND a.name LIKE ?";
				params.add("%" + author + "%");
			}
			if(category != null && !category.isEmpty()) {
				query += " AND c.name LIKE ?";
				params.add("%" + category + "%");
			}
			
			var pstm = con.prepareStatement(query);
			for(var i=0; i<params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}
		
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var book = new Book();
				
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
				book.setAvailable(rs.getInt("available"));
				
				var auth = new Author();
				auth.setName(rs.getString("authorName"));
				book.setAuthor(auth);
				
				var cat = new Category();
				cat.setName(rs.getString("categoryName"));
				book.setCategory(cat);
				
				var created_by = new Librarian();
				created_by.setEmail(rs.getString("email"));
				book.setCreate_by(created_by);
				
				list.add(book);
			
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Librarian> findAllLibrarain() {
		
		List<Librarian> data = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM librarians";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var lib = new Librarian();
				
				lib.setId(rs.getInt("id"));
				lib.setName(rs.getString("name"));
				lib.setEmail(rs.getString("email"));
				lib.setPassword(rs.getString("password"));
				lib.setNrcno(rs.getString("nrcno"));
				lib.setPhone(rs.getInt("phone"));
				
				data.add(lib);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void addLibrarian(Librarian lib) throws Exception {
		
		try(var con = createConnection()) {
			var query = "INSERT INTO librarians(name,email,password,nrcno,phone)VALUES(?, ?, ?, ?, ?)";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, lib.getName());
			pstm.setString(2, lib.getEmail());
			pstm.setString(3, lib.getPassword());
			pstm.setString(4, lib.getNrcno());
			pstm.setInt(5, lib.getPhone());
			
			pstm.executeUpdate();
			
		} 
		catch (Exception e) {
			throw e;
		}
	}

	public static void editLibranrain(Librarian lib) throws Exception {
		
		try(var con = createConnection()) {
			var query = "UPDATE librarians SET name = ?, email = ?, password = ?, nrcno = ?, phone = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, lib.getName());
			pstm.setString(2, lib.getEmail());
			pstm.setString(3, lib.getPassword());
			pstm.setString(4, lib.getNrcno());
			pstm.setInt(5, lib.getPhone());
			pstm.setInt(6, lib.getId());
			
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

	public static void deleteLibrarain(int id) {
		
		try(var con = createConnection()) {
			var query = "DELETE FROM librarians WHERE id = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Librarian> searchLibraian(String name) {
		
		List<Librarian> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT id,name,email,nrcno,phone
					FROM librarians 
					WHERE 
					""";
			
			var params = new ArrayList<Object>();
			if(name != null && !name.isEmpty()) {
				query += " name LIKE ? ";
				params.add( "%" + name + "%");
			}
			var pstm = con.prepareStatement(query);
			for(var i = 0; i < params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var lib = new Librarian();
				
				lib.setId(rs.getInt("id"));
				lib.setName(rs.getString("name"));
				lib.setEmail(rs.getString("email"));
				lib.setNrcno(rs.getString("nrcno"));
				lib.setPhone(Integer.parseInt(rs.getString("phone")));
				
				list.add(lib);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Member> findAllMember() {
		
		List<Member> data = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM members";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				
				var mem = new Member();
				
				mem.setCardID(rs.getInt("card_id"));
				mem.setName(rs.getString("name"));
				mem.setRollno(rs.getInt("roll_no"));
				mem.setYear(rs.getString("year"));
				mem.setAcademicYear(rs.getString("academic_year"));
				mem.setCreatedDate(LocalDate.parse(rs.getString("created_date")));
				mem.setExpiredDate(LocalDate.parse(rs.getString("expired_date")));
				
				data.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}

	public static void addMember(Member user) throws Exception {
		
		try(var con = createConnection()) {
			var query = """
					INSERT INTO members(name,roll_no,year,academic_year,created_date,expired_date)
					VALUES(?, ?, ?, ?, ?, ?)
					""";
			
			var pstm =con.prepareStatement(query);
			
			pstm.setString(1, user.getName());
			pstm.setInt(2, user.getRollno());
			pstm.setString(3, user.getYear());
			pstm.setString(4, user.getAcademicYear());
			pstm.setDate(5, Date.valueOf(user.getCreatedDate()));
			pstm.setDate(6, Date.valueOf(user.getExpiredDate()));
			
			pstm.executeUpdate();
			 
		} 
		catch (Exception e) {
			throw e;
		}
	}

	public static void editMember(Member mem) throws Exception {
		
		try(var con = createConnection()) {
			var query = """
					UPDATE members
					SET name = ?, roll_no = ?, year = ?, academic_year = ?, created_date = ?, expired_date = ?
					WHERE card_id = ?
					""";
			
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, mem.getName());
			pstm.setInt(2, mem.getRollno());
			pstm.setString(3, mem.getYear());
			pstm.setString(4, mem.getAcademicYear());
			pstm.setDate(5, Date.valueOf(mem.getCreatedDate()));
			pstm.setDate(6, Date.valueOf(mem.getExpiredDate()));
			pstm.setInt(7, mem.getCardID());
			
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}


	public static void deleteMember(int cardID) {
		
		try(var con = createConnection()) {
			var query = "DELETE FROM members WHERE card_id = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, cardID);
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	public static List<Member> searchMember(String card_id) {
		
		List<Member> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT card_id, name, roll_no, year, academic_year, created_date, expired_date 
					FROM members 
					WHERE 
					""";
			
			var params = new ArrayList<Object>();
			if(card_id != null && !card_id.isEmpty()) {
				query += " card_id = ?";
				params.add(card_id);
			}
			
			var pstm = con.prepareStatement(query);
			for(var i=0; i<params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				
				var mem = new Member();
				
				mem.setCardID(rs.getInt("card_id"));
				mem.setName(rs.getString("name"));
				mem.setRollno(rs.getInt("roll_no"));
				mem.setYear(rs.getString("year"));
				mem.setAcademicYear(rs.getString("academic_year"));
				mem.setCreatedDate(LocalDate.parse(rs.getString("created_date")));
				mem.setExpiredDate(LocalDate.parse(rs.getString("expired_date")));
				
				list.add(mem);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static List<Transaction> findAllTransaction() {
		
		List<Transaction> data = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT t.id, m.card_id, b.code, t.borrow_date, t.due_date, t.fees, l.id 'email'
					FROM transactions t, books b, members m, librarians l 
					WHERE t.card_id = m.card_id AND t.book_id = b.code AND t.lib_id = l.id
					""";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				
				var trans = new Transaction();
				
				trans.setId(rs.getInt("id"));
				trans.setCardID(rs.getInt("card_id"));
				trans.setBookID(rs.getInt("code"));
				trans.setBorrowDate(LocalDate.parse(rs.getString("borrow_date")));
				trans.setDueDate(LocalDate.parse(rs.getString("due_date")));
				trans.setFees(rs.getInt("fees"));
				
				var created_by = new Librarian();
				created_by.setEmail(rs.getString("email"));
				trans.setCreate_by(created_by);

				
				data.add(trans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static boolean checkBook(Transaction tran) {
		
		boolean status = false;
		try(var con = createConnection()) {
			var query = "SELECT * FROM books WHERE code = ? ";
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, tran.getBookID());
			var rs = pstm.executeQuery();
			status = rs.next();
			con.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int saveBook(Transaction tran) {
		
		int status = 0;
		try(var con = createConnection()) {
			status = updateBook(tran.getBookID());
			
			if(status>0) {
				var query = """
						INSERT INTO transactions(card_id ,book_id, borrow_date, due_date, fees, lib_id)
						VALUES(?,?,?,?,?,?)
						""";
				var pstm = con.prepareStatement(query);
				
				pstm.setInt(1, tran.getCardID());
				pstm.setInt(2, tran.getBookID());
				pstm.setDate(3, Date.valueOf(tran.getBorrowDate()));
				pstm.setDate(4, Date.valueOf(tran.getDueDate()));
				pstm.setInt(5, tran.getFees());
				pstm.setInt(6, tran.getCreate_by().getId());
				
				pstm.executeUpdate();
				
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}

	private static int updateBook(int bookID) {
		int status = 0;
		int quantity = 0;
		try(var con = createConnection()) {
			var query = "SELECT available FROM books WHERE code = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, bookID);
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				quantity = rs.getInt("available");
			}
			
			if(quantity>0) {
				var query2 = "UPDATE books set available = ? WHERE code = ?"; 
				var pstm2 = con.prepareStatement(query2);
				
				pstm2.setInt(1, quantity-1);
				pstm2.setInt(2, bookID);
				
				status = pstm2.executeUpdate();
			}
			con.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<Transaction> searchCode(String code) {
		
		List<Transaction> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT t.id, m.card_id, b.code, t.borrow_date, t.due_date, t.fees, l.id 'email'
					FROM transactions t, books b, members m, librarians l 
					WHERE t.card_id = m.card_id AND t.book_id = b.code AND t.lib_id = l.id 
					""";
			
			var params = new ArrayList<Object>();
			if(code != null && !code.isEmpty()) {
				query += " AND t.book_id = ?";
				params.add(code);
			}
			
			var pstm = con.prepareStatement(query);
			for(var i=0; i<params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}
			var rs = pstm.executeQuery();
			while(rs.next()) {
				
				var trans = new Transaction();

				trans.setId(rs.getInt("id"));
				trans.setCardID(rs.getInt("card_id"));
				trans.setBookID(rs.getInt("code"));
				trans.setBorrowDate(LocalDate.parse(rs.getString("borrow_date")));
				trans.setDueDate(LocalDate.parse(rs.getString("due_date")));
				trans.setFees(rs.getInt("fees"));
				
				var created_by = new Librarian();
				created_by.setEmail(rs.getString("email"));
				trans.setCreate_by(created_by);

				list.add(trans);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int delete(Transaction trans,String id) {
		int status = 0;
		int borrow_id = 0;
		try(var con = createConnection()) {
			borrow_id = trans.getId();
			status = updatebook(trans.getBookID());
			
			if(borrow_id>0) {
				var query = "DELETE FROM transactions WHERE id = ?";
				
				var pstm = con.prepareStatement(query);
				pstm.setInt(1, trans.getId());
				status = pstm.executeUpdate();
			}
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
		return status;
	}

	private static int updatebook(int bookID) {
		int status=0;
		int quantity=0;
		try(var con = createConnection()) {
			var query = "SELECT available FROM books WHERE code = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, bookID);
			var rs = pstm.executeQuery();
			if(rs.next()) {
				quantity = rs.getInt("available");
			}
			
			if(quantity>=0) {
				var query2 = "UPDATE books set available = ? WHERE code = ?";
				var pstm2 = con.prepareStatement(query2);
				pstm2.setInt(1, quantity+1);
				pstm2.setInt(2, bookID);
				
				status = pstm2.executeUpdate();
			}
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}



}
