import javax.swing.text.html.parser.Parser;
import java.sql.*;

public class Main {
    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String NAME = "root";
    public static String PASS = "Vagram189";
    public static int i = 0;

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASS);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT " +
                    "course_name, count(subscription_date) purchase_date FROM PurchaseList group by course_name");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name" );
                String subscription_date = resultSet.getString("purchase_date");
                System.out.println(courseName + " - " + subscription_date);

            }
            resultSet.close();
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
    }
}
