package EndTermProject;

public class key {
    private static String pass = "12345";
    private static String user = "postgres";

    private static String url = "jdbc:postgresql://localhost:5432/Pharmacy";
    public static String getPass() {
        return pass;
    }
    public static String getUser() {
        return user;
    }

    public static String getUrl() {
        return url;
    }
}
