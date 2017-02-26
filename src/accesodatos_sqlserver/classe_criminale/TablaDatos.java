package accesodatos_sqlserver.classe_criminale;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 1.1;
 * @author h3kt0r;  
 * @see hectorochoa.es
 */
public class TablaDatos {

    //Devuelve el número de columnas( ENCABEZADOS --> metadata);
    public int nrw(ResultSet rs) {
        int cols = 0;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            cols = rsmd.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(TablaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cols;
    }

    public String colNm(ResultSet rs, int column) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        String colLbl = rsmd.getColumnLabel(column);
        return colLbl;
    }

}
