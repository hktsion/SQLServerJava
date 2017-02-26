package accesodatos_sqlserver.classe_criminale;

/**
 * @version 1.1;
 * @author h3kt0r;
 * @see hectorochoa.es
 */
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public abstract class Excel {

    /**
     *
     * @return Devuelve información del SO y ruta para crear el fichero excell;
     * @throws IOException
     */
    public static String[] creaFichero() throws IOException {
        String[] data
                = {"c:\\HECTOR\\LugaresTuristicos.xls", System.getProperty("os.name")};
        File f = new File("c:\\HECTOR");
        f.mkdir();
        System.out.println("Creando carpeta HECTOR");
        return data;
    }

    /**
     *
     * @param rs Es un resultSet de todos los registros de la Tabla_ciudades;
     * @param ruta La ruta donde se va crear el excell;
     * @return true si el fichero se ha creado;
     */
    public static boolean newExcelBook(ResultSet rs, String ruta) {
        try {
            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");

            WritableWorkbook libro
                    = Workbook.createWorkbook(new File(ruta), conf);
            WritableSheet hoja = libro.createSheet("lugares_turisticos", 0);
            
            WritableFont font
                    = new WritableFont(WritableFont.TAHOMA, 9, WritableFont.NO_BOLD);
            WritableCellFormat formartoDatos = new WritableCellFormat(font);
            WritableFont fontCabecera
                    = new WritableFont(WritableFont.TAHOMA, 9, WritableFont.BOLD);
            WritableCellFormat formatoCabecera
                    = new WritableCellFormat(fontCabecera);

            ArrayList<Ciudad> listaCiudades = new ArrayList();
            while (rs.next()) {
                Ciudad city = new Ciudad();
                city.setId(rs.getObject(1).toString());
                city.setPais(rs.getObject(2).toString());
                city.setCiudad(rs.getObject(3).toString());
                city.setRuta_imagen(rs.getObject(4).toString());
                city.setAux(rs.getObject(5).toString());
                city.setLugares(rs.getObject(6).toString());

                listaCiudades.add(city);
            }

            //Encabezados de las columnas
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                System.out.println("Creando cabecera: " + rsmd.getColumnName(i + 1));
                hoja.addCell(new jxl.write.Label(i, 0, rsmd.getColumnName(i + 1), formatoCabecera));
            }

            //Inserción de datos de los destinos;
            System.out.println("LISTA CIUDADES: " + listaCiudades.size());
            for (int i = 0; i < listaCiudades.size(); i++) {
                String[][] datos = new String[listaCiudades.size()][6];
                datos[i][0] = listaCiudades.get(i).getId();
                datos[i][1] = listaCiudades.get(i).getPais();
                datos[i][2] = listaCiudades.get(i).getCiudad();
                datos[i][3] = listaCiudades.get(i).getRuta_imagen();
                datos[i][4] = listaCiudades.get(i).getAux();
                datos[i][5] = listaCiudades.get(i).getLugares();
                System.out.println("Insertando fila:" + i);
                for (int j = 0; j < 6; j++) {
                    //Creando Filas
                    hoja.addCell(new jxl.write.Label(j, i + 1, datos[i][j], formartoDatos));
                }
            }

            libro.write();
            libro.close();
            System.out.println("Libro Excel creado y datos exportados;");
            return true;

        } catch (SQLException ex) {
            System.out.println("No ha sido posible crear el libro Excel; ERROR SQL");
            return false;
        } catch (WriteException ex) {
            System.out.println("No ha sido posible crear el libro Excel; ERROR DE ESCRITURA");
            return false;
        } catch (IOException ex) {
            System.out.println("No ha sido posible crear el libro Excel; ERROR DE ENTRADA SALIDA");
            return false;
        }
    }
}
