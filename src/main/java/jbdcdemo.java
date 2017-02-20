import java.sql.*;

/**
 * Created by meltzer on 15.02.17.
 */
public class jbdcdemo {
    public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String protocol = "jdbc:derby:";
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection connectionWrapper = null;
        //try with resources (need to implement closable of autoclosable)
        try (
            Connection connection
                    = DriverManager.getConnection(protocol + "derbyDB;create=true")
                ) {
            connectionWrapper = connection;
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            final PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO table_name VALUES(?,?)");
            insertStatement.setInt(1, 1);
            insertStatement.setInt(2, 2);
            insertStatement.executeUpdate();

            final PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM table_name");
            final ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("f1: " + resultSet.getInt("COLUMN_1"));
                System.out.println("f2: " + resultSet.getString("COLUMN_2"));
            }

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
