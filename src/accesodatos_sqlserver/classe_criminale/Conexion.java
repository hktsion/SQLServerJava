package accesodatos_sqlserver.classe_criminale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @version 1.1;
 * @author h3kt0r;
 * @see hectorochoa.es
 */
public class Conexion {

    private Connection conn = null;

    public Connection getConexionSQLServer() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn
                    = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DESTINOS", "sa", "madrid01");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE HA PODIDO REALIZAR LA CONEXION");
        }
        return conn;
    }
}
