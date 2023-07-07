import java.sql.*;
//GA7-220501096-AA2-EV01
public class DatabaseConnector {
    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3308/DatabaseConnector";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";

    public static void main(String[] args) {
        try {
            // Establecer la conexión
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Ejemplo de inserción de datos
            insertData(connection, "John Doe", 25);

            // Ejemplo de consulta de datos
            String name = "John Doe";
            int age = getData(connection, name);
            System.out.println(name + " tiene " + age + " años.");

            // Ejemplo de actualización de datos
            int newAge = 30;
            updateData(connection, name, newAge);

            // Verificar la actualización
            age = getData(connection, name);
            System.out.println(name + " ahora tiene " + age + " años.");

            // Ejemplo de eliminación de datos
            deleteData(connection, name);

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Connection connection, String name, int age) throws SQLException {
        String query = "INSERT INTO usuarios (nombre, edad) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.executeUpdate();
        statement.close();
    }

    private static int getData(Connection connection, String name) throws SQLException {
        int age = -1;
        String query = "SELECT edad FROM usuarios WHERE nombre = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            age = resultSet.getInt("edad");
        }
        resultSet.close();
        statement.close();
        return age;
    }

    private static void updateData(Connection connection, String name, int newAge) throws SQLException {
        String query = "UPDATE usuarios SET edad = ? WHERE nombre = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, newAge);
        statement.setString(2, name);
        statement.executeUpdate();
        statement.close();
    }

    private static void deleteData(Connection connection, String name) throws SQLException {
        String query = "DELETE FROM usuarios WHERE nombre = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.executeUpdate();
        statement.close();
    }
}

