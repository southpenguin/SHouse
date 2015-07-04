import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseManager{
	public static final String url = "jdbc:mysql://some_url_of_database";
	public static final String user = "admin";
	public static final String pw = "admin";
	public static final String driver = "com.mysql.jdbc.Driver";

	public static Database instance = null;

	Connection conn;
	Statement stmt;

	//constructor
	public Database(Connection conn, Statement stmt){
		this.conn = conn;
		this.stmt = stmt;
	}

	//some DBManager methods
	public static DatabaseManager getDBManager(){
		if(instance == null) instance =  new DatabaseManager();
		return instance;
	}

	public void close(){
		
	}
}