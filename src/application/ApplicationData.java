package application;

public class ApplicationData {

	private static ApplicationData instance = null;
	
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String DB_PATH = "jdbc:mysql://localhost:3307/zamowienia";
	private final static String USER = "sklepikarz";
	private final static String PASSWORD = "haselko";
	
	private static boolean isOrderLoaded = false;
	private static boolean isCustomerLoaded = false;
	private static boolean isCategoryLoaded = false;
	private static boolean isProductLoaded = false;

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

	public static boolean isOrderLoaded() {
		return isOrderLoaded;
	}

	public static void setOrderLoaded(boolean isOrderLoaded) {
		ApplicationData.isOrderLoaded = isOrderLoaded;
	}

	public static boolean isCustomerLoaded() {
		return isCustomerLoaded;
	}

	public static void setCustomerLoaded(boolean isCustomerLoaded) {
		ApplicationData.isCustomerLoaded = isCustomerLoaded;
	}

	public static boolean isCategoryLoaded() {
		return isCategoryLoaded;
	}

	public static void setCategoryLoaded(boolean isCategoryLoaded) {
		ApplicationData.isCategoryLoaded = isCategoryLoaded;
	}

	public static boolean isProductLoaded() {
		return isProductLoaded;
	}

	public static void setProductLoaded(boolean isProductLoaded) {
		ApplicationData.isProductLoaded = isProductLoaded;
	}

}
