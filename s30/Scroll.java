import java.sql.*;

public class Scroll {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "", "");

            
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

         
            resultSet = statement.executeQuery("SELECT * FROM Teacher");

            
            resultSet.last();

            
            int totalRows = resultSet.getRow();

            resultSet.beforeFirst();

          
            System.out.println("Teacher Table:");
            System.out.println("TNo\tTName\tSalary");
            while (resultSet.next()) {
                int tid = resultSet.getInt("TNo");
                String tname = resultSet.getString("TName");
                String salary = resultSet.getString("Salary");
                System.out.println(tid + "\t" + tname + "\t" + salary);
            }

        
            System.out.println("Total Rows: " + totalRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
         
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
