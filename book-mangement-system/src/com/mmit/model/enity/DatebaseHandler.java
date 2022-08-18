package com.mmit.model.enity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatebaseHandler {

	public static Connection createConnection() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javatesting_1","root","");
		
		return conn;
	}

	public static void saveCategory(String name) throws Exception {
		
		try(var con = createConnection()){
			
			var query = "INSERT INTO categories(name)VALUES(?)";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			
			pstm.executeUpdate();
		}
		catch(Exception e) {
			throw e;
		}
		
	}

	public static List<Category> findAllCategory() {
		List<Category> data = new ArrayList<>();
		
		try(var con = createConnection()) {
			var query = "SELECT * FROM categories ORDER BY id";
			var pstm = con.prepareStatement(query);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				//create new category
				var cat = new Category();
				
				// bind column to field
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				
				// add obj to list
				data.add(cat);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return data;
	}

	public static void updateCategory(Category cat) throws Exception {
		
		try(var con = createConnection()) {
			var query = "UPDATE categories SET name = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, cat.getName());
			pstm.setInt(2, cat.getId());
			pstm.executeUpdate();
			
		} catch (Exception e) {
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
		List<Author> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM authors";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				//create obj
				var auth = new Author();
				// string to localdate
				auth.setBirthday(LocalDate.parse(rs.getString("birthday")));
				auth.setCity(rs.getString("city"));
				auth.setId(rs.getInt("id"));
				auth.setName(rs.getString("name"));
				// add obj to list
				list.add(auth);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void saveAuthor(Author obj) throws Exception {
		
		try(var con = createConnection()) {
			var query = "INSERT INTO authors(name,city,birthday)VALUES(?, ?, ?)";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, obj.getName());
			pstm.setString(2, obj.getCity());
			pstm.setDate(3, Date.valueOf(obj.getBirthday())); // convert localdate to string
			
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

	public static void updateAuthor(Author auth) throws Exception {
		try(var con = createConnection()) {
			var query = "UPDATE authors SET name = ?, birthday = ?, city = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, auth.getName());
			pstm.setDate(2, Date.valueOf(auth.getBirthday()));
			pstm.setString(3, auth.getCity());
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

	public static User login(String email, String pass) {
		User user = null;
		
		try(var con = createConnection()) {
			var query = "SELECT * FROM users WHERE email = ? AND password = ?";
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, email);
			pstm.setString(2, pass);
			
			var rs = pstm.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("id"));
				user.setId(rs.getInt("id"));
			}
		} 
		catch (Exception e) {
			user = null;
		}
		return user;
	}

	public static void saveBook(Book book) throws Exception {

		try(var con = createConnection()) {
			var query = """
					INSERT INTO books(code, title, price, publish_date, category_id, author_id, user_id)
					VALUES(?, ?, ?, ?, ?, ?, ?)
					""";
			
			var pstm = con.prepareStatement(query);
			
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setDouble(3, book.getPrice());
			pstm.setDate(4, Date.valueOf(book.getPublishDate()));
			pstm.setInt(5, book.getCategory().getId());
			pstm.setInt(6, book.getAuthor().getId());
			pstm.setInt(7, book.getCreate_by().getId());
			
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

	public static List<Book> findAllBook() {
		List<Book> list = new ArrayList<Book>();
		
		try(var con = createConnection()) {
			var query = """
					SELECT b.code,b.title,b.price,b.publish_date,c.name 'categoryName',a.name 'authorName',u.email 
					FROM books b, categories c, authors a, users u 
					WHERE b.category_id = c.id AND b.author_id = a.id AND b.user_id = u.id
					""";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				// create book
				var book = new Book();
				// bin column to field
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getDouble("price"));
				book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
				
				var created_by = new User();
				created_by.setEmail(rs.getString("email"));
				book.setCreate_by(created_by);
				
				var category = new Category();
				category.setName(rs.getString("categoryName"));
				book.setCategory(category);
				
				var author = new Author();
				author.setName(rs.getString("authorName"));
				book.setAuthor(author);
				
				// add obj to list
				list.add(book);
			
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Book findByCode(int id) {
		Book book = null;
		try(var con = createConnection()) {
			var query = """
					SELECT b.code,b.title,b.price,b.publish_date,c.name 'categoryName',a.name 'authorName',u.email 
					FROM books b, categories c, authors a, users u 
					WHERE b.category_id = c.id AND b.author_id = a.id AND b.user_id = u.id AND 
					b.code = ?
					""";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getDouble("price"));
				book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
				
				var created_by = new User();
				created_by.setEmail(rs.getString("email"));
				book.setCreate_by(created_by);
				
				var category = new Category();
				category.setName(rs.getString("categoryName"));
				book.setCategory(category);
				
				var author = new Author();
				author.setName(rs.getString("authorName"));
				book.setAuthor(author);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return book;
	}

	public static void updateBook(Book book) throws Exception {
		
		try(var con = createConnection()) {
			var query = """
					UPDATE books 
					SET title = ?, price = ?, publish_date = ?, author_id = ?, category_id = ?
					WHERE code = ?
					""";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, book.getTitle());
			pstm.setDouble(2, book.getPrice());
			pstm.setDate(3, Date.valueOf(book.getPublishDate()));
			pstm.setInt(4, book.getAuthor().getId());
			pstm.setInt(5, book.getCategory().getId());
			pstm.setInt(6, book.getCode());
			
			pstm.executeUpdate();
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

	public static List<Book> searchBook(String title, LocalDate date, String author, String category) {
		List<Book> list = new ArrayList<>();
		
		try(var con = createConnection()) {
			var query = """
					SELECT b.code,b.title,b.price,b.publish_date,c.name 'categoryName',a.name 'authorName' 
					FROM books b, categories c, authors a 
					WHERE b.category_id = c.id AND b.author_id = a.id 
					""";
			
			// dynamic query
			var params = new ArrayList<Object>();
			if(title != null && !title.isEmpty()) {
				query += " AND b.title LIKE ?";
				params.add( "%" + title + "%");
			}
			if(date != null) {
				query += " AND b.publish_date LIKE ?";
				params.add("%" + date + "%");
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
			for(var i = 0; i < params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				// create book
				var book = new Book();
				// bin column to field
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getDouble("price"));
				book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
				
				var cate = new Category();
				cate.setName(rs.getString("categoryName"));
				book.setCategory(cate);
				
				var auth = new Author();
				auth.setName(rs.getString("authorName"));
				book.setAuthor(auth);
				
				// add obj to list
				list.add(book);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean deleteBook(int id) throws Exception {
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
			result = false;
		}
		return result;
		
	}


	
//	public static void main(String[] args) throws SQLException {
//		createConnection();
//		System.out.println("Success");
//	}
}
