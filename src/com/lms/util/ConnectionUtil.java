package com.lms.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/lmsv2?useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=America/Los_Angeles";
	public static String user = "root";
	public static String password = "merry@2019";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// load driver
		Class.forName(driver);
		// establish connection
		Connection conn = DriverManager.getConnection(url,user, password);
		// set auto commit to false
		conn.setAutoCommit(false);
		return conn;
	}
	private static void selectAllBook() {
		try {	
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// select all books from tbl_book
			String sql = "SELECT * FROM `tbl_book`;";
			
		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
		    // result of DB 
			//a ResultSet object that contains the data produced by the query; never null
			ResultSet result = pstmt.executeQuery();
		
			//print resultset 
			while (result.next()) {
				System.out.println(result.getString("bookId")+"  "+ result.getString("title")+"  "+result.getString("publisherId"));
			}	
			//commit 
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int insertBook(int bookId, String title,int publisherId) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// insert to tbl_book
			String sql = "INSERT INTO `lmsv2`.`tbl_book`(`bookId`,`title`,`publisherId`) VALUES(?,?,?);";
					
		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//set param objects 
			pstmt.setObject(1, bookId);
			pstmt.setObject(2, title);
			pstmt.setObject(3,publisherId);
			
			// result of DB 
			//
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			//print resultset 
			while (result.next()) {
				return result.getInt(1);
			}	
		
			//commit 
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	private static int updateBookandPublisher(int bookId, String title,int publisherId) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// insert to tbl_book
			
			String sql = "UPDATE `lmsv2`.`tbl_book` SET `title` = ?,`publisherId` = ? WHERE `bookId` = ?;";
					
		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//set param objects 
			pstmt.setObject(1, title);
			pstmt.setObject(2, publisherId);
			pstmt.setObject(3, bookId);
			
		    // result of DB 
			//
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			//print resultset 
			while (result.next()) {
				return result.getInt(1);
			}	
			//commit 
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static void selectAllAuthor() {
		try {
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected!");
			
			//select all authors from tbl_author 
			String sql = "SELECT * FROM `tbl_author`;";
			
			//get PreparedStateent object with sql 
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//result of databse 
			ResultSet result = pstmt.executeQuery();
			
			//print result set 
			while (result.next()) {
				System.out.println(result.getString("authorId")+" " + result.getString("authorName"));
			}
			//commit 
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	private static int insertAuthor(int authorId, String authorName) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// insert to tbl_book
			String sql = "INSERT INTO `lmsv2`.`tbl_author`(`authorId`,`authorName`) VALUES(?,?);" ;
		

		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//set param objects 
			pstmt.setObject(1, authorId);
			pstmt.setObject(2, authorName);
			
			// result of DB 
			//
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			//print resultset 
			while (result.next()) {
				return result.getInt(1);
			}	
			
			
			//commit 
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static int updateAuthor(int authorId, String authorName) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// insert to tbl_book
		String sql=	"UPDATE `lmsv2`.`tbl_author` SET `authorId` = 'authorId',`authorName` = ? WHERE `authorId` = ?;";


		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//set param objects 
			pstmt.setObject(1, authorId);
			pstmt.setObject(2,authorName);
			
		    // result of DB 
			//
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
		
			//print resultset 
			while (result.next()) {
				return result.getInt(1);
			}	
			//commit 
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static void selectAllBorrower() {
		try {	

			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// select all books from tbl_book
			String sql = "SELECT * FROM `tbl_borrower`;";
			
		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
		    // result of DB 
			//a ResultSet object that contains the data produced by the query; never null
			ResultSet result = pstmt.executeQuery();
		
			//print resultset 
			while (result.next()) {
				System.out.println(result.getString("cardNo")+"  "+ result.getString("name")+" "
						+ " "+result.getString("address")+
						" " + result.getString("phone"));
			}	
			//commit 
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static int insertBorrower(int cardNo, String name, String address, String phone) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "INSERT INTO `lmsv2`.`tbl_borrower`(`cardNo`,`name`,`address`,`phone`)VALUES(?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setObject(1, cardNo);
			pstmt.setObject(2, name);
			pstmt.setObject(3, address);
			pstmt.setObject(4, phone);
			
		
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			while (result.next()) {
				return result.getInt(1);
			}	
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static int updateBorrower(int cardNo, String name, String address, String phone) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// insert to tbl_borrower
			
			String sql= "UPDATE `lmsv2`.`tbl_borrower`SET`cardNo` = <{cardNo: }>,`name` = <{name: }>,`address` = <{address: }>,`phone` = <{phone: }> WHERE `cardNo` = <{?}>;";

		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//set param objects 
			pstmt.setObject(1, cardNo);
			pstmt.setObject(2,name);
			pstmt.setObject(3, address);
			pstmt.setObject(4, phone);
			
		    // result of DB 
			//
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
		
			//print resultset 
			while (result.next()) {
				return result.getInt(1);
			}	
			//commit 
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static void selectAllGenre() {
		try {	
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// select all books from tbl_genre
			String sql = "SELECT * FROM `tbl_genre`;";
			
		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
		    // result of DB 
			//a ResultSet object that contains the data produced by the query; never null
			ResultSet result = pstmt.executeQuery();
		
			//print resultset 
			while (result.next()) {
				System.out.println(result.getString("genreId")+ "  "+ result.getString("genreName"));
			}	
			//commit 
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static int insertGenre(int genreId, String genreName) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "INSERT INTO `lmsv2`.`tbl_genre`(`genreId`,`genreName`)VALUES(?,?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setObject(1, genreId);
			pstmt.setObject(2, genreName);
			
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			while (result.next()) {
				return result.getInt(1);
			}	
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static int updateGenre(int genreId, String genreName) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// insert to tbl_genre
			String sql = "UPDATE `lmsv2`.`tbl_genre` SET `genreId` = ?,`genreName` = ? WHERE `genreId` = ?;";

		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//set param objects 
			pstmt.setObject(1, genreId);
			pstmt.setObject(2,genreName);
			
		    // result of DB 
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
		
			//print resultset 
			while (result.next()) {
				return result.getInt(1);
			}	
			//commit 
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static void selectAllPublisher() {
		try {	
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// select all books from tbl_genre
			String sql = "SELECT * FROM `tbl_publisher`;";
			
		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
		    // result of DB 
			//a ResultSet object that contains the data produced by the query; never null
			ResultSet result = pstmt.executeQuery();
		
			//print resultset 
			while (result.next()) {
				
				System.out.println(result.getString("publisherId")+ "  "+ result.getString("publisherName") + 
						" " + result.getString("publisherAddress") + " " + result.getString("publisherPhone"));
			}	
			//commit 
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static int insertPublisher(int publisherId, String publisherName, String publisherAddress, String publisherPhone) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "INSERT INTO `lmsv2`.`tbl_publisher`(`publisherId`,`publisherName`,`publisherAddress`,`publisherPhone`)VALUES(?,?,?,?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setObject(1, publisherId);
			pstmt.setObject(2, publisherName);
			pstmt.setObject(3, publisherAddress);
			pstmt.setObject(4, publisherPhone);

			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			while (result.next()) {
				return result.getInt(1);
			}	
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static int updatePublisher(int publisherId, String publisherName, String publisherAddress, String publisherPhone) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			// insert to tbl_book
			
			String sql = "UPDATE `lmsv2`.`tbl_publisher` SET `publisherId` = ?,`publisherName` = ?,`publisherAddress` = ?,`publisherPhone` = ? WHERE `publisherId` = ?;";
					
		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//set param objects 
			pstmt.setObject(1, publisherId);
			pstmt.setObject(2, publisherName);
			pstmt.setObject(3, publisherAddress);
			pstmt.setObject(4, publisherPhone);
		    // result of DB 
			//
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			//print resultset 
			while (result.next()) {
				return result.getInt(1);
			}	
			//commit 
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static void selectAllBookandAuthors() {
		try {	
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "SELECT * FROM `tbl_book_authors`;";
			
		    // get preparedstatment object (with sql )
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
		    // result of DB 
			//a ResultSet object that contains the data produced by the query; never null
			ResultSet result = pstmt.executeQuery();
		
			//print resultset 
			while (result.next()) {
				
				System.out.println(result.getString("bookId")+ "  "+ result.getString("authorId"));
			}	
			//commit 
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int insertBookandAuthors(int bookId, int authorId) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "INSERT INTO `lmsv2`.`tbl_book_authors`(`bookId`,`authorId`)VALUES(?,?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setObject(1, bookId);
			pstmt.setObject(2, authorId);
			
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			while (result.next()) {
				return result.getInt(1);
			}	
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	private static void selectAllBookandCopies() {
		try {	
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "SELECT * FROM `tbl_book_copies`;";

			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet result = pstmt.executeQuery();
		 
			while (result.next()) {
				System.out.println(result.getString("bookId")+ "  "+ result.getString("branchId") 
				+ "  "+ result.getString("noOfCopies"));
			}	
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int insertBookandCopies(int bookId, int branchId, int noOfCopies) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "INSERT INTO `lmsv2`.`tbl_book_copies`(`bookId`,`branchId`,`noOfCopies`)VALUES(?,?,?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setObject(1, bookId);
			pstmt.setObject(2, branchId);
			pstmt.setObject(3, noOfCopies);
			
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			while (result.next()) {
				return result.getInt(1);
			}	
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	private static int updateBookandCopies(int bookId, int branchId, int noOfCopies) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
							
			String sql = "UPDATE `lmsv2`.`tbl_book_copies` SET `bookId` = ?,`branchId` = ?,`noOfCopies` = ? WHERE `bookId` = ?;";
					
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setObject(1, bookId);
			pstmt.setObject(1, branchId);
			pstmt.setObject(2, noOfCopies);
			
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			while (result.next()) {
				return result.getInt(1);
			}	 
			con.commit();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	private static void selectAllBookandGenres() {
		try {	
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "SELECT * FROM `tbl_book_genres`;";

			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet result = pstmt.executeQuery();
		 
			while (result.next()) {
				System.out.println(result.getString("genreId")+ "  "+ result.getString("bookId") );
			}	
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int insertBookandGenres(int genreId, int bookId) {
		try {
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println("Successfully connected");
				
			String sql = "INSERT INTO `lmsv2`.`tbl_book_genres`(`genreId`,`bookId`)VALUES(?,?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setObject(1, genreId);
			pstmt.setObject(2, bookId);
		
			pstmt.executeUpdate();
			
			ResultSet result=pstmt.getGeneratedKeys();
			
			while (result.next()) {
				return result.getInt(1);
			}	
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

private static void selectAllBookandLoans() {
	try {	
		Connection con = ConnectionUtil.getConnection();
		System.out.println("Successfully connected");
			
		String sql = "SELECT * FROM `tbl_book_loans`;";

		PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = pstmt.executeQuery();
	 
		while (result.next()) {
			System.out.println(result.getString("bookId")+ "  "+ result.getString("branchId")
			+ " "+ result.getString("cardNo")+ " "+ result.getString("dateOut")
			+ " "+ result.getString("dueDate")+ " "+ result.getString("dateIn"));
		}	
		con.commit();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static int insertBookandLoans(int bookId, int branchId, int cardNo, Date dateOut, Date dueDate, Date dateIn ) {
	try {
		
		Connection con = ConnectionUtil.getConnection();
		System.out.println("Successfully connected");
			
		String sql = "INSERT INTO `lmsv2`.`tbl_book_loans`(`bookId`,`branchId`,`cardNo`,`dateOut`,`dueDate`,`dateIn`)"
				+ "VALUES(?,?,?,?,?,?);";
		
		PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pstmt.setObject(1, bookId);
		pstmt.setObject(2, branchId);
		pstmt.setObject(3, cardNo);
		pstmt.setObject(4, dateOut);
		pstmt.setObject(5, dueDate);
		pstmt.setObject(6, dateIn);
	
		pstmt.executeUpdate();
		
		ResultSet result=pstmt.getGeneratedKeys();
		
		while (result.next()) {
			return result.getInt(1);
		}	
		con.commit();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;
}
private static void selectAllLibraryBranch() {
	try {	
		Connection con = ConnectionUtil.getConnection();
		System.out.println("Successfully connected");
			
		String sql = "SELECT * FROM `tbl_library_branch`;";

		PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = pstmt.executeQuery();
	 
		while (result.next()) {
			System.out.println(result.getString("branchId")+ "  "+ result.getString("branchName")
			+ " "+ result.getString("branchAddress"));
		}	
		con.commit();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static int insertLibraryBranch(int branchId, String branchName, String branchAddress ) {
	try {
		
		Connection con = ConnectionUtil.getConnection();
		System.out.println("Successfully connected");
			
		String sql = "INSERT INTO `lmsv2`.`tbl_library_branch`(`branchId`,`branchName`,`branchAddress`) VALUES(?, ?, ?);";
		
		PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pstmt.setObject(1, branchId);
		pstmt.setObject(2, branchName);
		pstmt.setObject(3, branchAddress);

		pstmt.executeUpdate();
		
		ResultSet result=pstmt.getGeneratedKeys();
		
		while (result.next()) {
			return result.getInt(1);
		}	
		con.commit();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;
}
private static int updateLibraryBranch(int branchId, String branchName, String branchAddress) {
	try {
		Connection con = ConnectionUtil.getConnection();
		System.out.println("Successfully connected");
						
		String sql = "UPDATE `lmsv2`.`tbl_library_branch` SET `branchId` = ?,`branchName` = ?,`branchAddress` = ? WHERE `branchId` = ?;";
				
		PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		pstmt.setObject(1, branchId);
		pstmt.setObject(2, branchName);
		pstmt.setObject(3, branchAddress);
		pstmt.setObject(4, branchId);

		pstmt.executeUpdate();
		
		ResultSet result=pstmt.getGeneratedKeys();
		
		while (result.next()) {
			return result.getInt(1);
		}	 
		con.commit();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;
}
	public static void main(String args[]) {
//		insertBook(16, "To Kill a Mockingbird ",10);
//		updateBookandPublisher(16, "To Kill a MockingBird ",10);
//		selectAllBook();
		
//		selectAllAuthor();
//		insertAuthor(6, "Merhawit Gezahegn");
//		updateAuthor(6, "Merhawit Ambaye Gezahegn");
		
//		selectAllBorrower();
//		updateBorrower(6, "Summer Walker", "Washington DC.", "202-343-0223");
		
//		selectAllGenre();
//		insertGenre(16, "Horor Fiction");
//		updateGenre(16, "Horror Fiction");
		
//		selectAllPublisher();
//		insertPublisher(11, "Arlington Publishing", "New York, Ny", "N/A");
//		updatePublisher(11, "Arlington Publishing", "New York, NY.", "N/A");
		
//		insertBookAndAuthors(16,4);
//		updateBookandAuthors(16,2);
//		selectAllBookandAuthors();
		
//		insertBookandCopies(6, 3, 15);
//		selectAllBookandCopies();
//		updateBookandCopies(6, 3, 16);
		
//		selectAllBookandGenres();
//		insertBookandGenres(16,12);
		
//		 insertBookandLoans(0, 0, 0, null, null, null);
//		selectAllBookandLoans();
		
//		selectAllLibraryBranch();
//		insertLibraryBranch(6, "Silver Spring Library", "Silver spring Maryland.");
//		updateLibraryBranch(6, "Silver Spring Library", "123 Rowned st, Silver spring.MD");

		
	}
}





