package accesodatos_sqlserver.classe_criminale;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @version 1.1;
 * @author h3kt0r;
 * @see hectorochoa.es
 */
public class CRUD {

    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public CRUD() {
        try {
            if ((con = conexion.getConexionSQLServer()) == null) {
                JOptionPane.showMessageDialog(null, "Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
            System.out.println("Conectado a la DB");
        } catch (HeadlessException | SQLException e) {
            e.getMessage();
        }
    }

    //Devuelve el resultset de todos los destinos
    public ResultSet selectXtodas() {
        try {
            String query
                    = "USE DESTINOS; select ciudades._ID, ciudades.PAIS, ciudades.CIUDAD, lugares._IDLUG, lugares.LUGAR, lugares.IMAGEN FROM ciudades INNER JOIN lugares ON ciudades._ID = lugares._IDCIU ORDER BY ciudades._ID;";
            rs = st.executeQuery(query);
            System.out.println("Se ha hecho un select all");
            return rs;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    //Inserta destino en la Base de Datos
    public boolean insert(Ciudad city) {
        String photoimg = (city.getRuta_imagen().length() != 0)
                ? city.getRuta_imagen() : "../img/default.png";

        System.out.println(city.getId() + " " + city.getPais() + " " + city.getCiudad() + " " + city.getLugares() + " " + city.getRuta_imagen());
        try {
            String query
                    = "USE DESTINOS; INSERT INTO ciudades VALUES('" + city.getId() + "','" + city.getPais() + "','" + city.getCiudad() + "');";
            String query2
                    = "USE DESTINOS; INSERT INTO lugares VALUES('" + JavaUtils.generarPrimaryKey() + "', '" + city.getLugares() + "','" + photoimg + "','" + city.getId() + "');";
            st.executeUpdate(query);
            st.executeUpdate(query2);
            System.out.println("Se ha insertado un nuevo registro: " + city.getId());
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    //Elimina destino
    public boolean delete(String cadena) {
        ArrayList<Ciudad> compareArrayList = new ArrayList<>();
        try {
            String query
                    = "USE DESTINOS; DELETE TOP(1) FROM ciudades WHERE CIUDAD = '" + cadena + "'";
            ResultSet resultSetDelete = selectX_CIUDAD(cadena);
            while (resultSetDelete.next()) {
                Ciudad ciudadXActiualizar = new Ciudad();

                ciudadXActiualizar.setId(resultSetDelete.getObject(1).toString());
                ciudadXActiualizar.setPais(resultSetDelete.getObject(2).toString());
                ciudadXActiualizar.setCiudad(resultSetDelete.getObject(3).toString());

                compareArrayList.add(ciudadXActiualizar);
            }
            System.out.println("SIZE: " + compareArrayList.size());
            if (compareArrayList.size() > 0) {
                st.executeUpdate(query);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    //Actualiza los datos de destinos;
    public boolean update(Ciudad city, boolean flaglugar) throws SQLException {

        ArrayList<Ciudad> compareArrayList = new ArrayList<>();
        String found = "Destino ";

        //Comparo el resulset del _ID introducido con los _ID de la DB;
        ResultSet rs = selectX_IDLUG(city);
        while (rs.next()) {
            Ciudad ciudadXActiualizar = new Ciudad();
            ciudadXActiualizar.setId(rs.getObject(1).toString());
            ciudadXActiualizar.setPais(rs.getObject(2).toString());
            ciudadXActiualizar.setCiudad(rs.getObject(3).toString());
            ciudadXActiualizar.setRuta_imagen(rs.getObject(4).toString());

            compareArrayList.add(ciudadXActiualizar);
        }

        //para size() == 0 el id que he introducido no se encuentra en mi base de datos;
        found += (compareArrayList.size() > 0) ? "FOUND" : "NOT FOUND";
        System.out.println(found + " " + compareArrayList.size());

        //Construyo la query según los datos del formulario;
        String id = city.getId().trim();
        String pais = city.getPais();
        String ciudad = city.getCiudad();
        String idlug = city.getAux();
        String lug = city.getLugares();

        String query = "";
        if (pais.length() != 0 || ciudad.length() != 0) {
            query = "USE DESTINOS; UPDATE ciudades SET ";
            if (pais.length() != 0) {
                query += "PAIS = '" + pais + "'";
                if (ciudad.length() != 0) {
                    query += ", CIUDAD = '" + ciudad + "'";
                }
            } else {
                if (ciudad.length() != 0) {
                    query += "CIUDAD = '" + ciudad + "'";
                }
            }
            query += " WHERE _ID = '" + id + "';";
        }

        //Fin de la query;
        //Si la _ID se encuentra en la base de datos ejecuto la query;
        try {
            if (compareArrayList.size() > 0) {
                String querylugares = "";
                switch (query.length()) {
                    case 0:
                        if (flaglugar) {
                            querylugares
                                    = "USE DESTINOS; UPDATE lugares SET LUGAR = '" + lug + "' WHERE _IDLUG = '" + idlug + "';";
                            st.executeUpdate(querylugares);
                        }
                        break;
                    default:
                        if (flaglugar) {
                            querylugares
                                    = "USE DESTINOS; UPDATE lugares SET LUGAR = '" + lug + "' WHERE _IDLUG = '" + idlug + "';";
                            st.executeUpdate(querylugares);
                            st.executeUpdate(query);
                        } else {
                            st.executeUpdate(query);
                        }
                        break;
                }
                System.out.println("Actualizado registro.");
                return true;
            } else {
                System.out.println("El _ID introducido no existe");
                return false;
            }
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    //Devuelve los datos del destino que hay que actualizar: 
    //Lo uso para ver si el ID que he introducido está en mi base de datos
    public ResultSet selectX_IDLUG(Ciudad ciudad) {
        try {
            String query
                    = "SELECT ciudades._ID, ciudades.PAIS, ciudades.CIUDAD, lugares._IDLUG, lugares.LUGAR FROM ciudades INNER JOIN lugares ON '" + ciudad.getId() + "' = '" + ciudad.getId() + "';";
            rs = st.executeQuery(query);
            System.out.println("Seleccionado registro con id = " + ciudad.getId());
            return rs;
        } catch (Exception e) {
            System.out.println("No se puede seleccionar el registro con id = " + ciudad.getId());
            e.getMessage();
            return null;
        }
    }

    //Devuelve los datos del destino que hay que b: 
    //Lo uso para ver si la ciudad a borrar existe;
    public ResultSet selectX_CIUDAD(String cityString) {
        try {
            String query
                    = "USE DESTINOS; SELECT * FROM ciudades WHERE CIUDAD = '" + cityString + "';";
            rs = st.executeQuery(query);
            System.out.println("Seleccionado registro con id = " + cityString);
            return rs;
        } catch (Exception e) {
            System.out.println("No existen registros con id = " + cityString);
            e.getMessage();
            return null;
        }
    }
}
