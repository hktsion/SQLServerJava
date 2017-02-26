package accesodatos_sqlserver.classe_criminale;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @version 1.1;
 * @author h3kt0r;
 * @see hectorochoa.es
 */
public class PDF {

    public static boolean newPDFDoc(File file, ResultSet rs) {

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            FileOutputStream archivo = new FileOutputStream(file.getAbsolutePath() + ".pdf");

            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            PdfWriter.getInstance((com.itextpdf.text.Document) doc, archivo);

            //Creando el documento;
            doc.open();
            doc.addTitle("Destinos turísticos");
            doc.addAuthor("Héctor Ochoa");

            ArrayList<Ciudad> listaCiudades = new ArrayList();
            while (rs.next()) {
                Ciudad city = new Ciudad();
                city.setId(rs.getObject(1).toString());
                city.setAux(rs.getObject(2).toString());
                city.setPais(rs.getObject(3).toString());
                city.setCiudad(rs.getObject(4).toString());
                city.setRuta_imagen(rs.getObject(5).toString());
                city.setLugares(rs.getObject(6).toString());
                listaCiudades.add(city);
            }

            System.out.println("LISTA CIUDADES: " + listaCiudades.size());
            doc.add(new Paragraph("LISTADO DE DESTINOS\n\n", new Font(Font.FontFamily.COURIER, 20, Font.BOLD)));
            for (int i = 0; i < listaCiudades.size(); i++) {
                String[][] datos = new String[listaCiudades.size()][6];
                datos[i][0] = listaCiudades.get(i).getId();
                datos[i][1] = listaCiudades.get(i).getPais();
                datos[i][2] = listaCiudades.get(i).getCiudad();
                datos[i][3] = listaCiudades.get(i).getRuta_imagen();
                datos[i][4] = listaCiudades.get(i).getAux();
                datos[i][5] = listaCiudades.get(i).getLugares();
                System.out.println("Insertando fila:" + i);
                doc.add(new Paragraph(
                        "" + rsmd.getColumnName(1).substring(1) + ": " + datos[i][0] + "\n"
                        + rsmd.getColumnName(5).substring(1) + "AR: " + datos[i][3] + "\n"
                        + rsmd.getColumnName(2) + ": " + datos[i][4] + "\n"
                        + rsmd.getColumnName(3) + ": " + datos[i][1] + "\n"
                        + "RUTA " + rsmd.getColumnName(4) + ": " + datos[i][2] + "\n"
                        + rsmd.getColumnName(6) + " TURÍSTICO: " + datos[i][5] + "\n"
                        + "\n\n", new Font(Font.FontFamily.COURIER, 16, Font.NORMAL)));
            }
            //Cierro el documento;
            doc.close();
        } catch (SQLException ex) {
            System.out.println("No ha sido posible crear el documento; ERROR SQL");
            return false;
        } catch (IOException ex) {
            System.out.println("No ha sido posible crear el documento; ERROR DE ENTRADA SALIDA");
            return false;
        } catch (DocumentException ex) {
            System.out.println("No ha sido posible crear el documento; DOCUMENT EXCEPTION");
        }
        return true;
    }
}
