package application;

public class ApplicationData {

	private static ApplicationData instance = null;
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String DB_PATH = "jdbc:mysql://localhost:3307/zamowienia";
	private final static String USER = "sklepikarz";
	private final static String PASSWORD = "haselko";

	private ApplicationData() {
	}

	public static synchronized ApplicationData getInstance() {

		if (instance == null) {
			instance = new ApplicationData();
		}

		return instance;

	}

	public static String getDriver() {
		return DRIVER;
	}

	public static String getDbPath() {
		return DB_PATH;
	}

	public static String getUser() {
		return USER;
	}

	public static String getPassword() {
		return PASSWORD;
	}

	public static void setInstance(ApplicationData instance) {
		ApplicationData.instance = instance;
	}

}

// Connection conn = DriverManager.getConnection(dbPath, "root", "admin");
//Connection conn = DriverManager.getConnection(dbPath, "root", "admin");

//Statement statement = conn.createStatement();
//final String sqlQuery = "SELECT Name, Population FROM city";
//
//final String sqlQuery = "SELECT Name, Population FROM city";
//ResultSet resultSet = statement.executeQuery(sqlQuery); 
//String cityName = null;
//int cityPopulation = 0;
//while(resultSet.next()) {
//    cityName = resultSet.getString("Name");
//    cityPopulation = resultSet.getInt("Population");
//    System.out.println(cityName + " " + cityPopulation);
//}