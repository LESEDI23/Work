import java.sql.*;
public class InsertTest {

	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db?useSSL=false" , "myuser" ,"luna");
			Statement stmt = conn.createStatement();
			
			// DELETE records and return number of records updated
			String strDelete = "delete from books where id between 3000 and 4000";
			System.out.println("The SQL query is: " + strDelete);
			int countDeleted = stmt.executeUpdate(strDelete);
			System.out.println(countDeleted + " records deleted\n");
			
			//INSERT a record
			String strInsert = "insert into books" +" values (3001, 'Programming 101', 'Jane Doe', 1)" ;
			System.out.println("The SQL query is: " + strInsert);
			int countInserted = stmt.executeUpdate(strInsert);
			System.out.println(countInserted + " records updated\n");
			
			//INSERT multiple records
			strInsert = "insert into books values"
					+"(3002, 'Programming 101 2nd Edition', 'Jane Doe',2),"
					+"(3003, 'Programming 101 3rd Edition', 'Jane Doe',3)";
			System.out.println("The SQL query is: " + strInsert);
			System.out.println(countInserted + " records inserted\n");
			
			//INSERT a partial record
			strInsert = "insert into books (id,title,author)" + "values (3004, 'Java is fun!','Kevin Peters')";
			System.out.println("The SQL query is " + strInsert);
			countInserted = stmt.executeUpdate(strInsert);
			System.out.println(countInserted + " records inserted.\n");
			
			//Issue a SELECT to check the changes
			String strSelect = "select * from books";
			System.out.println("The SQL query is: " + strSelect);
			ResultSet rset = stmt.executeQuery(strSelect);
			
			while(rset.next()) {
				System.out.printf ("%d, %s, %s, %d\n",
						rset.getInt("id"),
						rset.getString("author"),
						rset.getString("title"),
						rset.getInt("qty"));
			}
			
			System.out.println();
			
			//Modify the Java program UpdateTest.java to set the qty for Introduction to Java to 0.
			String strModify = "UPDATE books SET qty = 0 WHERE title = 'Introduction to Java'";
			System.out.println("The SQL query is: " + strModify);
			int countModified = stmt.executeUpdate(strModify);
			System.out.println(countModified + " records modified.\n");
			
			//Modify the Java program InsertTest.java to delete all books with id > 8000; 
			strDelete = "DELETE FROM books WHERE id > 8000";
			System.out.println("The SQL query is : " + strDelete);
			countDeleted = stmt.executeUpdate(strDelete);
			System.out.println(countDeleted + " records deleted\n");
			
			//and insert: (8001, 'Java ABC', 'Kevin Jones', 3) and (8002, 'Java XYZ', 'Kevin Jones', 5);
			strModify = "INSERT into books values" 
			+ "(8001, 'Java ABC', 'Kevin Jones', 3),"
			+ "(8002, 'Java XYZ', 'Kevin Jones', 5)";
			System.out.println("The SQL query is " + strModify);
			countModified = stmt.executeUpdate(strModify);
			System.out.println(countModified + " records updated");

			
		}catch (SQLException ex) {
			ex.printStackTrace();}
			

	}

}
